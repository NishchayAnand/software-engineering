# Understanding Generics in Java

- In any nontrivial software project, bugs are simply a fact of life. Careful planning, programming, and testing can help reduce their pervasiveness, but somehow, somewhere, they'll always find a way to creep into your code. This becomes especially apparent as new features are introduced and your code base grows in size and complexity.

- Fortunately, some bugs are easier to detect than others. Compile-time bugs, for example, can be detected early on; you can use the compiler's error messages to figure out what the problem is and fix it, right then and there. Runtime bugs, however, can be much more problematic; they don't always surface immediately, and when they do, it may be at a point in the program that is far removed from the actual cause of the problem.

- **Generics add stability to your code by making more of your bugs detectable at compile time.**

- In a nutshell, generics enable types (classes and interfaces) to be parameters when defining classes, interfaces and methods.

- Code that uses generics has many benefits over non-generic code:

- **Elimination of casts:** The following code snippet without generics requires casting:

```
List list = new ArrayList();
list.add("hello");
String s = (String) list.get(0);
```

When re-written to use generics, the code does not require casting:

```
List<String> list = new ArrayList<String>();
list.add("hello");
String s = list.get(0);   // no cast
```

- **Enabling programmers to implement generic algorithms:** By using generics, programmers can implement generic algorithms that work on collections of different types, can be customized, and are type safe and easier to read.

## Generic Types

A generic type is a generic class or interface that is parameterized over types.

A generic class is defined with the following format:

```
class name<T1, T2, ..., Tn> {
    ...
}
```

Begin by examining a non-generic Box class that operates on objects of any type. It needs only to provide two methods: set, which adds an object to the box, and get, which retrieves it:

```
public class Box {
    private Object object;

    public void set(Object object) { this.object = object; }
    public Object get() { return object; }
}
```

Since its methods accept or return an Object, you are free to pass in whatever you want, provided that it is not one of the primitive types. There is no way to verify, at compile time, how the class is used. One part of the code may place an Integer in the box and expect to get Integers out of it, while another part of the code may mistakenly pass in a String, resulting in a runtime error.

With this change, the Box class becomes:

```
public class Box<T> {
    // T stands for "Type"
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}
```

As you can see, all occurrences of Object are replaced by T. A type variable can be any non-primitive type you specify: any class type, any interface type, any array type, or even another type variable.

By convention, type parameter names are single, uppercase letters. This stands in sharp contrast to the variable naming conventions that you already know about, and with good reason: Without this convention, it would be difficult to tell the difference between a type variable and an ordinary class or interface name.

The most commonly used type parameter names are:

- E - Element (used extensively by the Java Collections Framework)
- K - Key
- N - Number
- T - Type
- V - Value

To reference the generic Box class from within your code, you must perform a generic type invocation, which replaces T with some concrete value, such as Integer:

```
Box<Integer> integerBox;
```

To instantiate this class, use the new keyword, as usual, but place <Integer> between the class name and the parenthesis:

```
Box<Integer> integerBox = new Box<Integer>();
```

In Java SE 7 and later, you can replace the `type arguments` required to invoke the constructor of a generic class with an empty set of type arguments (<>) as long as the a Java compiler can infer types from the declaration. This pair of angle brackets, <>, is informally called the diamond. For example, you can create an instance of Box<Integer> with the following statement:

```
Box<Integer> integerBox = new Box<>();
```

## Multiple Type Parameters

A generic class can have multiple type parameters. For example,

```
public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}
```

## Parameterized Types

You can also substitute a type parameter (that is, K or V) with a parameterized type (that is, List<String>). For example, using the OrderedPair<K, V> example:

```
OrderedPair<String, Box<Integer>> p = new OrderedPair<>("primes", new Box<Integer>(...));
```

---

Link:

- Why use Generics: https://docs.oracle.com/javase/tutorial/java/generics/why.html
