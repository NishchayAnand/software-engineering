# Understanding Stream in Java

Streams offer a way to perform complex data processing operations on a **sequence of elements** in a declarative and concise manner. They support a wide range of SQL-like operations (e.g. `filter`, `map`, `reduce`, `find`, `match`, `sorted`) that enable functional-style processing of sequences, making it easier to write clean and efficient code.

## Difference between Collections and Streams

A collection is an in-memory data structure, which holds all the values that the data structure currently has—every element in the collection has to be computed before it can be added to the collection.

In contrast, a stream is a conceptually fixed data structure in which elements are computed on demand. In reality, streams **don't store the data themselves** but rather act as a processing abstraction on top of existing data sources like collections (List, Set, etc.), arrays, or even I/O channels.

> NOTE: Collections are about data and streams are about computations.

## Operations

Stream operations fall into two categories:

- **Intermediate operations:** These operations transform a stream into another stream. For example:

  - `filter(Predicate<T> predicate)`: **Filters elements** that match the given predicate.
  - `map(Function<T, R> mapper)`: **Transforms each element** using the provided function.
  - `sorted(Comparator<T> comparator)`: Sorts the elements using a comparator.
  - `distinct()`: Removes duplicate elements.
  - `limit(long maxSize)`: Truncates the stream to a given number of elements.
  - `skip(long n)`: Skips the first n elements.

- **Terminal operations:** These operations consume the entire stream and produce a result or side effect. For example:

  - `collect(Collector<T, A, R> collector)`: **Aggregates the elements into a collection**, such as a `List`, `Set`, or `Map`.
  - `reduce(BinaryOperator<T> accumulator)`: **Combines the elements** into a single value using an associative accumulation function.
  - `forEach(Consumer<T> action)`: **Performs an action for each element**.
  - `toArray()`: Converts the stream into an array.
  - `findFirst()`: Returns the first element of the stream, if present.
  - `count()`: Returns the number of elements in the stream.
  - `anyMatch(Predicate<T> predicate)`: Returns true if any elements match the predicate.
  - `allMatch(Predicate<T> predicate)`: Returns true if all elements match the predicate.
  - `noneMatch(Predicate<T> predicate)`: Returns true if no elements match the predicate.

## Chaining

Stream operations are designed to be chained together to form a stream pipeline.

Intermediate operations are the building blocks of a stream pipeline. They process the stream and return a new stream as the output. This allows you to chain multiple operations together, creating a sequence of transformations on the data.

Terminal operations are the final step in the pipeline. They consume the entire stream produced by the chain of intermediate operations. Unlike intermediate operations, terminal operations typically return a non-Stream result (like a count, a collection, or even nothing void) and close the stream. This means you cannot perform further operations on the stream after a terminal operation is called.

## Laziness

A key feature of Streams is laziness. This means that operations are not physically executed **until a terminal operation is called.** This allows for efficient processing, especially for large datasets, because only the required operations are performed.

## Parallel Processing

Streams can leverage multi-core architectures without you having to write a single line of multithread code.

Just replace `stream()` with `parallelStream()` and the Streams API will internally decompose your query to leverage the multiple cores on your computer.

---

How would you use `Stream.filter()` with a lambda to remove null or empty strings?

```
list.stream()
    .filter(s -> s != null && !s.isEmpty())
    .collect(Collectors.toList());
```

---
