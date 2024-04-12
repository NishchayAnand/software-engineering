# Understanding Inversion of Control (IoC) Principle

Even with dependency injection (DI) through constructors or setters, some part of your application code (e.g. main program) would still be responsible for creating the dependency objects. This creates a level of coupling, as your application code knows how and when to instantiate these dependencies.

Inversion of Control (IoC) is a design principle that involves shifting the responsibility of object creation and management from your application itself to a separate component, commonly referred to as an IoC container.

## Understanding IoC Container

The IoC container acts as a centralized source for creating and managing objects, often based on `configuration` or `annotations` provided by the developer. This eliminates the need for your code to handle object instantiation and wiring dependencies manually.

It injects the fully formed dependency objects into your code at runtime.

Benefits of using an IoC container:

- **Reduced Coupling:** Your code becomes truly decoupled from specific implementations and how dependencies are created. It only cares about the functionality defined in the interfaces.

- **Flexibility:** You can easily swap out different implementations without modifying your code.

- **Maintainability:** Code becomes cleaner and easier to understand as the logic is separated from dependency management and object creation.

> **_NOTE:_** IoC Container abstracts away the details of object creation, allowing the application to focus on its core logic without worrying about the specifics of dependency instantiation.
