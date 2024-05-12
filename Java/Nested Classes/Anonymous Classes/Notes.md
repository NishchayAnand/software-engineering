# Understanding Anonymous Classes in Java

Anonymous classes are a special type of `inner` class that don't have a name.

- Anonymous classes enable you to provide implementation of an interface in a more concise way.

- They enable you to declare and instantiate a class at the same time.

- Anonymous classes are expressions.

- They promote concise code by allowing you to create a class for a specific purpose without needing a separate class definition.

- It allows us to put the technical code at the same place as the place where it is used. It gives more clearity since we can see code that will be executed. However, will make the code more cluttered.

- Anonymous classes have access to local variables of the enclosing scope, but with some restrictions. Local variables must be final or effectively final to be accessed from within the anonymous class.

Anonymous classes are ideal for implementing an interface that contains **two or more methods**.

The syntax of an anonymous class expression is like the invocation of a constructor, except that there is a class definition contained in a block of code.

Consider the instantiation of the frenchGreeting object:

```
interface HelloWorld {
    public void greet();
    public void greetSomeone(String someone);
}

HelloWorld frenchGreeting = new HelloWorld() {

    String name = "tout le monde";

    public void greet() {
        greetSomeone("tout le monde");
    }

    public void greetSomeone(String someone) {
        name = someone;
        System.out.println("Salut " + name);
    }

};
```

> NOTE: When you implement an interface, there is no constructor, so you use an empty pair of parentheses, as in `new HelloWorld()` in the above example.

An anonymous class has access to the members of its enclosing class. However, it cannot access local variables in its enclosing scope that are not declared as `final` or effectively final.

An anonymous class can have static members provided that they are constant variables.

You can declare `Fields` and `Extra methods` in anonymous classes.

You cannot declare constructors in an anonymous class.

## Use Cases:

- **Short-lived Functionality:** When you need a class for a one-time use or a very specific task, anonymous classes can be a clean way to achieve that functionality without cluttering your code with separate class definitions.
