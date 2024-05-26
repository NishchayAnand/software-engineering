# Understanding Consumer Functional Interface

- Part of the `java.util.function` package.
- Represents an operation.
- Contains one abstract method called `accept` which takes an object of type `T` as a parameter and performs an operation on it.
- Contains a default method called `andThen` which allows chaining of multiple Consumer operations. It takes another Consumer as an argument and returns a **composed Consumer** that performs, in sequence, the operation of the current Consumer followed by the operation of the argument Consumer.

```
@FunctionalInterface
public interface Consumer<T> {

    void accept(T t);

    default Consumer<T> andThen(Consumer<T> after) {
        Objects.requireNonNull(after);
        Consumer<T> output = (T t) -> {
            accept(t);
            after.accept(t);
        };
        return output;
    }

}
```

- Often used with Stream API **to consume stream.** For example:

```
List<Person> persons = ...;
Stream<Person> personStream = persons.stream();
personStream.forEach(System.out::person);
```
