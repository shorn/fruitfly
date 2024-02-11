Plugin for generating "Builder" pattern code for Java records.

That is, it takes record code that looks like 
[SimpleRecordTestInput.java](./src/test/java/fruitfly/psi/SimpleRecordTestInput.java)
and generates code to implement the builder pattern into that class - 
[like this](./src/test/java/fruitfly/psi/CommentedRecordTestOutput.txt).

This plugin will not be published in the marketplace.
The intent is to copy it into a target project and then customise it to suit
the requirements of that specific project.

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


# Manual Testing in the sandbox

## Running the plugin in a new IDEA

Run the `runIde` task.
What kind of IDEA it will run (community or ultimate edition) depends on the
value of `build.gradle#inteliij.type`.


# Attaching IDEA source code

`build.gradle#intellij.downloadSources=true` didn't work for me.

I had to download the source manually from
https://github.com/JetBrains/intellij-community/tags.
To find the tag for the source of the IDEA you're building against, use the
`runIde` task to run the sandbox IDE and then do `/ Help / About` to see the
build number.
Download the zip for that tag, stick it somewhere (I use the `/local` dir,
which is ignored) then browse to a class like `PsiClass` and do
"attach sources". 

Consider only attaching source for the packages you actually actively using and
need to see.
