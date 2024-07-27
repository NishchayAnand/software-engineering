# Understanding Factory Pattern

Code that instantiates concrete classes is an area of frequent change. We know it's always better to encapsulate code that varies.

Intantiation is an activity that shouldn't always be done in public and can often lead to coupling problems.

We aren't supposed to program to an implementation, but every time we use the **new** operator, we are certainly instantiating a concrete class which is definitely an implementation and not an interface.

If your code is written to an interface, then it will work with any new class implementing that interface (through polymorphism). However, when you have code that makes use of lots of concrete classes, the code may have to be changed as new concrete classes are added. To extend your code with new concrete types, you'll have to reopen it for modification, violating the **open-close principle.**

> **NOTE:** Factory Pattern promotes **Open-Close Principle** and **Dependency Inversion Principle**.

## What is a Factory?

Factories handle the details of object creation. All factory patterns **encapsulate object creation**.

## Simple Factory Pattern

The Simple Factory isn't actually a design Pattern, it's more of a programming idiom. We defined an abstract class with some helpful implementations that can be overridden.

> NOTE: The Simple Factory Pattern (also known as the Static Factory Pattern) is not a part of the GoF (Gang of Four) design patterns.

There is more to making objects than just using the new operator. Instantiation is an activity that shouldn't be done in public, because it can lead to coupling problems.

If we have large number of objects to create, this method can become a nightmare to maintain. The solution is to create a hierarchy of factory classes, defining a supertype, usually an abstract class and then create **simple factory** class for each object type.

**Issue with Simple Factory:** Often relies on complex conditional statements to determine the type of object to create. As the number of object types increases, the factory method becomes cumbersome to maintain and less readable. Also, it violates the **Dependency Inversion Principle.**

## Factory Method Pattern

**DEFINITION: Defines an interface for creating an object, but lets subclass decide which class to instantiate. Factory Method lets a class defer instantiation to subclasses.**

The Factory Method Pattern encapsulates object creation by letting subclasses decide what objects to create. All the responsibility of instantiation can be moved into a **method** that acts as a **factory**.

A **factory method** handles object creation and encapsulates it in a subclass. This decouples the client code in the superclass from the object creation code in the subclass.

**A factory method isolates the client code in the superclass from knowing what kind of concrete product is actually created.**

Allows for more modular and extensible code. New object types can be added by creating new subclasses without modifying the main factory interface or client code.

**CRUX:** With Factory Method, you're using a subclass to do your creation for you. In that way, clients only need to know the abstract type they are using, the subclass worries about the concrete type. In other words, it keeps clients decoupled from the concrete types.

## Abstract Factory

**DEFINITION:** Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

An abstract factory defines the interface that all concrete factories must implement, which consists of a set of methods for producing products. Each method in that interface is responsible for creating a concrete product, and we implement a subclass of the abstract factory to supply those implementations. So, abstract methods are a natural way to implement your product methods in your abstract factories.

An abstract factory provides an interface for a family of products. By writing code that uses this interface, we decouple our code from the actual factory that creates the products.

From abstract factory, we define one or more concrete factories that produce the same products, but with different implementations.

> NOTE: The interface needs to change if new products needs to be added.

## Advantages of Factory Pattern

By placing all the creation code in object or method, we can avoid duplication in our code and provide one place to perform maintenance. That also means **clients depend only upon interfaces rather than the concrete classes required to instantiate objects.** This allows us to program to an interface, not an implementation.
