package fruitfly.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.JavaPsiFacade;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementFactory;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiRecordComponent;
import com.intellij.psi.codeStyle.JavaCodeStyleManager;

import java.util.StringJoiner;

public class BuilderGenerator {

  private PsiClass recordClass;

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
    for (PsiClass innerClass : innerClasses) {
      if ("Builder".equals(innerClass.getName())) {
        innerClass.delete();
        break; // Assuming only one Builder class exists
      }
    }


    // Start building the Builder class string representation
    StringBuilder builderClassContent = new StringBuilder(
      "public static class Builder {");

    // Generate fields and methods for Builder based on record components
    for( PsiField field : recordClass.getFields() ){
      if( field instanceof PsiRecordComponent component ){
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
    }

    // Append build method to Builder class
    builderClassContent.append("public ")
      .append(recordClass.getName())
      .append(" build() {");
    builderClassContent.append("return new ")
      .append(recordClass.getName())
      .append("(");
    StringJoiner parameters = new StringJoiner(", ");
    for( PsiField field : recordClass.getFields() ){
      if( field instanceof PsiRecordComponent ){
        parameters.add("this." + field.getName());
      }
    }
    builderClassContent.append(parameters.toString()).append(");");
    builderClassContent.append("}}");

    // Create the Builder class
    PsiClass newBuilderClass = elementFactory.createClassFromText(
      builderClassContent.toString(),
      recordClass);
    PsiElement addedElement = recordClass.add(
      newBuilderClass.getInnerClasses()[0]
    );

    // Reformat code to adhere to project's code style settings
    JavaCodeStyleManager styleManager =
      JavaCodeStyleManager.getInstance(project);
    styleManager.shortenClassReferences(addedElement);
    styleManager.optimizeImports(recordClass.getContainingFile());
  }
}
