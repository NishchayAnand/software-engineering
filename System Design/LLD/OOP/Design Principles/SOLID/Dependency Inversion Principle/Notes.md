# Dependency Inversion Principle

**DEFINITION: Depend upon abstractions. Do not depend upon concrete classes.**

At first, this priciple sounds a lot like **Program to an interface, not an implementation.** It is similar, however, the `Dependency Inversion Principle` makes an even stronger statement about abstraction. It suggests that our **high-level components should not depend on our low-level components, rather, they should both depend on the abstractions**.

High-level component can be thought of as a class whose behavior is defined in terms of low-level classes. The idea is that high-level classes should interact with low-level classes through `interfaces`, rather than concrete implementations.

This principle enforces the use of **Abstract Factories**.

## Benefits

- **Minimized Coupling**: Promotes **loose coupling** between classes, allowing you to modify the implementation details of the low-level classes without impacting the high-level ones **(as long as the new implementations adhere to the same interface)**. This makes the application more flexible in accommodating changes.

## How To Achieve Dependency Inversion Principle?

DIP can be achieved using the Dependency Injection (DI) technique.

> **NOTE:** Dependency injection (DI) is a design pattern where an object receives its dependencies instead of creating them.

With DI, the high-level classes (consumers) don't create and manage their own dependency objects. They only declare the interface they rely on. A separate entity, often called an injector, takes on the responsibility of creating and providing the actual implementation of the dependencies.

The injector injects the dependency objects into the consumer class at runtime. This means the consumer gets the exact dependency it needs when it needs it.

Here are some ways to implement DI:

- **Constructor injection:** The dependencies are passed as arguments to the constructor of the consumer class.

- **Setter injection:** Dependencies are injected using setter methods in the consumer class. This approach is less common than the constructor injection.

## EXTRA

- **High-level components:** These are classes that are typically more abstract and concern themselves with the core business logic of the application. Examples: order processing service, payment processing service, user authentication service.

- **Low-level components:** These are classes that handle more specific, detailed tasks. They tend to be more concrete and deal with implementation details. Examples: Database access layer, Utility functions (string manipulation, date/time formatting), Algorithm implementations (sorting algorithm, searching algorithm).

- **Coupling:** Measures how closely different classes are dependent on each other. Remember Coupling as **degree of interdependence between classes**.

- `Factory Pattern` promotes Dependency Inversion Principle.
