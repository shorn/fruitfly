## Why use a builder pattern for records?

Java records are fine when they're used for trivial things with small numbers
of fields.

They become unusable as the number of fields grows, especially with many fields
of the same type (e.g. lots of strings).

They're particularly awkward when you need to create a new record that
represents a modification to an existing record.
The Java team recognise the modification part - hence the JEP for
"derived record creation": https://openjdk.org/jeps/8321133.
But that JEP is many years away from being usable. Also, it doesn't actually
target the issues of readability and maintainability of records - so it's
unlikely to be of much help when it does finally arrive.


## Marketplace builder plugins

I like to use a "builder" pattern for building and copying records.

The built-in plugins in the IDEA marketplace don't generate quite the code I
want. And even if they can be made to generate the desired code, they usually
don't remember the settings, - so you have to re-configure the generator each
time the record fields are changed. Tedious and error-prone.

IDEA marketplace plugins also represent a maintenance risk - small plugins
maintained by one author (which is all this kind of build-generator plugin
requires) tend to become unmaintained over time as authors get bored with them
or transition to using different technologies.

Ironically, if one of these plugins were to become popular - it would likely
start to become bloated/bogged down with unnecessary features because there's
no community consensus on what a builder should look like (see the various
config options in the best builder-generator marketplace plugins).


## Maintenance burden of building your own plugin

Building a generator plugin like this is obviously a maintenance burden too.

Besides the initial cost of building it, if you want it to keep working, over
the time span of a few years, it has to maintained to keep up with changes to
IDEA's plugin system.

Understandably, IDEA have had multiple large re-writes of their plugin system.
["Yesterday's weather"](https://martinfowler.com/bliki/YesterdaysWeather.html)
tells us there will probably be further changes.

The more features/APIs of IDEA that are used in IDEA, the higher the
maintenance burden.
e.g. if we use internal IDEA functionality for generating the actual code, then
that is actually much more likely to need maintenance over time because I'd
guess IDEA has to keep changing that stuff a lot (likely a lot more than
the plugin system interface itself).

See [2024-02-08-use-idea-psi-api.md](./adr/2024-02-08-use-idea-psi-api.md)


## Benefits of using a project-specific plugin

The rationale for adopting a project-specific plugin stems from the belief that
there is no universally "right" way to structure a builder; rather only,
"this is the way we do it on this project".

Having the plugin be specifically written for "the project way" means
it can be fast to invoke and there's no need to spend time writing and
maintaining customisation logic, UI, persistence, etc.

Also, it avoids issues around "how to use the plugin" if there's only one way to
use it.


