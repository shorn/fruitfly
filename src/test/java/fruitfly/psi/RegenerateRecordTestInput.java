package fruitfly.psi;

/** record comment */
public record RegenerateRecordTestInput(
  // note that the type of field 1 has changed
  int field1,
  // and this field is added
  String field2
) {
  /* top body comment */

  public static Builder builder() {
    return new Builder();
  }

  public Builder but() {
    // I had to comment this out because it causes compile failure because of
    // user changed type of field1
    // return new Builder().field1(field1);
    return new Builder();
  }

  public void userMiddleMethod(){
    // simulates a method the user added by hand after instance methods but
    // before the nested class
  }

  public static class Builder {
    private String field1;

    public Builder field1(String field1) {
      this.field1 = field1;
      return this;
    }

    public CommentedRecordTestInput build() {
      return new CommentedRecordTestInput(this.field1);
    }
  }

  public void userBottomMethod(){
    // simulates a method that the user added at the bottom of the record
  }
  // bottom body comment
}
