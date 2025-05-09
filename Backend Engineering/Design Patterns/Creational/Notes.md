# Understanding Creational Design Patterns

- Describes how to abstract the process of creating an object, hiding how object are created and put together when exposing only their interface.

- Out of 5 patterns, only one, the factory method uses inheritance to create objects.Rest 4 use object composition to delegate the creation of instances to another object.

There are 5 patterns, related to object instantiation, providing a way to decouple the code that creates the object from the object itself.

In software design, creational design patterns are all about how you create objects. They provide a more flexible and reusable way to instantiate objects compared to just using the new keyword.

Here's why they're useful:

- **Flexibility:** The way you create an object might depend on the situation in your program. Creational patterns isolate this logic so you can choose how to create objects at runtime.

- **Reusability:** These patterns often encapsulate common object creation workflows, allowing you to reuse that code throughout your project.

**Here are some common creational design patterns:**

- **Factory Method:** This pattern lets you define an interface for creating objects, but lets subclasses decide which concrete class to instantiate. This is useful when you want to easily swap between different types of objects.

- What is the relationship between `dependency inversion principle`, `Liskov Substitution Principle`, `factory method pattern` and `polymorphism`?

- **Abstract Factory:** This pattern creates families of related objects without specifying their concrete classes. It's like a factory that can produce different sets of products.

- **Singleton:** This pattern ensures that only a single instance of a class exists. This is useful for things like loggers or configuration managers.

- **Prototype:** This pattern lets you clone existing objects to create new ones. This can be faster than creating objects from scratch, especially for complex objects.

- **Builder:** This pattern helps you build complex objects step by step. This is useful when you have many optional parameters or the order of construction matters.
