Plugin for generation "Builder" classes for Java records.

This plugin will not be published in the marketplace.
The intent is to copy it into what ever project I'm using it in and
then customise it to suit the requirements of that specific project.

For the "why", see: [plugin-background.md](./doc/plugin-background.md)


# Installing the plugin into your own IDEA

## Build the plugin

Run the `buildPlugin` task.

## Install the plugin

/ `Settings` / `Plugins` / `<gear icon at top right>` / 
`Install plugin from disk ...`

Select the zip that `buildPlugin` built in
`/build/distributions` (e.g. `fruitfly-1.0.zip`).


# Manual Testing

## Running the plugin in a new IDEA

Run the `runIde` task.
What kind of IDEA it will run (community or ultimate edition) depends on the 
value of `build.gradle#inteliij.type`.