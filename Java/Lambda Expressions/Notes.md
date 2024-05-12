# Understanding Lambda Expressions

One issue with anonymous classes is that if the implementation of your anonymous class is very simple, such as an interface that contains only one method, then the syntax of anonymous classes may seem unwieldy and unclear. In these cases, **you're usually trying to pass functionality as an argument to another method**, such as what action should be taken when someone clicks a button.

For classes with only one method, even an anonymous class seems a bit excessive and cumbersome.

Lambda expressions let you **express instances of `single-method classes` more compactly**.

Lambda expressions can be used to implement functional interfaces. Because a functional interface contains only one abstract method, you can omit the name of that method when you implement it.

Lambda functions provide an another way of writing instances of anonymous classes. It provides a more readable way of writing such instances.

- Lambda expressions enable you to treat functionality as method argument, or code as data.

- Makes instances of anonymous classes easier to write and **read**.

> NOTE: We spend much more time reading code than writing.

- `FileFilter filter = (File file) -> file.getName().endsWith(".java");` --> this expression is an implementation of the FileFilter interface.

## Use Cases:

- Can be used with the collection API to efficiently process data.

---

Link:

- For understanding differences between `Local Classes`, `Anonymous Classes` and `Lambda Expressions`: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
