package fruitfly.psi;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.diagnostic.Logger;
import fruitfly.test.FruitflyTestCase;

import static org.assertj.core.api.Assertions.assertThat;

/** This test simulates where a user has changed the record significantly and
 is triggering fruitfly to regenerate the builder */
public class RegenerateRecordTest extends FruitflyTestCase {
  private static final Logger log = Logger.getInstance(RegenerateRecordTest.class);

  public void testCommentsShouldPersist() {
    var inputJava = getTestPsiJavaFile("RegenerateRecordTestInput.java");
    var outputText = getTestPsiTextFile("RegenerateRecordTestOutput.txt");

    var recordClass = inputJava.getClasses()[0];
    WriteCommandAction.runWriteCommandAction(inputJava.getProject(), ()->{
      BuilderGenerator.generateBuilderClass(recordClass);
    });

    log.info("generated: " + inputJava.getText());
    assertThat(inputJava.getText()).isEqualTo(outputText.getText());

  }

}

