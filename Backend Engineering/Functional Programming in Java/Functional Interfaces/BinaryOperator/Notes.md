# Understanding BinaryOperator Functional Interface

- An extension of the `BiFunction` functional interface for cases where both the input and output types are the same.

```
@FunctionaInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> {
    T apply(T t1, T t2);
    // plus static methods
}
```

## Application

The BinaryOperator functional interface is often used with streams for performing mathematical operations like `addition`, `subtraction`, `multiplication`, `division`, or logical operations like `AND`, `OR`, etc.

```
Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6);
BinaryOperator<Integer> multiply = (a, b) -> a * b;
numbers.map(n -> multiply.apply(n, 2)).forEach(System.out::println);
```
