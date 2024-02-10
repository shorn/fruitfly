package fruitfly.test;

import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiJavaFile;
import com.intellij.psi.PsiPlainTextFile;
import com.intellij.testFramework.fixtures.LightJavaCodeInsightFixtureTestCase;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class FruitflyTestCase
  extends LightJavaCodeInsightFixtureTestCase
{

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    /* I prefer my resource files to be right next to the test instead of in
     a separate hierarchy.  Makes refactoring tests and packages easier and
     looking up input/output data easier. */
    myFixture.setTestDataPath("src/test/java");
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  public String getPackagePath(){
    return this.getClass().getPackage().getName().replace('.', '/');
  }

  public PsiJavaFile getTestPsiJavaFile(String filename){
    var file = myFixture.configureByFile(getPackagePath() + "/" + filename);

    assertThat(file).isNotNull();
    assertThat(file).isInstanceOf(PsiJavaFile.class);

    return (PsiJavaFile) file;
  }

  public PsiPlainTextFile getTestPsiTextFile(String filename){
    var file = myFixture.configureByFile(getPackagePath() + "/" + filename);

    assertThat(file).isNotNull();
    assertThat(file).isInstanceOf(PsiPlainTextFile.class);

    return (PsiPlainTextFile) file;
  }

  public PsiFile getTestPsiFile(String filename){
    return myFixture.configureByFile(getPackagePath() + "/" + filename);
  }


}
