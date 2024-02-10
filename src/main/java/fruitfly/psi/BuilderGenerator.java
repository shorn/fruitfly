package fruitfly.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementFactory;
import com.intellij.psi.PsiMethod;
import com.intellij.psi.PsiRecordComponent;
import com.intellij.psi.codeStyle.JavaCodeStyleManager;

import java.util.StringJoiner;

public class BuilderGenerator {

  private final PsiClass recordClass;

  public BuilderGenerator(PsiClass recordClass) {
    // IMPROVE: assert that it's a record
    this.recordClass = recordClass;
  }

  public void generateBuilderClass() {
    PsiElementFactory elementFactory =
      JavaPsiFacade.getElementFactory(recordClass.getProject());
    Project project = recordClass.getProject();

    // check if Builder class already exists and delete it
    PsiClass[] innerClasses = recordClass.getInnerClasses();
    for( PsiClass innerClass : innerClasses ){
      if( "Builder".equals(innerClass.getName()) ){
        innerClass.delete();
        break; // Assuming only one Builder class exists
      }
    }

    // Check if the but() method already exists and delete it
    PsiMethod[] methods = recordClass.getMethods();
    for( PsiMethod method : methods ){
      // Check for method name and parameter count to identify the but() method
      if( "but".equals(method.getName()) && method.getParameterList()
        .getParametersCount() == 0 ){
        method.delete();
        break; // Assuming only one but() method exists
      }
    }

    // Check if the builder() method already exists and delete it
    for( PsiMethod method : methods ){
      if( "builder".equals(method.getName()) && method.getParameterList()
        .getParametersCount() == 0 ){
        method.delete();
        break; // Assuming only one builder() method exists
      }
    }

    // Start building the Builder class string representation
    StringBuilder builderClassContent = new StringBuilder(
      "public static class Builder {");

    // Generate fields and methods for Builder based on record components
    PsiRecordComponent[] components = recordClass.getRecordComponents();
    for( PsiRecordComponent component : components ){
      String fieldName = component.getName();
      String fieldType = component.getType().getCanonicalText();

      builderClassContent.append("private ")
        .append(fieldType)
        .append(" ")
        .append(fieldName)
        .append(";");
      builderClassContent.append("public Builder ")
        .append(fieldName)
        .append("(")
        .append(fieldType)
        .append(" ")
        .append(fieldName)
        .append(") {");
      builderClassContent.append("this.")
        .append(fieldName)
        .append(" = ")
        .append(fieldName)
        .append(";");
      builderClassContent.append("return this;");
      builderClassContent.append("}");
    }

    // Append build method to Builder class
    builderClassContent.append("public ")
      .append(recordClass.getName())
      .append(" build() {");
    builderClassContent.append("return new ")
      .append(recordClass.getName())
      .append("(");
    StringJoiner parameters = new StringJoiner(", ");
    for( PsiRecordComponent component : components ){
      parameters.add("this." + component.getName());
    }
    builderClassContent.append(parameters.toString()).append(");");
    builderClassContent.append("}}");

    // Create the Builder class
    PsiClass newBuilderClass = elementFactory.createClassFromText(
      builderClassContent.toString(),
      recordClass);
    PsiElement addedBuilderClass = recordClass.add(
      /* It seems the createClassFromText() method generated a _Dummy_ parent
       class for the inner class, we don't care about that - that's
       why we have to dig our Builder class out of the innerClasses like this */
      newBuilderClass.getInnerClasses()[0]
    );


    // Construct the 'but' method string
    StringBuilder butMethodContent = new StringBuilder(
      "public Builder but() {");
    butMethodContent.append("return new Builder()");

    for( PsiRecordComponent component : components ){
      String fieldName = component.getName();
      butMethodContent.append(".")
        .append(fieldName)
        .append("(")
        .append(fieldName)
        .append(")");
    }

    butMethodContent.append(";");
    butMethodContent.append("}");

    // Add the 'but' method to the record class
    PsiMethod butMethod = elementFactory.createMethodFromText(
      butMethodContent.toString(),
      recordClass);

    PsiElement addedButMethodElement = recordClass.add(butMethod);


    // Generate the static builder() method that returns an instance of the
    // Builder class
    StringBuilder builderMethodContent = new StringBuilder(
      "public static Builder builder() {")
      .append("return new Builder();")
      .append("}");

    // Create the builder() method and add it to the record class
    PsiMethod builderMethod = elementFactory.createMethodFromText(
      builderMethodContent.toString(),
      recordClass);
    PsiElement addedBuilderMethodElement = recordClass.add(builderMethod);

    // Reformat code to adhere to project's code style settings
    JavaCodeStyleManager styleManager =
      JavaCodeStyleManager.getInstance(project);
    styleManager.shortenClassReferences(addedBuilderClass);
    styleManager.optimizeImports(recordClass.getContainingFile());
  }
}
