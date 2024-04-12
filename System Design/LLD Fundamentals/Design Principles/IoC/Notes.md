# Understanding Inversion of Control Principle

Though we can pass dependency objects using constructor or setter methods, we still need to instantiate the dependency objects somewhere in the application code. This still leads to some level of coupling in our code.

Creating a single source, often known as the container, for handling all the creating and managing logic of the objects would help us decouple our code from hard-coded references of interface implementations, thereby reducing coupling in our application.

The flip of control flow is known as Inversion of Control (IoC).

Inversion of control (IoC) is a software design principle that flips the traditional way control flows between different parts of a program. Here's a breakdown:

Traditional approach: In procedural programming, your code explicitly calls libraries or frameworks to perform specific tasks. You're in control of when and how these functions are used.

IoC approach: With IoC, the framework or a central container takes charge. It dictates when and how your code gets called. You provide the functionality, and the framework decides when to execute it.

- Inversion of Control is a principle, not a design pattern – the implementation details depend on the developer. All IoC does is provide high-level guidelines.

Inversion of Control Principle (IoC) comes into play as a way to achieve this Dependency Inversion Principle. By using IoC techniques like dependency injection, you don't create and manage the dependencies (low-level objects) within your high-level code. Instead, the high-level code specifies the abstractions it needs, and the IoC container (or some other mechanism) injects the concrete implementations at runtime.

NOTE: “IoC is about enforcing isolation not about injecting dependencies”.
