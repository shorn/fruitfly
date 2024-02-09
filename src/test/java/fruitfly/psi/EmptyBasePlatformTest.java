package fruitfly.psi;

import com.intellij.testFramework.fixtures.BasePlatformTestCase;

public class EmptyBasePlatformTest extends BasePlatformTestCase {

  public void testMyUtilityMethod() {
    System.out.println("xxx");
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }

  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }
}
