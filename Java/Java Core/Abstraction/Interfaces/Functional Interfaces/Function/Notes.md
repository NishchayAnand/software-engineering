# Understanding Function Functional Interface

- Contains one abstract method called `apply` which accepts a single argument of any type `T` and returns a value of a specific type `R` based on the operation performed on the argument.
- Can be used to **transform elements** within a stream by applying a specific operation on each element and returning the modified value.
- Contains a default method called `andThen` which allows us to execute another function after the current function.

```
@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);

    default Function<T, V> andThen(Function<R, V> after) {
        Objects.requireNonNull(after);
        Function<T, R> output = (T t) -> after.apply(apply(t));
        return output;
    }

}
```

## Application

The `map` method in the `Stream` API takes a `Function` as an argument, which it applies to each element of the stream. The result is a new stream containing the results of applying the function to the elements of the original stream.

```
List<String> names = Arrays.toList("Rajiv", "Veenu", "Nishchay", "Vridhi", "Archie");
Function<String, Integer> size = name -> name.length();
names.stream()
    .map(size)
    .forEach(System.out::println);
```
