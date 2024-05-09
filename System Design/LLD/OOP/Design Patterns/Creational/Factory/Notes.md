# Understanding Factory Design Patterns

- The Factory and Abstract Factory Patterns are about delegating the creation of one or more objects to a special class called factory.

- There are 3 types of factories:

- **Simple Factory:**

  - it is too simple to be considered a pattern.
  - By using new operator directly in the assignment (object creation and assigning it to a reference variable), we cannot dynamically change the object. To do this, we need to avoid the new operator. The solution is to move the code that creates the object to a method.

- **Factory Method:**

  - If we have large large number of objects to create, this method can become a nightmare to maintain. The solution is to create a hierarchy of factory classes, defining a supertype, usually an abstract class and then create **simple factory** class for each object type. This is the idea behind Factory Method Pattern.
  - It is a specialization of the `template` design pattern.

- **Abstract Factory:**

  - An extended version of the Factory Method Design Pattern.
  - deals with creating hierarchies or families of related objects.
