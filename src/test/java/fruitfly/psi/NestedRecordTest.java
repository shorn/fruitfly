package fruitfly.psi;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.diagnostic.Logger;
import fruitfly.test.FruitflyTestCase;

import static org.assertj.core.api.Assertions.assertThat;

/**
 NestedRecordTest is an example of some of the dodgier kind of code I write
 when I'm in a hurry where I just band the record in next to the class
 I'm working on.
 If it lives for a while, it'll generally get refactored to the top level
 pretty quickly.
 The point being: the generator should work find for structures that aren't
 just simple single class files.
 */
public class NestedRecordTest extends FruitflyTestCase {
  private static final Logger log = Logger.getInstance(NestedRecordTest.class);

  public void testNested() {
    var inputJava = getTestPsiJavaFile("NestedRecordTestInput.java");
    var outputText = getTestPsiTextFile("NestedRecordTestOutput.txt");

    /* the Action is responsible for making sure the inner record is selected,
    in this example, it would not allow the action to be triggerred when the
    top-level (non-record) class is selected. The user has to navigate to the
    record, then trigger the action. */
    var recordClass = inputJava.getClasses()[0].getInnerClasses()[0];
    WriteCommandAction.runWriteCommandAction(inputJava.getProject(), ()->{
      BuilderGenerator.generateBuilderPattern(recordClass);
    });

    log.info("generated: " + inputJava.getText());
    assertThat(inputJava.getText()).isEqualTo(outputText.getText());
  }

}
