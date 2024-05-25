# Understanding Stream in Java

Streams offer a way to perform complex data processing operations on a sequence of elements in a declarative and concise manner. They support a wide range of SQL-like operations (e.g. `filter`, `map`, `reduce`, `find`, `match`, `sorted`) that enable functional-style processing of sequences, making it easier to write clean and efficient code.

Streams don't store the data themselves but rather act as a processing abstraction on top of existing data sources like collections (List, Set, etc.), arrays, or even I/O channels.

> NOTE: Collections are about data and streams are about computations.

A collection is an in-memory data structure, which holds all the values that the data structure currently has—every element in the collection has to be computed before it can be added to the collection. In contrast, a stream is a conceptually fixed data structure in which elements are computed on demand.

## Lazy Streams

Stream operations that can be connected are called intermediate operations. They can be connected together because their return type is a Stream. Operations that close a stream pipeline are called terminal operations. They produce a result from a pipeline such as a List, an Integer, or even void (any non-Stream type).

You might be wondering why the distinction is important. Well, intermediate operations do not perform any processing until a terminal operation is invoked on the stream pipeline; they are “lazy.”

---

- A typed interface

- Stream is an object on which one can define operations such as map, filter, reduce.

- **A stream object does not hold any data.**

- A Stream object should not change the data it processes.

- It is an object which is optimized from the algorithm point of view, and able to process data in parallel.

- Gives ways to efficiently process large amounts of data... and also smaller ones.

- It can automatically process the data in parallel, leveraging the computing power of multicore CPUs.

- Why have Stream API if we already had Collection API?
  - Because developer wanted to add new and efficient way of processing data and didn't want to alter the existing Collection API.

## How it's Used?

- Example 1: Using the `stream()` method added in Collection API.

```
List<Person> persons = ...;
Stream<Person> strm = persons.stream();
```

## Different operations supported by streams

- **ForEach Operation:**

```
strm.forEach(person -> System.out.println(person));
```

The `forEach` method in the above example takes an instance of the `Consumer` **functional interface** as an argument.

- **Filter Operation:**

```
Stream<Person> filtered = strm.filter(person -> person.getAge() > 20);
```

The `filter` method in the above example takes an instance of the `Predicate` **functional interface** as an argument.

- An operation on a Stream that returns a Stream is called an **intermediary operation**.

- **Map Operation:**

- Returns a stream, so it is an intermediary operation.

- Takes mappers as parameters

- **Reduction Operation:**

- There are 2 kinds of reduction in the Stream API:

  - aggregation: `min`, `max`, `sum`, `average` etc.

- Takes in an object of BinaryOperator type

## Extra:

- All methods of Stream that return another Stream are lazy.
- `peek(Consumer)` is a alternative option of `forEach(Consumer)` operation that returns a stream.
- `forEach` is a **final** operation whereas `filter`, `peek` are **intermediary** operations.
