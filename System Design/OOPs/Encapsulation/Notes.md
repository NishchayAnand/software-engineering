# Understanding Encapsulation

Encapsulation is all about bundling data and the methods that operate on that data together into a single unit, typically a class. It's like creating a self-contained package with its own internal workings.

> The ideology behind designing your class in an object-oriented programming world is quite similar to that of designing your database tables.

There are two key aspects to encapsulation:

- **Data Protection:** Encapsulation helps shield the internal data (properties) of an object from direct external access. This prevents accidental or malicious modification of the data, ensuring its integrity.

- **Information Hiding:** It promotes the concept of information hiding. The internal complexities, i.e., implementation details of the class are hidden from external code. Instead, the class provides a **public interface (methods)** that defines how to interact with the object and its data.

## How to achieve Encapsulation?

Encapsulation is typically achieved through:

- **Access Modifiers:** In most OOP languages, you can use access modifiers (like `private`, `protected`, `public`) to control the visibility of an object's data members and methods. Private members are hidden from external code, while public methods provide controlled access to the data.

  - **private:** Members declared as private are only accessible within the class they are defined in. They are invisible to other classes, even those in the same package.

  - **protected:** Members declared as protected can be accessed from within the same package and by subclasses (child classes) in other packages.

  - **public:** Members declared as public can be accessed from anywhere in the program.

- **Getter and Setter Methods**: Often, even though the data is private, you might want controlled ways to access or update it. Encapsulation allows you to create **public methods (getters and setters)** that can retrieve or modify the data while potentially adding validation or other logic.

## Benefits of Encapsulation

- **Improved Data Security:** Protects data from unintended changes.
- **Modular Design:** Promotes code reusability and maintainability.
- **Reduced Coupling:** Limits dependencies between different parts of your program.
- **Flexibility:** You can change the internal implementation of a class without affecting external code that interacts with its public interface.
