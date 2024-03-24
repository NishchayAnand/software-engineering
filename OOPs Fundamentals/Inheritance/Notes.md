# Understanding Inheritance

Inheritance in OOP is like inheriting traits from a family line in real life. In the programming world, it's a mechanism that allows new classes **(subclasses)** acquire the properties and behaviors of existing classes **(superclasses)**. This promotes code reuse and well-organized object hierarchies.

Here's an example to illustrate inheritance:

```
// Superclass (Parent Class)
class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

}

// Subclass (Child Class)
class Dog extends Animal {

    private String breed;

    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

}
```

## Is-a Relationship

The relationship between a child class and a parent class is called an `is-a` relationship. For instance, a Dog **_is a_** type of Animal, implying that it inherits all the general characteristics of an Animal (for example, `name` attribute) but also has its own specific features and behaviors (for example, `breed` attribute) that differentiate it from other Animals.

## No inheritance of Constructors

Constructors are not inherited in a child class. This is because constructors are responsible for initializing the object's state, and each class might have different initialization requirements.

The child's constructor is responsible for calling the parent's constructor.

> If the parent class doesn't have an explicitly defined constructor, Java implicitly adds a call to the parent class's default constructor in the child class constructor. However, if the parent class does have an explicitly defined constructor, the child class constructor must explicitly call it using the **super** keyword (should be the first line within the child class constructor).

## Method Overriding

Inheritance allows child classes to override the implementation of existing methods (non-private) inherited from the parent class. This allows for specialized behavior based on the object's type.

Here's an example to illustrate method overriding:

```
// Superclass (Parent Class)
class Animal {

    public void makeSound() {
        System.out.println("Generic Animal Sound");
    }

}

// Subclass (Child Class)
class Dog extends Animal {

    // Override inherited method (specialization)
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

}
```

Overriding plays a crucial role in achieving `polymorphism`.

## Disadvantages of Inheriting from Classes

Ther are two significant disadvantages of inheriting from classes:

- **Leads To Type Coupling Between Superclass And Subclasses:** A subclass becomes tightly coupled to the implementation details of its superclass. If the superclass implementation changes (even if the public interface remains the same), the subclass might break because it depends on the old behavior. This can be a maintenance nightmare, especially with large codebases and frequent updates.

- **Does Not Support Multiple Inheritance:** Inheriting from multiple classes can introduce complexities that can make your code harder to understand and maintain.
