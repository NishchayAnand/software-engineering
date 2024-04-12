# Understanding Inversion of Control Principle

Though we can pass object using constructor in related codes, but we need to instantiate the dependency objects somewhere in the application code. This leads to some level of coupling. We need to asbsolutely eliminate hard-coded reference to interface implementations to create easily scalable and maintainable code.

If we have object creation logic in our application, we have to make changes to the object (replace it with another implementation), we need to rebuild our application.

- Inversion of Control is a principle, not a design pattern – the implementation details depend on the developer. All IoC does is provide high-level guidelines.

Inversion of Control Principle (IoC) comes into play as a way to achieve this Dependency Inversion Principle. By using IoC techniques like dependency injection, you don't create and manage the dependencies (low-level objects) within your high-level code. Instead, the high-level code specifies the abstractions it needs, and the IoC container (or some other mechanism) injects the concrete implementations at runtime.

“IoC is about enforcing isolation not about injecting dependencies”.
