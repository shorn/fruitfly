
# Support varargs components

Doesn't work with components whose type is declared as a varargs.

i.e. `record(String... args){}`

Fruitfly will generate a private field like `private String... args` on
the `Builder`, which is not valid syntax.

Varargs builder fields should be declared as `private String[] args`.

Example: 
[VarargsComponent.java](/src/test/java/fruitfly/example/VarargsComponent.java)


# Filter class members from chooser

The RecordMemberChooser will incorrectly display the class field as a
selectable member of the record.

Even if the user selects the class field, Fruitfly will ignore it and
create the builder properly, but the Chooser should not have displayed it
as a selectable item in the first place.


Example:
[StaticComponent.java](/src/test/java/fruitfly/example/StaticComponent.java)
