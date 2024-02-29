# Support varargs components

Doesn't work with components whose type is declared as a varargs.

i.e. `record(String... args){}`

Fruitfly will generate a private field like `private String... args` on
the `Builder`, which is not valid syntax.

Varargs builder fields should be declared as `private String[] args`.
