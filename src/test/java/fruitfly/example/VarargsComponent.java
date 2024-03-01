package fruitfly.example;

/**
 Example of a record with a varargs component.
 Builder field will be generated with an invalid varargs definition.
 */
public record VarargsComponent(String... things) {
}
