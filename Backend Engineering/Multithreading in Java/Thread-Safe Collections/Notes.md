
The `java.util.concurrent` package supplies efficient implementations for a `queue` and a `hashtable`, `ConcurrentLinkedQueue` and `ConcurrentHashMap`.

The `ConcurrentHashMap` can efficiently support a large number of readers and a fixed number of writers. By default, it is assumed that there are up to `16` simultaneous writer threads. There can be many more writer threads, but if more than `16` write at the same time, the others are temporarily blocked. You can specify a higher number in the constructor, but it is unlikely that you will need to.

> **NOTE:** The collections return _weakly consistent_ iterators. That means that the iterators may or may not reflect all modifications that are made after they were constructed, but they will not return a value twice and they will not throw any exceptions.

The `ConcurrentHashMap` has useful methods for atomic insertion and removal of associations. The `putIfAbsent` method adds a new association provided there wasn’t one before. This is useful for a cache that is accessed by multiple threads, to ensure that only one thread adds an item into the cache: `cache.putIfAbsent(key, value);`



