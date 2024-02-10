package fruitfly.ide;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import fruitfly.psi.BuilderGenerator;
import org.jetbrains.annotations.NotNull;

import static com.intellij.psi.util.PsiTreeUtil.getParentOfType;
import static fruitfly.ide.IdeaConstant.GENERATE_GROUP;
import static fruitfly.ide.PluginConstant.NOTIFICATION_GROUP_ID;
import static fruitfly.util.Log.log;

public class BuilderAction extends AnAction {


  public BuilderAction() {
    super(
      /* this is the entry you see in the generate menu.
        Set event.presentation.text in update() method if you want the
        value to be dynamic. */
      "Fruitfly Builder",
      /* used in tooltips and other places where there's more space" */
      "Generate a Builder pattern for the record",
      null);
  }

  static void register() {
    ActionManager actionManager = ActionManager.getInstance();
    var action = new BuilderAction();

    actionManager.registerAction(
      BuilderAction.class.getName(),
      action);

    DefaultActionGroup generateGroup = (DefaultActionGroup)
      actionManager.getAction(GENERATE_GROUP);
    generateGroup.add(action);
  }

  @Override
  public @NotNull ActionUpdateThread getActionUpdateThread() {
    return ActionUpdateThread.BGT;
  }

  @Override
  public void update(@NotNull AnActionEvent event) {
    // log("update()");
    Project project = event.getProject();
    Editor editor = event.getData(CommonDataKeys.EDITOR);
    if( project == null || editor == null ){
      event.getPresentation().setEnabledAndVisible(false);
      return;
    }

    if( !ApplicationManager.getApplication().isReadAccessAllowed() ){
      /* this branch was added when I was trying something else,
        logging it to see when it actually happens, if ever? */
      log("readAccessAllowed=false");
      event.getPresentation().setEnabledAndVisible(false);
      return;
    }

    event.getPresentation().setEnabledAndVisible(isRecord(event) != null);
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent event) {

    Project project = event.getProject();
    Editor editor = event.getData(CommonDataKeys.EDITOR);
    if( project == null || editor == null ){
      log("actionPerformed() no project or editor");
      return;
    }

    var psiClass = isRecord(event);
    if( psiClass == null ){
      log("actionPerformed() when not a record");
      return;
    }


    if( !showConfirmation(project, psiClass) ){
      return;
    }


    WriteCommandAction.runWriteCommandAction(psiClass.getProject(), ()->{
      log("generate the builder");
      var generator = new BuilderGenerator(psiClass);
      generator.generateBuilderClass();
    });


    Notification notification = new Notification(
      NOTIFICATION_GROUP_ID,
      "Action triggered",
      "GenerateRecordBuilder was triggered",
      NotificationType.INFORMATION
    );
    Notifications.Bus.notify(notification, event.getProject());

  }

  /**
   Show Yes/No/Cancel - return true if yes.
   IMPROVE: There's no difference between No anc Cancel, fix it if you want.
   */
  private boolean showConfirmation(Project project, PsiClass psiClass){
    int response = Messages.showYesNoCancelDialog(
      project,
      "Generate a Fruitfly Builder for %s?".
        // IMPROVE: maybe include parent name if it's nested?
        formatted(psiClass.getName()),
      "Confirmation",
      "Yes",
      "No",
      "Cancel",
      Messages.getQuestionIcon()
    );

    return response == Messages.YES;
  }

  /**
   use of PSI_FILE in update() method is what requires updateThread = BGT
   */
  private static PsiClass isRecord(@NotNull AnActionEvent event) {
    Project project = event.getProject();
    Editor editor = event.getData(CommonDataKeys.EDITOR);
    if( project == null || editor == null ){
      return null;
    }

    PsiFile file = event.getData(CommonDataKeys.PSI_FILE);
    if( file == null ){
      return null;
    }

    PsiElement elementAtCaret = file.findElementAt(
      editor.getCaretModel().getOffset());
    if( elementAtCaret == null ){
      return null;
    }

    PsiClass psiClass = getParentOfType(elementAtCaret, PsiClass.class, false);
    if( psiClass == null ){
      return null;
    }

    if( !psiClass.isRecord() ){
      return null;
    }

    return psiClass;
  }


}
