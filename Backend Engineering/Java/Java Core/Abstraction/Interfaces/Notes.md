# Understanding Interfaces

Interfaces are like contracts that specify the functionalities (methods) a class must provide, but they don't dictate how those functionalities are implemented.

> **Analogy:** Imagine you're working at a restaurant. You have a menu that lists all the available dishes **(functionalities)** but doesn't tell you how the chef prepares them **(implementation details)**. That menu acts like an interface in Java.

Interfaces can be declared using the `interface` keyword followed by the interface name.

#### Example:

```
interface Shape {
  // ... (Interface body)
}
```

#### Interfaces can contain:

- **Constants:** Variables which are implicitly `public`, `static`, and `final`. They must be initialized during their declaration and can be accessed using the interface name (e.g., Math.PI).

- **Method Signatures:** Empty Methods (without method bodies) which are implicitly `public` and `abstract`. Any class that implements an interface must provide concrete implementations for all of the interface's methods.

#### Example:

```
interface Shape {
    // Constants
    double PI = 3.14159;

    // Method signature
    double calculateArea();
}

// Class implementing the interface
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Abstract method implementation
    @Override
    public double calculateArea() {
        return PI * radius * radius;
    }
}
```

#### Key characteristics associated with interfaces:

- **No Direct Objects:** Since interfaces lack complete implementations, you cannot directly create objects of an interface type.

- **Supports Multiple Inheritance:** A class can implement multiple interfaces, inheriting methods and constants from all of them. This allows for greater flexibility and code reuse.

## New Advancements in Java 8 - Static and Default Methods:

Since Java 8, interfaces can have **static** and **default** methods to provide enhanced flexibility and functionality in interface design.

### Default Methods: Enhancing Interfaces with New Methods Without Breaking Existing Implementations

Default methods allow developers to **add new methods** to interfaces without forcing all implementing classes to provide an implementation. This **ensures backward compatibility**, meaning existing code that implements an interface won't break when new methods are added to the interface.

#### Key Points:

- Default methods can provide common **functionality that multiple classes can use**, reducing code duplication.
- Default methods are **associated with instances** of the implementing classes.
- Implementing classes **can override the default methods** to provide their own behavior.

### Static Methods:

Static methods allow developers to **provide utility or helper methods** that provide common operations related to the interface.

#### Key Points:

- Static methods are **related to the interface** itself rather than any instance of the interface.
- Static methods are not inherited by the implementing classes.

> **_NOTE:_** Abstract methods are implicitly public. Default and static methods must have an explicit public modifier.
