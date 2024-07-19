# Interview Questions

**Q1. What is the difference between `Abtraction` and `Encapsulation`?**

- `Encapsulation` is all about **bundling data and the methods** that operate on that data together **into a single unit**. Encapsulation helps **shield the internal data (properties)** of an object from direct external access.

- `Abstraction` states that the **external behavior (interface)** of an object **should be kept separate from the implementation details** of how that behavior is achieved. It gives us the **freedom to modify the internal workings** of an object without impacting any code using that object.

- Encapsulation **"protects what's inside"** of an object (data), whereas, Abstraction focuses on **"how to use"** that object (functionalities).

---

**Q2. What were the differences between `Abstract Classes` and `Interfaces` before Java 8?**

Before Java 8, the differences between abstract classes and interfaces in Java were more pronounced. Here are the key distinctions:

### Abstract Classes

1. **Abstract classes can have both abstract methods (methods without an implementation) and concrete methods (methods with an implementation).** Concrete methods in abstract classes can provide a default behavior that subclasses can use or override.

2. **Abstract classes can have instance variables (fields) with various access modifiers** (private, protected, public).

3. A **class can inherit from only one abstract class** due to Java’s single inheritance constraint.

4. **Methods** in abstract classes **can have any access modifier**: private, protected, public, or package-private (default).

5. Though Abstract classes cannote be instantiated, they can have constructors, which can be used to initialize fields in the abstract class. Subclasses can call the constructor of the abstract class using super().

### Interfaces

1. Interfaces could only have abstract methods (methods without an implementation).

2. Interfaces cannot have any instance variables (fields). We can **only define constants** which were implicitly `public`, `static`, and `final`.

3. A class can implement multiple interfaces, **providing** a form of **multiple inheritance**.

4. All methods in interfaces were implicitly `public` and `abstract`.

5. Interfaces cannot have constructors because they cannot have any instance fields.

---

**Q3. What are the differences between `Abstract Classes` and `Interfaces` after Java 8?**

After Java 8, the distinctions between abstract classes and interfaces have narrowed due to the introduction of `default` and `static` methods in interfaces. Here are the key distinctions:

1. **Abstract Classes can have instance variables that maintain instance-specific `state`, whereas Interfaces cannot.**

2. A class can only implement one Abstract Class whereas it can implement multiple Interfaces. **If a class implements multiple interfaces that have `default` methods with the same signature, the class must override the method to resolve the conflict.**

---
