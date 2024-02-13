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

This plugin is not intended be published in the marketplace.
The intent is to fork it, or copy it into your target project, and then
customise it to the requirements of your specific project.

Fruitfly is MIT licenced - so I couldn't prevent you from publishing it to the
marketplace even if I wanted to. But please re-label it if you do that.
That is: fork the repo, rename it and set your own vendor and support email in
plugin.xml.

To customise the generated code:

* fork the project
* edit [BuilderGenerator.java](src/main/java/fruitfly/psi/BuilderGenerator.java)
  and customise the generated code

See [plugin-structure.md](./doc/plugin-structure.md) for quick summary of the project structure.


# Developing the plugin

See [plugin-development.md](./doc/plugin-development.md).