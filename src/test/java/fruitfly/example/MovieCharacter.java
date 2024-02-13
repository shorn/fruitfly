package fruitfly.example;

public record MovieCharacter(
  String name,
  String addressLine1,
  String addressLine2,
  String postcode,
  String country,
  String status
) {
  public static Builder builder() {
    return new Builder();
  }

  public Builder but() {
    return new Builder().name(name)
      .addressLine1(addressLine1)
      .addressLine2(addressLine2)
      .postcode(postcode)
      .country(country)
      .status(status);
  }

  public static class Builder {
    private String name;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    private String addressLine1;

    public Builder addressLine1(String addressLine1) {
      this.addressLine1 = addressLine1;
      return this;
    }

    private String addressLine2;

    public Builder addressLine2(String addressLine2) {
      this.addressLine2 = addressLine2;
      return this;
    }

    private String postcode;

    public Builder postcode(String postcode) {
      this.postcode = postcode;
      return this;
    }

    private String country;

    public Builder country(String country) {
      this.country = country;
      return this;
    }

    private String status;

    public Builder status(String status) {
      this.status = status;
      return this;
    }

    public MovieCharacter build() {
      return new MovieCharacter(
        this.name,
        this.addressLine1,
        this.addressLine2,
        this.postcode,
        this.country,
        this.status);
    }
  }
}
