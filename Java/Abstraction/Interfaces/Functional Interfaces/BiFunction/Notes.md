# Understanding BiFunction Functional Interface

- Contains one abstract method called `apply` which accepts two arguments of types `T` and `U` and returns a single value of type `R` based on the operation performed on the two arguments.
- Contains a default method called `andThen` which allows us to chain another `Function` that will be applied to the result of the `BiFunction`.

```
@FunctionalInterface BiFunction<T, U, R> {

    R apply(T t, U u);

    default BiFunction<T, U, V> andThen(Function<R, V> after) {

        Objects.requireNonNull(after);
        BiFunction<T, U, V> output = (T t, U u) -> after.apply(apply(t, u));
    }

}
```

## Application

The `BiFunction` functional interface is often used in conjunction with various stream operations to perform transformations or aggregations that involve two inputs.
