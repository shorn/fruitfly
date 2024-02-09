package fruitfly.example;

/**
 approximately the result we want when running on the FlatSingularInput
 record.
 */
public record FlatSingularResult(String field1, String field2) {

  public Builder but() {
    return Builder.simpleExample().field1(field1).field2(field2);
  }


  public static final class Builder {
    private String field1;
    private String field2;

    private Builder() {
    }

    public static Builder simpleExample() {
      return new Builder();
    }

    public Builder field1(String field1) {
      this.field1 = field1;
      return this;
    }

    public Builder field2(String field2) {
      this.field2 = field2;
      return this;
    }

    public FlatSingularResult build() {
      return new FlatSingularResult(field1, field2);
    }
  }
}
