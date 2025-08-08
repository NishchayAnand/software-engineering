
In object-oriented design, the **`final`** keyword is important because it enforces **design constraints** that improve code stability, security, and maintainability. Its impact depends on where it’s applied:

- **On Classes (`final class`)** – Prevents the class from being extended (inherited). This is useful when you want to create an **immutable, secure, or logically complete** class whose behavior should not be overridden (e.g., `String` in Java). It helps preserve the intended design and avoids accidental misuse through subclassing.

- **On Methods (`final method`)** – Prevents overriding of a method in subclasses. This ensures that **critical business logic, security rules, or performance-sensitive code** is not altered, maintaining consistent behavior across the hierarchy.

- **On Variables (`final variable`)** – Makes the variable **immutable after initialization**. For primitives, the value can’t change; for objects, the reference can’t change (though the object’s internal state can if it’s mutable). This is especially useful in **thread-safe designs** and when modeling constants.