# Understanding BiFunction Functional Interface

A functional interface that contains a single abstract method `apply` that takes 2 objects and returns a modified object.

```
@FunctionalInterface BiFunction<T, U, R> {
    R apply(T t, U u);
    // plus default methods
}
```
