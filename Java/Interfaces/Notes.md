# Understanding Interfaces

Interfaces are like contracts that specify the functionalities (methods) a class must provide, but they don't dictate how those functionalities are implemented.

> **Analogy:** Imagine you're working at a restaurant. You have a menu that lists all the available dishes **(functionalities)** but doesn't tell you how the chef prepares them **(implementation details)**. That menu acts like an interface in Java.

Interfaces can be declared using the `interface` keyword followed by the interface name.

**Example:**

```
interface Shape {
  // ... (Interface body)
}
```

**Interfaces can contain:**

- **Constants:** Variables which are implicitly `public`, `static`, and `final`. They must be initialized during their declaration and can be accessed using the interface name (e.g., Math.PI).

- **Method Signatures:** Empty Methods (without method bodies) which are implicitly `public` and `abstract`. Any class that implements an interface must provide concrete implementations for all of the interface's methods.

**Example:**

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

**Key characteristics associated with interfaces:**

- **No Direct Objects:** Since interfaces lack complete implementations, you cannot directly create objects of an interface type.

- **Supports Multiple Inheritance:** A class can implement multiple interfaces, inheriting methods and constants from all of them. This allows for greater flexibility and code reuse.

## New Advancements in Java 8 - Static and Default Methods:

- Since Java 8, interfaces can have **static** and **default methods** that provide implementations within the interface itself.

### Default Methods:

- Default methods can be accessed using an instance of a class implementing the interface.

- Implementing classes can override the default implementation of a method to provide their own behavior.

- **Use Cases:**
  - **Backward Compatibility:** Default methods allow you to add new methods to interfaces without breaking existing implementations. The default implementation ensures the interface remains usable even for older code.
  - **Providing Common Functionality:** Default methods can offer a base implementation for a method that can be overridden by subclasses if needed.

### Static Methods:

- Static methods can also be added to interfaces along with the static final variables. They are associated with the interface itself, not with any instances of classes implementing the interface.

- Static methods can provide utility functions that can be used by any class implementing the interface or even by other parts of your code.

- Static methods can be final or abstract. -> ??

- **Use Cases:**
  - **Utility Methods:** Static methods can provide utility functions that can be used by any class implementing the interface or even by other parts of your code.
  - **Constants:** Interfaces can now hold constants that can be accessed globally using the interface name.

## After Java 8, What was the difference between abstract classes and interfaces?

- Interfaces cannot hold any object specific state whereas abstract class can.
