Decision: use the IDEA APIs (PSI) for reading and modifying the java source
code.

It's a trade-off, the PSI APIs will probably change a lot and require
maintenance to keep the plugin up-to-date, but at least it won't ever go
un-maintained like Poet, etc. (at least, not in the timeframe that the builder
plugin itself is still desirable).

Also unfortunately, because IDEA has very powerful code refactoring/generation
abilities, and it deals with lots of different languages besides Java,
it's API for doing this stuff is quite complicated and generic.

Another downside is that the IDEA plugin system is poorly documented and the
community help ecosystem (articles, blogs, StackOverflow, etc.) tends to be
wildly out of date. The IDEA plugin system has existed for decades - it's been
through many iterations and major API changes.

I was originally envisioning that I'd be able to use the generator from the
command line - so there would be components that weren't IDEA dependent.
Theoretically, this is still possible to do, I think, even with the usage of the
PSI API.

I'm pretty sure you could modularise the project and separate the plugin
into two parts: one that is the IDEA plugin part, and one that is a standalone
project. It would just need to declare the IDEA libraries as a standard gradle
dependency. I say "theoretically", because I bet this would end up being a
huge hassle, and again: poorly documented.

I looked at a few different libraries for generating source code, but
I think that going with the IDEA PSI stuff is still probably the best option,
especially given I would like to modify the source files in place to bundle
the Builder class and the `but()` method onto the record itself.

* Java Poet
  * unmaintained
* Roaster
  * looks pretty good actually, and active, but I still think IDEA API is the
    right way to go - no concrete rationale for that, just a feeling.

In hindsight - the PSI API turned out to be pretty easy to use, and the 
integration with IDEA made things go much faster than I think they otherwise
would have.