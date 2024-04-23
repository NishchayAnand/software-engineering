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

> Since Java 8, interfaces can have **static** and **default methods** that provide implementations within the interface itself.

EXTRA:

-Interfaces cannot contain state (whereas Abstract Class can). This opens the door to multiple inheritance.

- Since the component's API is a contract with its clients, a component's owner can't just change it without considering the consequences for the clients.
