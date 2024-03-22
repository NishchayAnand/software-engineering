# Understanding Abstraction in Java

The idea behind Abstraction is to create a simplified view (abstraction) of an object, hiding the complexities of its internal workings.

Abstraction can be implemented using two primary mechanisms in Java:

- **Abstract Classes**
- **Interfaces**

## Abstract Classes

Abstract classes provide a way to create a foundation (blueprint) for a group of related classes. They enforce a common structure and behavior while allowing for flexibility in how subclasses implement specific functionalities.

We can use the `abtract` keyword as a prefix before the `class` keyword to declare an abstract class.

**Example:**

```
public abstract class Shape {
  // ... (class definition)
}
```

**Abstract classes can contain:**

- **Attributes:** To provide the essential properties that all subclasses will have in common. For instance, a `Shape` abstract class might have a `name` attribute.

- **Concrete Methods:** To provide pre-defined methods that subclasses can inherit and use directly or customize if needed.

- **Abstract Methods:** To declare methods without a method body. The specifics of the functinalities are left open for subclasses to customize.

> **_NOTE:_** Abstract classes can have constructors like any other class.

**Example:**

```
// Abstract class
abstract class Shape {

    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method
    public abstract double calculateArea();

}

// Subclass implementing abstract class
class Circle extends Shape {

    private double radius;

    // Constructor
    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    // Abtract method implementation
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

}
```

**Key characteristics associated with abstract classes:**

- **Abstract Classes Cannot Be Instantiated**: Abstract classes often lack complete implementations for all functionalities. An object in this state wouldn't be usable. Hence, abstract classes cannot be instantiated.

- **Subclasses Must Implement All Inherited Abstract Methods:** Subclasses inheriting from the abstract class must provide implementations for all the abstract methods they inherit. This enforces consistency and predictable behavior across all derived classes.

## Interfaces
