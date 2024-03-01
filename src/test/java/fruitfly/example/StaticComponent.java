package fruitfly.example;

/**
 Example of a record with a static class field.
 */
public record StaticComponent(String thing) {
  public static final String DEFAULT_THING = "something";
}
