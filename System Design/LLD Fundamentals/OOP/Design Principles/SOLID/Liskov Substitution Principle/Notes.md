# Understanding Liskov Substitution Principle

- The Liskov Substitution principle states that "Wherever a superclass object is expected, you can always use the subclass object instead." This principle is the ideology behind runtime polymorphism.

- Says that when you inherit from a class, yoy must be able to substitute the subclass for base class without things going wrong.

- When you use inheritance, your subclass gets almost all the methods and fields from the superclass. If you use inheritance incorrectly, you're going to end up with methods and fields that probably don't make sense or you don't need on your subclass.

For example, **Can you use a SUVCar class instead of the more generic Car class?**.
