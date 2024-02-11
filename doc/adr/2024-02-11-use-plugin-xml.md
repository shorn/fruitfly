Decision: Register things like actions, group entries via plugin.xml instead of
writing code.

Originally, I wanted to do stuff like registering my Actions via code called
from a startup activity.

But using plugin.xml saves a lot of work, especially the housekeeping required
to ensure the plugin remains "dynamic".

* The startup code was in ProjectActivity, which meant it was actually
  registering the action multiple times. It could have code to avoid
  registering twice, or refactor the registration code to not be project-level.
  But using plugin.xml is easier.
* a dynamic plugin registering actions via code must de-register the actions and
  undo anything else anything else it modified - like group entries.
  Using plugin.xml is easier.

The Fruitfly plugin is meant to be small and easy to read/maintain/change so
it's easy to modify it to target it in a project-specific way.
Using plugin.xml makes it smaller and easier to understand. The plugin is
intended to stay small and simple - it's never supposed to grow into some
monster plugin that requires tons of code.

Using plugin.xml will likely require less maintenance over time. My guess is
that using plugin.xml will be more stable over time into the future than using
all the startup, registration, de-registration APIs directly in code.