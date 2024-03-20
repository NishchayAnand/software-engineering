## Understanding Method Overriding

`Method overriding` is a mechanism that allows a subclass (child class) to provide a specific implementation of a method inherited from its superclass (parent class).

> Method overriding allows **same method name** to **behave differently** for objects of different classes, thereby, promoting the **"One Name, Different Behaviors"** philosophy of polymorphism.

Here’s an example to illustrate method overriding in Java:

```
class Animal {
  public void makeSound() {
    System.out.println("Generic animal sound");
  }
}

class Dog extends Animal {
  @Override // Optional annotation to check for valid overriding
  public void makeSound() {
    System.out.println("Woof!");
  }
}

class Cat extends Animal {
  @Override
  public void makeSound() {
    System.out.println("Meow!");
  }
}
```

Some crucial aspects to consider about method overriding in Java:

- **Upcasting**
- **Dynamic or Runtime Polymorphism:**

## Upcasting

Upcasting is the process of assigning a reference variable of a superclass type to an object of a subclass.

Here’s an example to illustrate upcasting in Java:

```
public class Main {
  public static void main(String[] args) {
    Animal animal1 = new Dog();
    Animal animal2 = new Cat();
  }
}
```

Upcasting enforces a level of safety by **restricting access to members specific to subclasses** through the superclass reference. You can only access the methods and attributes defined in the superclass. This helps prevent accidental misuse of subclass-specific features and potential errors.

## Dynamic or Runtime Polymorphism

When you call a method on an object in Java, the decision of which specific method implementation to execute is made at runtime based on the object's actual type. This is in contrast to compile-time polymorphism (method overloading), where the method selection happens during compilation.

Here’s an example to illustrate runtime polymorphism in Java:

```
public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        animal1.makeSound(); // Output: Woof! (Runtime polymorphism)
        animal2.makeSound(); // Output: Meow! (Runtime polymorphism)
    }
}
```

> **Upcasting** and **runtime polymorphism** work together to create the foundation for **loose coupling** in object-oriented programming. The code that interacts with objects through superclass references doesn't need to be aware of the specific subclass type. It can call methods defined in the superclass, and the appropriate subclass implementation will be executed at runtime.
