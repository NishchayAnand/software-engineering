# Understanding Predicate Functional Interface

- Contains one abstract method called `test` which evaluates a condition on an input argument of type `T` and returns a boolean value.
- Commonly used for filtering data and making decisions based on conditions.
- Includes several default methods for combining predicates, such as `and`, `or`, and `negate`.

```
@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        Objects.requireNonNull(other);
        Predicate<T> output = (t) -> test(t) && other.test(t);
        return output;
    }

    default Predicate<T> or(Predicate<T> other) {
        Objects.requireNonNull(other);
        Predicate<T> output = (t) -> test(t) || other.test(t);
        return output;
    }

    default Predicate<T> negate() {
        Predicate<T> output = (t) -> !test(t);
        return output;
    }

}
```

## Application

Used with the `Stream` API in Java for filtering elements in a stream.

```
Predicate<Integer> isEven = num -> num % 2 == 0;
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
numbers.stream()
    .filter(isEven)
    .forEach(System.out::println);
```
