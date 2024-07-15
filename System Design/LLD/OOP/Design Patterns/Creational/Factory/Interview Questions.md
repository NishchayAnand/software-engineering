## Factory Pattern Interview Questions

**Q. Difference between Simple Factory Pattern and Factory Method Pattern.**

In Simple Factory Pattern, the factory object is responsible for object creation.

In Factory Method Pattern, the factory method lets a class defer instantiation to subclasses. With factory method, the creator is not tightly coupled to any concrete product.

In simple words, the Simple Factory Pattern centralizes object creation in a single factory class, while the Factory Method Pattern decentralizes it by delegating object creation to subclasses, providing more flexibility and adherence to object-oriented design principles.

---

**Q. Difference between Factory Method Pattern and Abstract Factory Pattern.**

Both abstract factory and factory method create objects. But abstract factory does that through object composition and factory method does that through inheritance.

To create objects using Factory Method, you need extend a class and provide an implementation for a factory method.
