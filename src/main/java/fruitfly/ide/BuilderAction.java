package fruitfly.ide;

import com.intellij.openapi.actionSystem.ActionUpdateThread;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import fruitfly.psi.BuilderGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.intellij.psi.util.PsiTreeUtil.getParentOfType;

public class BuilderAction extends AnAction {
  private static final Logger log = Logger.getInstance(BuilderAction.class);


  @Override
  public @NotNull ActionUpdateThread getActionUpdateThread() {
    return ActionUpdateThread.BGT;
  }

  @Override
  public void update(@NotNull AnActionEvent event) {
    // log.warn("update()");
    Project project = event.getProject();
    Editor editor = event.getData(CommonDataKeys.EDITOR);
    if( project == null || editor == null ){
      event.getPresentation().setEnabledAndVisible(false);
      return;
    }

    if( !ApplicationManager.getApplication().isReadAccessAllowed() ){
      /* this branch was added when I was trying something else,
        logging it to see when it actually happens, if ever? */
      log.info("readAccessAllowed=false");
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
      log.warn("actionPerformed() no project or editor");
      return;
    }

    var recordClass = isRecord(event);
    if( recordClass == null ){
      log.warn("actionPerformed() when not a record");
      return;
    }

    List<String> fields = RecordMemberChooser.chooseFieldNames(recordClass);

    WriteCommandAction.runWriteCommandAction(recordClass.getProject(), ()->{
      BuilderGenerator.generateBuilderClass(recordClass, fields);
    });

  }

  /**
   use of PSI_FILE in update() method requires updateThread = BGT
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
