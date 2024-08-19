# Java Cheatsheet

- `Stack Memory`: part of RAM -> stores temporary variables created by each function -> allocated during compile-time.

- `Heap Memory`: part of RAM -> supports dynamic memory allocation -> allocated during runtime.

- `Instance Variables`: associated with specific object -> lifetime tied to lifetime of object.

- `Local Variables`: declared within a method or block of code -> temporary variables needed only during the execution of the method or block.

- `str.toLowerCase()`: convert a string to lowercase.

- `str.replaceAll(String regex, String replacement)`: replace each substring of a string that matches the given regular expression with a specified replacement.

- `Comparator`: part of the **java.util** package -> implement a **different ordering** than the natural ordering provided by the `Comparable` interface.

- `Template Method Pattern`: behavioral design pattern -> Define the skeleton of an algorithm in a method, deferring some steps to subclasses -> `Arrays.sort()` follows the Template Method pattern -> **defines the skeleton of a sorting algorithm, while allowing specific comparison behavior to be provided through a custom comparator**.

- `Singleton Pattern`: Ensures one and only one object is instantiated for a given class -> gives us a global point of access, just like global variable -> difference between singleton object and global variable is that we can create a Singleton object only when it is needed.

- `Factory Method Pattern`: replace direct object construction calls with calls to a special factory method.

- `Race Condition`: Threads access **shared resources or program variables** that might be worked on by other threads at the same time causing the application data to be inconsistent.

- `Generics`: allows you to create classes, interfaces, and methods that work with different data types without compromising type safety -> Elimination of typecasting -> Enable programmers to implement generic algorithms.

- `Abstraction`: states that the external behavior (interface) of an object should be kept separate from the implementation details of how that behavior is achieved -> gives freedom to modify internal workings without impacting any client code.

- `Method Overriding`: allows a subclass to specify implementation of a method inherited from its superclass -> the access level of the overridden method cannot be more restrictive than the original method in the superclass.

- `Upcasting`: assign a reference variable of superclass type to an object of a subclass.

- `Polymorphism`: ability of an entity to behave in more than one form.

- ` str.toCharArray()`: can be used to convert string into character array.
