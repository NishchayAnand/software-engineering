# Understanding Method References

- **Method references offer a convenient alternative to lambda expressions when your code simply needs to reference an existing method.**

- It is just syntactic/sugarly way of writing simple lambda expression code. No other benefit is provided by method references.

- Another way of writing lambda expressions.

- Method references in Java are a concise way to refer to existing methods without the need for a lambda expression. They provide a shorthand syntax for situations where a lambda expression would simply call a method.

- Provides a way to reference a method by its name and optionally the object it belongs to.

- Method reference is used to refer method of functional interface.

- Types of Method References:

  - **Static Method Reference:** Refers to a static method of a class. Syntax: `ClassName::methodName (e.g., String::valueOf)`
  - **Instance Method Reference of a Particular Object:** Refers to a method of a specific object instance. Syntax: `objectInstance::methodName (e.g., myString::toUpperCase)`
  - **Constructor Reference:** Refers to a constructor of a class. Syntax: `ClassName::new (e.g., Person::new)`

## Examples:

- The lambda expression: `Consumer<String> c = s -> System.out.println(s);` can be written like `Consumer<String> c = System.out::println;` using method references. Here, `System.out` is the object and `println` is the method that will be invoked by the lambda expresssion.

- The lambda expression: `Comparator<Integer> c = (i1, i2) -> Integer.compareTo(i1, i2);` can be written as `Comparator<Integer> c = Integer::compare;`. Here, `Integer` is the object and `compare` is the method that will be invoked by the lambda expression.

- The lambda expression: `list.forEach(Person -> System.out.println(Person));` can be written like `list.forEach(System.out::println);` using method reference.

> NOTE: `::` represents the method reference.
