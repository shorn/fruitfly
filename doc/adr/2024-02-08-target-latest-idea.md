Decision: target the latest IDEA version and the JDK it is built on.

When this plugin was initially built, that was `2023.3.3` and the JDK that it
runs on is `17`.

This decision limits the applicability of the original version of the plugin,
but reinforces the idea that the way to customise it is to make a new plugin.

If a project is limited to older versions of the plugin and/or JDK, then the 
plugin should be forked or copied in to that project and ported to the 
required version.

