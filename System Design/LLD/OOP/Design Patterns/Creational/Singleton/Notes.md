# Understanding Singleton Pattern

---

- The intention of this pattern is to ensure a class only has one instance, providing a global point of access to it.

- In Java, the key to singleton pattern is restricting the access of who can call the constructor of a class.

- Constructors can have access modifiers. You can make the constructor private, so that no one will be able to call it except for the class that defines it. Then, the only way to get the instance of the class is have a static method to create it and return it.

```
Sample Code 1:
public class Calculator {
    private static Calculator instance;

    private Constructor() {}

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }
}
Issue: Can result in multiple instances in multi-threaded environment. The multi-threading problem can be solved by making the getInstance() method synchronized, but this will have an impact in performance since we only need synchronize the access to the method once (the first time the instance is created).

Sample Code 2:
public class Calculator {
    private static Calculator instance = new Calculator(); // --> instance gets created when the class is compile.

    private Calculator() {}

    public static Calculator getInstance() {
        return instance;
    }
}
Issue: The instance will always be created, we want it or not. What if the instance is expensive to create and no one uses it?

```

- A singleton provides a means to ensure that only one object instance of a class is created and referenced by clients accessing that class. Most often, singletons are defined for a particular process. However, means for defining singletons within a certain distributed processing domain can also be defined.

- Serialization, i.e., the process of storing the state of the class in the file system can also create multiple instances of the class.

- In Java, the most acceptable singleton implementation is through the use of `Enumerations` (as long as you need to extend from another class).
