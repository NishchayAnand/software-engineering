# Understanding other design principles

## Don't Repeat Yourself (DRY)

## Encapsulate what changes

## Favor composition over inheritance

## Programming to an interface, not an implementation

- The point is to exploit polymorphism by programming to a supertype so that the actual runtime object isn't locked into the code.

- We can rephrase "program to a supertype" as "the declared type of the variables should be a supertype, usually an abstract class or interface, so that the objects assigned to those variables can be of any conrete implementation of the supertype, which means the class declaring them doesn't have to know about the actual object types".

- Programming to an implementation would be like:

  - Dog d = new Dog();

- Programming to an interface/supertype would be like:
  - Animal animal = new Animal();
