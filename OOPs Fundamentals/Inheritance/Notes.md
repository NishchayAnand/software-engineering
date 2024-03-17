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

Method Overriding: Subclasses can inherit methods from parent classes and redefine them (override) to provide their own implementation. This allows for specialized behavior based on the object's type.

Duck typing is a concept in object-oriented programming that emphasizes the importance of an object's capabilities over its specific class. In Python, which is a dynamically typed language, duck typing plays a significant role. Here's a breakdown of the concept:

Origin and Analogy:

The phrase "duck typing" comes from the proverb "If it walks like a duck and quacks like a duck, then it must be a duck." In the context of programming, it translates to:

If an object has the attributes and methods required for a particular task, it can be used for that task, regardless of the object's actual class.

When you call a method on an object, Python checks if the object has the necessary method defined, not the object's exact class (type).

This allows objects from different classes to be used interchangeably as long as they provide the required functionality.
