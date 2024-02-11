package fruitfly.ide;

import com.intellij.codeInsight.generation.PsiFieldMember;
import com.intellij.ide.util.MemberChooser;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiRecordComponent;
import fruitfly.psi.BuilderGenerator;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Collections.emptyList;
import static java.util.Objects.requireNonNull;

public class RecordMemberChooser {

  public static List<String> chooseFieldNames(PsiClass recordClass) {
    List<PsiFieldMember> members =
      RecordMemberChooser.mapAllFieldMembers(recordClass);

    MemberChooser<PsiFieldMember> chooser = new MemberChooser<>(
      members.toArray(PsiFieldMember[]::new),
      false, // allowEmptySelection
      true,  // allowMultiSelection
      recordClass.getProject(),
      false // isInsertOverrideVisible
    );
    chooser.setCopyJavadocVisible(false);
    chooser.selectElements(
      members.stream().
        filter(RecordMemberChooser::isDefaultSelection).
        toArray(PsiFieldMember[]::new)
    );
    chooser.setTitle("Select Fields to Be Available in Builder");

    chooser.show();
    if( !chooser.isOK() ){
      return emptyList();
    }

    // return the chosen fields as a list of field names
    List<PsiFieldMember> selectedMembers =
      requireNonNull(chooser.getSelectedElements());
    return selectedMembers.stream().
      map(i->i.getElement().getName()).
      toList();
  }

  public static List<String> mapRecordComponentNames(
    PsiClass recordClass
  ) {
    return BuilderGenerator.getComponents(recordClass).stream().
      map(PsiRecordComponent::getName).
      toList();
  }

  /**
   Return all fields of the given class as "members".
   Chooser has its own "Member" abstraction wrapped around the PSI types.
   */
  public static List<PsiFieldMember> mapAllFieldMembers(
    PsiClass psiClass
  ) {
    return stream(psiClass.getAllFields()).
      map(PsiFieldMember::new).
      toList();
  }

  public static boolean isDefaultSelection(PsiFieldMember field) {
    return !field.getElement().getName().equals("serialVersionUID");
  }

}
