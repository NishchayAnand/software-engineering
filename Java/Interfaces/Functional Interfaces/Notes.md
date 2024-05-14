# Understanding Functional Interfaces

A functional interface is any interface that contains only one abstract method.

> NOTE: A functional interface may contain one or more `default` methods or `static` methods.

Functional interfaces promote `functional programming paradigms` in Java by **allowing you to treat functions as first-class citizens. This means you can pass functions as arguments and return them from methods.**

There are two main ways to define functional interfaces in Java:

- **Using the @FunctionalInterface Annotation (Recommended):** This is the preferred approach as it explicitly declares the interface as functional and **helps the compiler enforce the single abstract method rule**. Here's the syntax:

```
@FunctionalInterface
public interface MyFunctionalInterface {
    ...
}
```

- **Without the @FunctionalInterface Annotation (Not Recommended):** While technically possible, it's not recommended to define functional interfaces without the annotation.The compiler won't enforce the single abstract method rule here. If you accidentally add more abstract methods, your code might compile but will throw errors at runtime.
