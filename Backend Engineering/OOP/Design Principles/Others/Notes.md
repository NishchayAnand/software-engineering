# Understanding other design principles

## Don't Repeat Yourself (DRY)

## Encapsulate what changes

## Favor composition over inheritance

## Programming to an interface, not an implementation

## Principle of Least Knowledge

## Hollywood Principle: Don't call us, we'll call you.

Guides us to reduce the interactions between objects to just a few close "friends". It means when you are designing a system, for any object, be careful of the number of classes it interacts with and also how it comes to interact with those classes.

This principle prevents us from creating designs that have a large number of classes coupled together so that changes in one part of the system cascade to other parts. When you build a lot of dependencies between many classes, you are building a fragile system that will be costly to maintain and complex for others to understand.

The principle provides some guidelines: take any object and from any method in that object, invoke only methods that belong to:

- The object itself.
- Objects passed in as a parameter to the method.
- Any object the method creates or instantiates.
- Any components (any object that is referenced by an instance variable) of the object.

> **NOTE:** In OO programming, only one friend is a GOOD friend.

---

## EXTRA

- The point is to exploit polymorphism by programming to a supertype so that the actual runtime object isn't locked into the code.

- We can rephrase "program to a supertype" as "the declared type of the variables should be a supertype, usually an abstract class or interface, so that the objects assigned to those variables can be of any conrete implementation of the supertype, which means the class declaring them doesn't have to know about the actual object types".

- Programming to an implementation would be like:

  - Dog d = new Dog();

- Programming to an interface/supertype would be like:
  - Animal animal = new Animal();
