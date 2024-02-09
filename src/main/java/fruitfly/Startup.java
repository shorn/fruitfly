package fruitfly;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.ProjectActivity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static fruitfly.util.Log.log;

public class Startup implements ProjectActivity {

  @Nullable
  @Override
  public Object execute(
    @NotNull Project project,
    @NotNull Continuation<? super Unit> continuation
  ) {
    log("startup");

    GenerateRecordBuilder.register();

    return null;
  }

}
