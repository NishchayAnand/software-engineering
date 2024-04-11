# Understanding Inversion of Control Principle

We need to instantiate these objects in the void main method (main class which act as the starting point) and feed them to the classes which again leads to tight coupling. We need to eliminate hard-coded reference to interface implementations.

If we have object creation logic in our application, we have to make changes to the object (replace it with another implementation), we need to rebuild our application.

- Inversion of Control is a principle, not a design pattern – the implementation details depend on the developer. All IoC does is provide high-level guidelines.

Inversion of Control Principle (IoC) comes into play as a way to achieve this Dependency Inversion Principle. By using IoC techniques like dependency injection, you don't create and manage the dependencies (low-level objects) within your high-level code. Instead, the high-level code specifies the abstractions it needs, and the IoC container (or some other mechanism) injects the concrete implementations at runtime.
