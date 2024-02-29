Fruitfly is an Intellij IDEA plugin for generating "Builder" pattern code for
Java records.

It is targeted as the most recent version of IDEA `2023.3.3` and thus assumes
you will use JDK 17 SDK to build and run it.

For the "why" of using the builder pattern and having a custom plugin,
see: [plugin-background.md](./doc/plugin-background.md)


# Functionality

The plugin takes record code that looks like
[SimpleRecordTestInput.java](./src/test/java/fruitfly/psi/SimpleRecordTestInput.java)
and generates code into that class to implement the builder pattern -
[like this](./src/test/java/fruitfly/psi/SimpleRecordTestOutput.txt).


# Usage guide

1. **Open the Generate Menu**:

* Navigate to `/ Code / Generate...` or use the shortcut `Alt + Insert`.


2. **Select Fruitfly Builder**:

* From the popup list, choose `Fruitfly Builder`.


3. **Customize Your Builder**:

* A dialog appears allowing field selection. Confirm to generate the builder
  pattern.


See
[RecordUsageExampleTest.java](./src/test/java/fruitfly/example/RecordUsageExampleTest.java)
for an example of code using the builder.


# Installing the plugin into your own IDEA

See [install.md](./install.md)


# Customising the generated code

See [contributing.md](./contributing.md)


# Developing the plugin

See [plugin-development.md](./doc/plugin-development.md).


# Plugin issues, improvements and discussions

I don't want to faff around with GitHub issue tracking.
Start a discussion if you'd like to ask questions or discuss something.
I'd rather you just forked the project and do it yourself if you want the
plugin to do something differently.

See [todo.md](./doc/todo.md) for known issues or changes that I plan to
work on.