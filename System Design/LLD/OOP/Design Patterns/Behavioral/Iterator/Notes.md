# Understanding Iterator Design Pattern

**DEFINITION: Abstracts the way to access elements of an aggregate object without exposing its underlying representation.**

Iterator is not threadsafe when used with a mutable collection.

> **NOTE:** Iterator's specification says that you can’t modify a collection at the same time as you're iterating over it. That's a timing-related precondition put on the caller, and Iterator makes no guarantee to behave correctly if you violate it.
