
# Production plugin code

There are currently 4 production files that make up the plugin.


## `plugin.xml`

[plugin.xml](../src/main/resources/META-INF/plugin.xml)

This is the standard IntelliJ plugin declaration file.

It is required to declare the project as an IntelliJ plugin and define the 
services / actions that the plugin uses.


## `BuilderAction.java`

[BuilderAction.java](../src/main/java/fruitfly/ide/BuilderAction.java)

This controls the `Fruitfly Builder` item in the generate menu.

The `update()` method defines the visibility (item is only visible when you
have a record selected).

The `actionPerformed()` method:
* displays the member chooser for selecting which
fields the builder should use.
* calls the `BuilderGenerator` code to generate the builder code


## `RecordMemberChooser`

[RecordMemberChooser.java](../src/main/java/fruitfly/ide/RecordMemberChooser.java)

Displays the confirmation dialog where users can choose what fields to generate.
Contains logic to decide what fields should be selected by default.

## `RecordMemberChooser`

[BuilderGenerator.java](../src/main/java/fruitfly/psi/BuilderGenerator.java)

This is the class that generates the builder pattern structures.
This is all you need to change if you just want to customise the code that
is generated. 


# Test code

There's actually 4x as many test files as production files.
But it's not as complicated as it looks (probably need to start splitting out 
packages soon).

Each Test has three files associated with it:

## `XXXTest.java`

The actual JUnit test case.  Each test case just loads up the `XXXInput.java` 
files as a `PSI` object, passes it to the `BuilderGenerator`  and then asserts 
that the generated code matches the contents of `XXXTestOutput.txt` 

## `XXXTestInput.java`

The input java file for the test.

## `XXXTestOutput.txt`

The expected output of the test.
