# Understanding BinaryOperator Functional Interface

- BinaryOperator is an extension of the BiFunction functional interface.

```
@FunctionaInterface
public interface BinaryOperator<T> extends BiFunction<T, T, T> {
    T apply(T t1, T t2);
    // plus static methods
}
```
