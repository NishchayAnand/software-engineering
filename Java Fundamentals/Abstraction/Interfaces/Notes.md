## Understanding Interfaces

Interfaces are blueprints that define what a class can do **(its behaviors)** without specifying how it does it.

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

- **Method Signatures:** Empty Methods (without method bodies) which are implicitly public and abstract. Any class that implements an interface must provide concrete implementations for all of the interface's methods.

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
