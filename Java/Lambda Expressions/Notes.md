# Understanding Lambda Expressions

- One issue with anonymous classes is that if the implementation of your anonymous class is very simple, such as an interface that contains only one method, then the syntax of anonymous classes may seem unwieldy and unclear. In these cases, **you're usually trying to pass functionality as an argument to another method**, such as what action should be taken when someone clicks a button.

- For classes with only one method, even an anonymous class seems a bit excessive and cumbersome.

- Lambda expressions let you **express instances of `single-method classes` more compactly**.

- Lambda expressions can be used to implement functional interfaces. Because a functional interface contains only one abstract method, you can omit the name of that method when you implement it.

- Lambda functions provide an another way of writing instances of anonymous classes. It provides a more readable way of writing such instances.

- Lambda expressions enable you to treat functionality as method argument, or code as data.

- Makes instances of anonymous classes easier to write and **read**.

> **_NOTE:_** We spend much more time reading code than writing.

- `FileFilter filter = (File file) -> file.getName().endsWith(".java");` --> this expression is an implementation of the FileFilter interface.

- A lambda expression looks a lot like a method declaration; you can consider lambda expressions as anonymous methods—methods without a name.

- Like local and anonymous classes, lambda expressions can capture variables; they have the same access to local variables of the enclosing scope. However, unlike local and anonymous classes, lambda expressions do not have any shadowing issues (see Shadowing for more information). Lambda expressions are lexically scoped. This means that they do not inherit any names from a supertype or introduce a new level of scoping. Declarations in a lambda expression are interpreted just as they are in the enclosing environment.

- To determine the type of a lambda expression, the Java compiler uses the target type of the context or situation in which the lambda expression was found. It follows that you can only use lambda expressions in situations in which the Java compiler can determine a target type.

## Use Cases:

- Can be used with the collection API to efficiently process data.

---

> **_NOTE:_** The serialization of lambda expressions is strongly discouraged.

Link:

- For understanding differences between `Local Classes`, `Anonymous Classes` and `Lambda Expressions`: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
