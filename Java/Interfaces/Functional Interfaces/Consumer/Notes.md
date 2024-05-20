# Understanding Consumer Functional Interface

- Contains a single abstract method called `accept` that can takes an object of any type `T` as parameter and do some processing on it.

```
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
    ... (contains default methods such as 'andThen' that allows us to chain method calls) ??
}
```

- Can be implemented using a lambda expression.

```
Consumer<T> c = p -> System.out.println(p);
```

OR

```
Consumer<T> c = System.out::println;
```

- Often used with Stream API **to consume stream.** For example:

```
List<Person> persons = ...;
Stream<Person> strm = persons.stream();
strm.forEach(person -> System.out.println(person));
```

The `forEach` method in the above example takes an instance of the `Consumer` **functional interface** as an argument.
