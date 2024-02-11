package fruitfly.psi;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.diagnostic.Logger;
import fruitfly.test.FruitflyTestCase;

import static org.assertj.core.api.Assertions.assertThat;

/**
 a file with multiple top level classes and one record smooshed in between them
 */
public class MultipleTopLevelRecordTest extends FruitflyTestCase {
  private static final Logger log = Logger.getInstance(
    MultipleTopLevelRecordTest.class);

  public void testMultipleClasses() {
    var inputJava = getTestPsiJavaFile("MultipleTopLevelTestInput.java");
    var outputText = getTestPsiTextFile("MultipleTopLevelTestOutput.txt");

    var recordClass = inputJava.getClasses()[1];
    WriteCommandAction.runWriteCommandAction(inputJava.getProject(), ()->{
      BuilderGenerator.generateBuilderPattern(recordClass);
    });

    log.info("generated: " + inputJava.getText());
    assertThat(inputJava.getText()).isEqualTo(outputText.getText());
  }

}
