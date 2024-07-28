# Understanding Multiple Inheritance

Multiple inheritance offers the ability to combine functionalities from multiple base classes. However, it can introduce complexities that make your code harder to understand and maintain.

The most well-known challenge associated with multiple inheritance is `The Diamond Problem`.

> **Diamond Problem**: If parent classes have the same method (with the same name and arguments), which method implementation should the subclass inherit?
