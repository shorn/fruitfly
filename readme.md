Plugin for generating "Builder" pattern code for Java records.

The plugin takes record code that looks like
[SimpleRecordTestInput.java](./src/test/java/fruitfly/psi/SimpleRecordTestInput.java)
and generates code into that class to implement the builder pattern -
[like this](./src/test/java/fruitfly/psi/SimpleRecordTestOutput.txt).

This plugin will not be published in the marketplace.
The intent is to fork it, or copy it into your target project, and then
customise it to the requirements of your specific project.

To customise the generated builder pattern:

* fork the project
* edit [BuilderGenerator.java](src/main/java/fruitfly/psi/BuilderGenerator.java)
  and customise the generated code

For the "why" of using the builder pattern and having a custom plugin,
see: [plugin-background.md](./doc/plugin-background.md)


# Installing the plugin into your own IDEA

## Build the plugin

Run the `buildPlugin` task.

## Install the plugin

/ `Settings` / `Plugins` / `<gear icon at top right>` /
`Install plugin from disk ...`

Select the zip that `buildPlugin` built in
`/build/distributions` (e.g. `fruitfly-1.0.zip`).


# Invoking the plugin

Have the code for a Java **record** open in your editor and put your
edit cursor somewhere on the record (the name, the definition, inside the
record body, wherever).

Invoke `/ Code / Generate...` action (either via the window menu, or by default
it's bound to `Alt + Insert`, I think).

You should see a dialog allowing you to select the fields to generate, when
you confirm, Fruitfly will generate (or _re_-generate) the builder pattern
for the fields you selected.


# Developing the plugin

See [plugin-development.md](./doc/plugin-development.md).