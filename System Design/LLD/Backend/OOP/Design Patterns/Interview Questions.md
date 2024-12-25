# Design Patterns Interview Questions

Q. Explain Creational Design Patterns.

---

Q. Explain Singleton Pattern.

---

Q. What is the role of `final` keyword in Singleton Pattern?

Declaring the instance variable as `final` ensures that the singleton instance cannot be reassigned once initialized. This guarantees that the same instance is used throughout the application's lifecycle.

> NOTE: Any object assigned to a `final` variable is fully constructed before being visible to other threads (due to Java's memory model). Hence, it is typically used for **eager initialization, where the singleton instance is created at class-loading time**.

---

Q. Explain Factory Pattern. 

The Factory Design Pattern is a creational design pattern that **provides a way to create objects without specifying the exact class of object that will be created**. It abstracts the instantiation logic and allows the code to depend on an interface or abstract class rather than a concrete class, supporting polymorphism and dependency injection. 

---

Q. Explain the difference between Simple Factory and Factory Method Pattern.

1. **Simple Factory**: Encapsulates the creation logic in a single method or class. Adding a new type of object involves modifying the factory, **violating the Open/Closed Principle (OCP)**.

   ```
   public class EntityManagerFactory {

        public static EntityManager getEntityManager() {
            return new EntityManager();
        }

    }
   ```

2. **Factory Method**: Provides an interface for creating objects and uses inheritance to delegate the instantiation logic to subclasses. Adding a new type of object only involves creating a new subclass without modifying existing code, **adhering to OCP**.

   ```
    public interface EntityManagerFactory {
        public EntityManager getEntityManager();
    }

   public class HibernateEntityManagerFactory implements EntityManagerFactory {
        public EntityManager getEntityManager() {
            return  new HibernateEntityManager();
        }
    }

    public class OpenJPAEntityManagerFactory implements EntityManagerFactory {
        public EntityManager getEntityManager() {
            return  new OpenJPAEntityManager();
        }
    }
   ```

---

Q. Explain Abstract Factory Pattern.

The Abstract Factory Design Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. 

It is a higher-level abstraction than the Factory Method Pattern. Consider implementing the Abstract Factory when you have a class with a set of Factory Methods that blur its primary responsibility. In a well-designed program each class is responsible only for one thing. 

The pattern separates object creation into multiple layers:

- An Abstract Factory defines methods to create abstract products.
- Concrete Factories implement these methods to create concrete products.

**Real-World Example**: JDBC provides abstract factories to create connections and other database objects.

---

Q. Explain Builder Pattern.

The Builder Design Pattern is a creational design pattern that allows you to construct objects step-by-step. The pattern allows you to produce different types and representations of an object using the same construction code.

Example:
```
User.builder().userName("ram").password("***");
```

--- 

Q. Explain Structural Design Patterns.

---

Q. Explain Facade Pattern.

The Facade Design Pattern is a structural design pattern that provides a unified interface to a set of interfaces in a subsystem. 

The facade pattern provides a high-level interface that allows clients to interact with a subsystem in a simplified way. The subsystem itself remains unchanged and fully functional, but the client doesn’t need to know about its inner workings.

---

Q. Explain Proxy Design Pattern.

Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.

---

Q. Explain Template pattern.

The Template is a behavioral design pattern that defines the skeleton of an algorithm in a base class and allows subclasses to override specific steps of the algorithm without changing its structure. 

A template method serves as a template for an algorithm. In the template, each step of the algorithm is represented by a method. Some methods will be handled by the class holding the template method whereas others will be left for the subclasses to handle. The methods that need to be supplied by subclass are declared abstract.

**Example:** `Sort()` method of Java `Arrays` class is based on Template Design Pattern. It gives us the algorithm, but you need to tell it how to compare the elements of the array, which you do by implementing the `compareTo()` method.

> NOTE: The template method is usually declared `final` to prevent subclasses from reworking the sequence of steps in the algorithm.

---



