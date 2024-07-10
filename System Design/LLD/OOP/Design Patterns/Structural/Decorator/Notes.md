# Understanding Decorator Design Pattern

**DEFINITION:** The Decorator pattern attaches additioanl responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.

Gives solution to the typical overuse of inheritance - **decorate your classes at runtime using a form of object composition**.

Once you know the techniques of decorating, you'll be able to give your objects new responsibilities without making any code changes to the underlying classes.

**Composition** and **Delegation** are the ways of inheriting behavior at runtime.

## Composition

**Composition** allows us to extend an object's behavior dynamically at runtime. You can add multiple new responsibilities to objects through this technique, including responsibilities that were not even thought of by the designer of the superclass.

By dynamically composing objects, I can add new functionalities by writing new code rather than altering existing code. Because I'm not changing existing code, the chances of introducing bugs or causing unintended side effects in pre-existing code are much reduced.

**REMEMBER:** Code should be closed to change, yet open to extension (Open-Close Principle).

## Properties of a Decorator

1. **Decorators have the same supertype as the objects they decorate**, i.e., Decorators implement the same interface or abstract class as the component they are going to decorate.

2. **The Decorator adds its own behavior before and/or after delegating to the component (object) it decorates to do the rest of the job**, i.e., Decorators can add new methods, however, new behavior is typically added by doing computation before or after an existing method in the component.

3. We can pass a decorated object in place of the original (wrapped) object.

4. You can use one or more decorators to wrap an object.

> **NOTE:** Think of Decorator objects as _"wrappers"_.

## How to implement Decorator Pattern?

## Real-World Decorators

The java.io package is largely based on Decorator Pattern. For example, `FileInputStream` is decorated with `BufferedInputStream` which in turn is decorated with `ZipInputStream`.

## Disadvantages of Decorator Pattern

Designs using Decorator Pattern often result in a large number of small classes that can be overwhelming to a developer trying to use the Decorator-based API.

> **NOTE:** We typically create decorators by using other patterns like **Factory** and **Builder**.

## EXTRA

When we inherit behavior by subclassing, that behavior is set statically at compile time. In other words, we get only whatever behavior the superclass gives us or that we override.

With composition, we can implement new decorators at any time to add new behavior. If we relied on inheritance, we may have to modify the existing code every time we wish to add new behavior.

It's important that the decorators have the same type as the objects they are going to decorate. We may use inheritance to achieve **type matching**, but shouldn't use it to get behavior. We can acquire new behavior not by _inheriting_ it from a superclass, but by _composing_ objects together.
