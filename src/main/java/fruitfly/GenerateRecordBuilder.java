package fruitfly;

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
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

import static com.intellij.psi.util.PsiTreeUtil.getParentOfType;
import static fruitfly.IdeaConstant.GENERATE_GROUP;
import static fruitfly.PluginConstant.NOTIFICATION_GROUP_ID;
import static fruitfly.util.Log.log;

public class GenerateRecordBuilder extends AnAction {


  public GenerateRecordBuilder() {
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
    var action = new GenerateRecordBuilder();

    actionManager.registerAction(
      GenerateRecordBuilder.class.getSimpleName(),
      action);

    DefaultActionGroup generateGroup = (DefaultActionGroup)
      actionManager.getAction(GENERATE_GROUP);
    generateGroup.add(action);
  }

  @Override
  public void actionPerformed(@NotNull AnActionEvent e) {
    log("GenerateRecordBuilder triggered");

    // TODO: generate the builder

    Notification notification = new Notification(
      NOTIFICATION_GROUP_ID,
      "Action triggered",
      "GenerateRecordBuilder was triggered",
      NotificationType.INFORMATION
    );
    Notifications.Bus.notify(notification, e.getProject());

  }

  @Override
  public void update(@NotNull AnActionEvent event) {
    log("update()");
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

    // use of PSI_FILE is what requires updateThread = BGT
    PsiFile file = event.getData(CommonDataKeys.PSI_FILE);
    if( file == null ){
      event.getPresentation().setEnabledAndVisible(false);
      return;
    }

    PsiElement elementAtCaret = file.findElementAt(
      editor.getCaretModel().getOffset());
    if( elementAtCaret == null ){
      event.getPresentation().setEnabledAndVisible(false);
      return;
    }

    PsiClass psiClass = getParentOfType(elementAtCaret, PsiClass.class, false);
    if( psiClass == null ){
      event.getPresentation().setEnabledAndVisible(false);
      return;
    }

    if( !psiClass.isRecord() ){
      event.getPresentation().setEnabledAndVisible(false);
      return;
    }

    event.getPresentation().setEnabledAndVisible(true);
  }

  @Override
  public @NotNull ActionUpdateThread getActionUpdateThread() {
    return ActionUpdateThread.BGT;
  }

}
