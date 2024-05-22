# Understanding Function Functional Interface

- A functional interface that contains a single abstract method called `apply` that takes in an object and returns another object.

```
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
    ... (default methods such as andThen to allow operation chaining)
}
```

- The apply method will perform some modification on the `t` object and return the modified object of type `R`.

- Can be passed as an argument to the Stream APIs `map` operation.

```
Function<List<?>, Integer> size = List::size;
list.stream()
    .map(size)
    .forEach(System.out::println);
```
