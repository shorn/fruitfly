# Project structure

See [plugin-structure.md](./plugin-structure.md).


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


# Running on later JDKs

At the time the plugin was originally written, JDK was the LTS release, and
my preferred choice.

But IDEA 2023.3.3 runs on JDK 17 - so it makes more sense to use that as the
basis for the plugin (declared in the Gradle toolchain).

I had issues when integrating the plugin into a larger Gradle project that used
JDK 21. I was able to build the plugin, but when I tried to run the `test` task
from IDEA - IDEA would launch the Gradle task with JDK 21 and it was cause
errors when running the tests. The IDEA plugin unit test infrastructure
supports and uses JUnit versions all the way back to version 3, and that (or
something else in the plugin test infra) may have been causing problems with
the module system.

That said, I've tried to change the JDK that the standalone Fruitfly project
was using in IDEA and the test task still seemed to run. The issue may have
been being caused by other complications in the large project I was integrating
into. Just be aware that you might run into issues integrating into projects
on later versions of the JDK.


# Running unit tests

Run the `test` Gradle task.

See [plugin-structure.md](./plugin-structure.md#test-code) for discussion of 
how the existing unit tests are structured.

