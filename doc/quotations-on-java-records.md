This content was taken from:
https://github.com/dustinmarx/MoreInspiredByActualEvents/blob/master/content/java/JavaRecords.md
Reproduced here because the internet-archive seemed to be having trouble saving 
it.

# Quotations on Java Records ##

This page provides some quotations on Java Records that are useful in
understanding
how [Records](https://blogs.oracle.com/javamagazine/records-come-to-java) are
designed and how to most effectively apply them. These quotations are _not_
currently organized or categorized, but that _may_ change in future versions of
this document.

* "Records provide a compact syntax for declaring classes which are transparent
  holders for shallowly immutable
  data." - [JEP 359: Records (Preview)](https://openjdk.java.net/jeps/359)
* Records "are classes that act as transparent carriers for immutable data"
  and "can be thought of as _nominal
  tuples_." - [JEP 384: Records (Second Preview) (as of 9 May 2020)](https://openjdk.java.net/jeps/384)
* "While it is superficially tempting to treat records as primarily being about
  boilerplate reduction, we instead choose a more semantic goal: _modeling data
  as data_. (If the semantics are right, the boilerplate will take care of
  itself.) ... records make the semantic claim of being transparent carriers for
  their
  data." - [JEP 384: Records (Second Preview) (as of 9 May 2020)](https://openjdk.java.net/jeps/384)
* "_Records_ are a new kind of class in the Java language. The purpose of a
  record is to declare that a small group of variables is to be regarded as a
  new kind of entity. A record declares its state -- the group of variables --
  and commits to an API that matches that state. This means that records give up
  a freedom that classes usually enjoy -- the ability to decouple a class's API
  from its internal representation -- but in return, records become
  significantly more
  concise." - [JEP 384: Records (Second Preview) (as of 9 May 2020)](https://openjdk.java.net/jeps/384)
* "Records can be considered a nominal form of
  _tuples_." - [JEP 384: Records (Second Preview) (as of 9 May 2020)](https://openjdk.java.net/jeps/384)
* "For all these reasons, we don't want to abandon classes for modeling data; we
  just want to make modeling data with classes simpler. The major pain of using
  named classes for aggregates is the overhead of declaring them; if we can
  reduce this sufficiently, the temptation to reach for more weakly typed
  mechanisms is greatly reduced. (A good starting point for thinking about
  records is that they are _nominal
  tuples_.)" - [Brian Goetz, Data Classes and Sealed Types for Java, February 2019](http://cr.openjdk.java.net/~briangoetz/amber/datum.html)
* "The major road-not-taken was trying to extend records to replace _mutable
  JavaBean
  classes_." - [Brian Goetz, Java 14 Feature Spotlight: Records, 4 February 2020](https://www.infoq.com/articles/java-14-feature-spotlight/)
* "So, while it is superficially tempting to think about records as primarily
  being about boilerplate reduction, we preferred to approach it as a semantic
  problem; how can we better model data aggregates directly in the language, and
  provide a sound semantic basis for such classes that developers can easily
  reason about? (The approach of treating this as a semantic, rather than
  syntatic, problem worked quite well for enums.) And the logical answer for
  Java was: records are nominal
  tuples." - [Brian Goetz, Java 14 Feature Spotlight: Records, 4 February 2020](https://www.infoq.com/articles/java-14-feature-spotlight/)
* "Common goal" of records: "records are the state, the whole state, and nothing
  but the state. Specifically, we want _equality_ of records to be derived from
  the entirety of the state declared in the state description, and nothing
  else." - [Brian Goetz, Java 14 Feature Spotlight: Records, 4 February 2020](https://www.infoq.com/articles/java-14-feature-spotlight/)
* "Given that the design center for records is nominal tuples, one might ask why
  we didn't choose structural tuples instead. Here, the answer is simple: _names
  matter_." - [Brian Goetz, Java 14 Feature Spotlight: Records, 4 February 2020](https://www.infoq.com/articles/java-14-feature-spotlight/)
* "But that's (Billy Boilerplate vision for records) not what records are.
  Records are _nominal tuples_; they _are_ their data. It is
  entirely appropriate for the data definition to be front and center in the
  declaration -- because that's what records
  are." - [Brian Goetz, 15 April 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-April/005842.html)
* "You are viewing records as largely a syntactic convenience, but that's not
  what they are. Records are a _semantic_ feature; they are
  the state, the whole state, and nothing but the state. All their protocols --
  construction, deconstruction, equality, hashing, string representation -- are
  derived mechanically from a common state
  description." - [Brian Goetz, 15 April 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-April/005842.html)
* "The reality is: if you're looking for a tool to automate the generation of
  JavaBean-style classes for your APIs, this [Java Record] isn't it. In fact,
  most APIs probably won't expose very many; we're far more likely to use them
  internally as implementation details. And they're great for
  that!" - [Brian Goetz, 15 April 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-April/005842.html)
* "But records are not a syntactic feature, they are a semantic one, whose
  syntactic benefits are a happy consequence of the carefully
  chosen
  semantics." - [Brian Goetz, 3 May 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-May/005945.html)
* "Looking at records through the lens of 'how many of my classes can I
  convert', while tempting, is not necessarily the right way to judge the
  feature. Instead, perhaps we should ask ourselves: 'if I had records when I
  wrote this, could I have used them
  profitably?'" - [Brian Goetz, 7 May 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-May/005972.html)
* "A record is a nominal
  tuple" - [Brian Goetz, 7 May 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-May/005972.html)
* "The purpose of having a new declaration form is so that the author can
  communicate their design intent. When you say 'record', you are making it
  crystal clear what you want -- that you intend that this class is a
  transparent, shallowly immutable carrier for a specified tuple of
  data." - [Brian Goetz, 11 October 2019](https://mail.openjdk.java.net/pipermail/amber-dev/2019-October/004889.html)
* "Multiple return is a weak feature, that will feel like tuples dangled in
  front of your face, and then snatched back; We prefer nominal tuple (records)
  to structural
  ones." - [Brian Goetz, 14 January 2019](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2019-January/000969.html)
* "Records are clearly not beans, they are effectively something new (nominal
  tuples) that Java devs will have to learn not to
  overuse." - [Stephen Colebourne, 15 December 2019](https://mail.openjdk.java.net/pipermail/amber-dev/2019-December/005379.html)
* "We should communicate more on that, records are not beans, i repeat, records
  are not beans ! you will be disappointed if you try to replace all your beans
  by
  records." - [Rémi Forax, 15 December 2019](https://mail.openjdk.java.net/pipermail/amber-dev/2019-December/005381.html)
* "You are trying to use records for something they were not intended for. The
  design center for records is (as has been stated many times) "nominal tuples".
  Is `nvmlInit` effectively a tuple? Are the state-based equals, hashCode, and
  toString methods a natural fit for the domain? Is the canonical constructor
  enforcing any necessary invariants? Are you getting any benefit _at all_ from
  declaring as a record? I don't think so. These are signs that this isn't the
  tool you are looking for. ... Or, perhaps you might consider whether records
  are helpful as the _implementation detail_ of your class, by wrapping a record
  with the API you actually want to
  expose?" - [Brian Goetz, 9 March 2019](https://mail.openjdk.java.net/pipermail/amber-dev/2020-March/005682.html)
* "Yes, the naming discussion has been had, and yes, tuple was considered. The
  consensus was that calling it 'tuple' would engender a 'but that's not what a
  tuple is' response from those who are used to tuples being structural, not
  nominal, and that this would be a distraction. So we chose a name that was a
  little less loaded, but was still associated with nominal,
  fixed-sized-and-type sequences (think records in a relational database.)
  Coincidentally, the C# folks went through the same process and independently
  came up with the
  name '[record](https://github.com/dotnet/csharplang/blob/master/proposals/records.md)'." - [Brian Goetz, 10 March 2019](https://mail.openjdk.java.net/pipermail/amber-dev/2020-March/005685.html)
* "In the end, JavaBean Jerry was not the winner; Tuples Tommy was. And this
  choice of design center affects nearly every aspect of the final feature
  design. The outcome is that *records are nominal tuples*, so we would expect
  them to work best where we might use tuples (data carriers across boundaries,
  compound map keys, etc), and not as well where we use
  beans." - [Brian Goetz, 22 November 2019](https://mail.openjdk.java.net/pipermail/amber-dev/2019-November/005272.html)
  * As of this writing,
    the [February 2019 edition of "Data Classes and Sealed Types for Java"](http://cr.openjdk.java.net/~briangoetz/amber/datum.html)
    describes the "developers" who all see "data classes" differently: Algebraic
    Annie, Boilerplate Billy and brother JavaBean Jerry, Tuple Tommy, and Values
    Victor.
* "If instead we say 'records are just nominal tuples', two good things
  happen: - Those who vaguely know what tuples are will get it; - Those who wish
  we had done structural tuples will have nothing to argue
  with." - [Brian Goetz, 12 April 2019](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2019-April/001135.html)
* "Records have semantics, which makes them *worlds* different from tuples.
  Methods, supertypes, validation, specification... I think it's fair to say
  that all a record *holds* is a "tuple", but it's so much more. Record is to
  tuple as enum is to
  int." - [Kevin Bourrillion, 12 April 2019](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2019-April/001139.html)
* "And also note that Java `record` is to C `struct` as Java `enum` is to
  C `enum`." - [Guy Steele, 12 April 2019](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2019-April/001141.html)
* "Records are _transparent, shallowly immutable containers for their state_.
  But that's [macro generator] not what records are -- records are _nominal
  tuples_ (just as functional interfaces are _nominal function
  types_.)" - [Brian Goetz, 14 December 2019](https://mail.openjdk.java.net/pipermail/amber-dev/2019-December/005377.html)
* [Morling](https://twitter.com/gunnarmorling/status/1250526472231686144): "
  Record components shall not be named notify (or wait, or clone,
  or...)." [Goetz](https://twitter.com/BrianGoetz/status/1250882629316075525): "
  These component names flow into API members. Some are actual clashes (e.g., a
  component named `toString` with type `int`), but we erred on the side of
  banning all names of members from `Object`.  (Yes, we know that `wait` isn't
  really a
  conflict.)" - [Gunnar Morling and Brian Goetz, 15 April 2020](https://twitter.com/BrianGoetz/status/1250882629316075525)
* "Records are the data, the whole data, and nothing but the
  data." - [Brian Goetz, 9 June 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-June/006197.html)
* "If your alternate constructors are not merely expanding to a representation,
  and the canonical constructor is not flowing values from the arguments to the
  fields (perhaps routed through validation and/or normalization), you're
  probably not in the semantic territory to be a record
  anyway." - [Brian Goetz, 9 June 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-June/006197.html)
* "The canonical constructor arguments _are_ the (candidate) field
  values." - [Brian Goetz, 9 June 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-June/006197.html)
* "Records give you a clean way to declare the canonical constructor (the
  compact constructor), to minimize the overhead of centralizing invariant
  checking, to maximize chance that developers will actually check
  invariants." - [Brian Goetz, 9 June 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-June/006197.html)
* "In the compact constructor, you just mutate the parameters if you want to
  normalize them (after validation, if any.)  The resulting parameter values are
  automatically committed to the fields at the end of the
  constructor." - [Brian Goetz, 9 June 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-June/006197.html)
* "Most of the reasons that make factories better than constructors don't apply
  to records, because records are already quite
  restricted." - [Brian Goetz, 9 June 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-June/006197.html)
* "The compact constructor effects a (usually trivial) transform on the record
  state, _and then_ stamps that into a new
  record." - [Brian Goetz, 9 June 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-June/006197.html)
* "You are getting caught up on: 'but I must initialize the fields via
  assignment.' Let go of that, and the answer becomes obvious, and your code
  gets
  better" - [Brian Goetz, 9 June 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-June/006197.html)
* "But if you stop thinking of records as 'more concise classes', and instead
  as 'nominal tuple objects', this gets a lot easier -- and you'll probably like
  it." - [Brian Goetz, 9 June 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-June/006197.html)
* "Record classes are a special kind of class that are used primarily to define
  a simple aggregate of
  values." - [Gavin Bierman, 27 July 2020](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2020-July/002254.html)
* "Records can be thought of as _nominal tuples_; their declaration commits to a
  description of their state and given that their representation, as well as all
  of the interesting protocols an object might expose -- construction, property
  access, equality, etc -- are derived from that state
  description." - [Gavin Bierman, 27 July 2020](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2020-July/002254.html)
* "The body of a record class declaration is often empty, but it can contain
  method declarations as usual. Indeed, if it is necessary, the implicitly
  declared members - the accessors, canonical constructor, and equals, toString,
  or HashCode methods -- can alternatively be explicitly declared in the
  body." - [Gavin Bierman, 27 July 2020](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2020-July/002254.html)
* "Often the reason for explicitly providing a canonical constructor for a
  record class is to validate and/or normalize the argument
  values." - [Gavin Bierman, 27 July 2020](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2020-July/002254.html)
* "If the canonical constructor is implicitly declared then its access modifier
  is the same as the record class. If it is explicitly declared then its access
  modifier must provide at least as much access as the record
  class." - [Gavin Bierman, 27 July 2020](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2020-July/002254.html)
* "The records JEP also allows for local record declarations. This is important
  as records will often be used as containers for intermediate data within
  method bodies. Being able to declare these record classes locally is essential
  to stop proliferation of
  classes." - [Gavin Bierman, 27 July 2020](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2020-July/002254.html)
* "Records ... are implicitly
  static." - [Brian Goetz, 3 August 2020](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2020-August/002266.html)
* "In records, we made the deliberate choice to design the feature for new code
  than for catering to the quirks of existing
  code." - [Brian Goetz, 5 August 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-August/006414.html)
* "The model for records (immutable, transparent carriers for a fixed state
  vector) is different ... from mutable
  JavaBeans..." - [Brian Goetz, 5 August 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-August/006414.html)
* "**Records are not JavaBeans**. The JavaBeans spec requires that a bean has a
  public no-args constructor. After creating the object, it's state is then set
  using the various setters. Records on the other hand are immutable - their
  contents need to be known at
  creation." - [Johannes Kuhn, 5 August 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-August/006415.html)
* "Records are not just immutable POJOs with generated members; there is a
  semantic guarantee (which of course people can break if they are
  careless)..." - [Brian Goetz, 15 August 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-August/006487.html)
* "The important thing to understand about records (and, we apparently cannot
  say this enough times) is that they are _not really about syntactic
  concision_; syntactic concision is merely a pleasing side-effect of something
  more important, which is that a record is expected to have certain semantics (
  which, of course, uncooperative authors or code mangling tools can undermine.)
  Records introduce into the language the first glimmer of a notion of accessor;
  the method `x()` in record `Foo(int x)` is not just a method, it is an
  accessor, and reflection tells you so. This is far more reliable than a mere
  naming
  convention!" - [Brian Goetz, 27 August 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-August/006523.html)
* "It is reasonable for a client who observes `clazz.isRecord()` to expect that
  fetching the accessors, and then fetching their values, just always works,
  because records are a semantic
  feature." - [Brian Goetz, 27 August 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-August/006523.html)
* "Records are just
  classes." - [Brian Goetz, 22 September 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-September/006654.html)
* "Explicit specification of serialVersionUID in records rarely makes sense and
  should be
  discouraged." - [Tagir Valeev, 3 August 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-August/006407.html)
* "A Record does not support encapsulation (separating the public API and the
  private implementation) given that it's a named tuple. If you want
  encapsulation, use a
  class." - [Rémi Forax, 1 October 2020](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2020-October/002572.html)
* "Records are the Java version of named tuples - basically containers for an
  ordered sequence of
  elements." - [Johan Janssen, 12 August 2020](https://www.infoq.com/news/2020/08/java16-records-instanceof/)
* "Records are named tuples, they are defined only by their components, in a
  transparent manner i.e. no
  encapsulation." - [Rémi Forax, 23 December 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-December/006871.html)
* "The idea is that, in a method, if you are able to see a record, you can
  create it. Thus the canonical constructor has the same visibility as the
  record
  itself." - [Rémi Forax, 23 December 2020](https://mail.openjdk.java.net/pipermail/amber-dev/2020-December/006871.html)
* "Records are not a “macro generator”; to think of records in terms of "the
  compiler generates XYZ pattern of code", while technically accurate, is
  missing the main point. They are a semantic feature, that happens to dispense
  with some
  boilerplate." - [Brian Goetz, 22 May 2021](https://mail.openjdk.java.net/pipermail/core-libs-dev/2021-May/077957.html)
* "Records are best understood as _nominal tuples_; they are the language’s
  mechanism for representing product types. Because Java is an OO language, we
  can mediate the construction process to reject invalid states or normalize
  state to its canonical form, and we derive the semantics for accessors,
  equals, hashCode, etc, from the semantics of
  tuples." - [Brian Goetz, 22 May 2021](https://mail.openjdk.java.net/pipermail/core-libs-dev/2021-May/077957.html)
* "... a record is a weird tuple. A record in Java is not just a tuple, ... but
  because all components are named also a compact key/value
  set." - [Rémi Forax, 14 September 2021](https://mail.openjdk.java.net/pipermail/amber-spec-experts/2021-September/003104.html)
* Records
  do [not support C-style array declarations](https://stackoverflow.com/questions/69056728/c-style-arrays-do-not-work-with-records-anymore)
  because "the C-style array notation is considered legacy and is not being
  carried forward into new
  constructs." - [Brian Goetz, 5 September 2021](https://stackoverflow.com/questions/69056728/c-style-arrays-do-not-work-with-records-anymore#comment122063101_69056729)
* "The boilerplate-reduction benefits of records is a bonus, but was not the
  point. Records are about the language having a direct way to describe *data as
  data*. This is a semantic upleveling, not a mere boilerplate-reduction. The
  boilerplate reduction *derives from* the semantic
  upleveling." - [Brian Goetz, 20 May 2022](https://mail.openjdk.java.net/pipermail/amber-dev/2022-May/007358.html)
* "And records aren't even immutable, they are only shallowly
  immutable." - [Brian Goetz, 2 July 2022](https://mail.openjdk.org/pipermail/amber-dev/2022-July/007404.html)
* "For records whose components are values (
  e.g., `record Point(int x, int y) {}`), the default implementation of
  constructor and accessor do exactly the right thing,
  and no one has to write any code. But when mutability rears its head, the '
  right thing' is less obvious, and making a one-size-doesn't-fit-all decision
  will make some users
  unhappy." - [Brian Goetz, 10 August 2022](https://mail.openjdk.org/pipermail/amber-dev/2022-August/007436.html)
* "Similarly, some records may want to expose the mutability of their components
  to clients, and others will want to launder using defensive copies. All of
  these are expressible in the record model, just with different degrees of
  explicit
  code." - [Brian Goetz, 10 August 2022](https://mail.openjdk.org/pipermail/amber-dev/2022-August/007436.html)
* "So if you define a record whose components are mutable, or for whom you don't
  want the record equivalence semantics to be the same as the component equals,
  you're going to have to write some code -- but more importantly, you're going
  to have to tell your users what equality means for _your_
  record." - [Brian Goetz, 10 August 2022](https://mail.openjdk.org/pipermail/amber-dev/2022-August/007436.html)
* "But generating 'mutable records' is a serious party foul, and we should treat
  it the way normal communities treat party fouls -- with shame (and if that
  doesn't work,
  banishment.)" - [Brian Goetz, 17 August 2022](https://mail.openjdk.org/pipermail/amber-dev/2022-August/007448.html)

## More Java Records References ##

* [JDK 15 API Documentation: Record](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/Record.html)
* [JEP 359: Records (Preview|JDK 14)](https://openjdk.java.net/jeps/359)
* [JEP 384: Records (Second Preview|JDK 15)](https://openjdk.java.net/jeps/384)
* [JEP 395: Records (JDK 16)](https://openjdk.java.net/jeps/395)
* [Records and Pattern Matching for Instanceof Finalized in JDK 16](https://www.infoq.com/news/2020/08/java16-records-instanceof/)
* [Records Come to Java](https://blogs.oracle.com/javamagazine/records-come-to-java)
* [Java 14 Feature Spotlight: Records](https://www.infoq.com/articles/java-14-feature-spotlight/)
* [Java 14 Record Keyword](https://www.baeldung.com/java-record-keyword)
* [A First Look at Records in Java 14](https://mahmoudanouti.wordpress.com/2019/12/22/a-first-look-at-records-in-java-14/)
* [Java 14 - First Impression of Records](https://medium.com/pricerunner-tech/java-14-first-impression-of-records-3a69be1ffbd0)
