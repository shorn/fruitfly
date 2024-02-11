package fruitfly.psi;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.diagnostic.Logger;
import fruitfly.test.FruitflyTestCase;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleRecordTest extends FruitflyTestCase {
  private static final Logger log = Logger.getInstance(SimpleRecordTest.class);

  public void testSimple() {
    var inputJava = getTestPsiJavaFile("SimpleRecordTestInput.java");
    var outputText = getTestPsiTextFile("SimpleRecordTestOutput.txt");

    var recordClass = inputJava.getClasses()[0];
    WriteCommandAction.runWriteCommandAction(inputJava.getProject(), ()->{
      BuilderGenerator.generateBuilderClass(recordClass);
    });

    log.info("generated: " + inputJava.getText());
    assertThat(inputJava.getText()).isEqualTo(outputText.getText());
  }

}
