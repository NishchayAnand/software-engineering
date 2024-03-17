# Understanding Inheritance

Inheritance in OOP is like inheriting traits from a family line in real life. In the programming world, it's a mechanism where new classes **(subclasses)** acquire the properties and behaviors of existing classes **(superclasses)**. This promotes code reuse and creation of well-organized object hierarchies.

Here's an example to illustrate inheritance:

```
// Superclass (Parent Class)
class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }
}

// Subclass (Child Class)
class Dog extends Animal {
    public void bark() {
        System.out.println("Dog is barking");
    }
}
```

The relationship between a subclass and a superclass is called an `is-a` relationship. For instance, a Dog **_is a_** type of Animal, implying that it inherits all the general characteristics of an Animal (for example, `eat` behavior) but also has its own specific features and behaviors (for example, `bark` behavior) that differentiate it from other Animals.

Subclasses inherit public and protected fields and not anything that is called out as private.

Allows us to:

- access the non-private attributes and methods of the base class.
- override the implementation of existing methods, i.e., the non-private methods (not defined with the final modifier) of the base class.

Constructors are not inherited in a derived class. Therefore, a child's constructor is responsible for calling the parent's constructor using the super keyword.
