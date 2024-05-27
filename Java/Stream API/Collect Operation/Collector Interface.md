# Understanding Collector Interface in Stream API

Provides a way to accumulate the elements of a stream into a summarized result. It **represents an operation that collects elements from a stream and transforms them into a new result structure.**

It is primarily used for performing mutable reduction operations on **stream elements**.

## Accumulating Elements

It takes elements from a stream and accumulates them into a **container of some sort.** This container can be a **collection** (like `List`, `Set`), a summary statistic (like `count`, `sum`, `average`), or even `a custom data structure`.

## Transformation (Optional)

Collectors can optionally perform a final transformation on the accumulated result before returning it. This is useful for situations where you want to modify the final structure of the collected data.

## Application

The `Collector` interface is often used with the `collect` method in the `Stream` API to perform mutable reduction operations. It allows you to collect stream elements into a mutable result container and perform transformations on the result before returning it.

```
Stream<String> names = Stream.of("Rajiv", "Veenu", "Nishchay", "Vridhi", "Archie");
List<Integer> nameLength = names.map(n -> n.length()).collect(Collectors.toList());
```
