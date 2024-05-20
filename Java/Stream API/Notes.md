# Understanding Java Stream API

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
