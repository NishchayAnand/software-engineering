
**Q1. What is `Abstraction`?**

**A.** **`Abstraction`** states that the external behavior **(interface)** of an object should be kept separate from the implementation details of how that behavior is achieved. It gives us the freedom to modify the internal workings of an object without impacting any code using that object.

---

**Q2. What is `Encapsulation`?**

**A.** **`Encapsulation`** is all about bundling data and the methods that operate on that data together into a single unit, typically a class. It's like creating a self-contained package with its own internal workings.

**Key Insight:**

- **Data Protection:** `Encapsulation` helps shield the internal data (properties) of an object from direct external access. This prevents accidental or malicious modification of the data, ensuring its integrity.

---

**Q3. Explain the difference between `Abstraction` and `Encapsulation`.**

**A.**

- **Abstraction** hides implementation details
- **Encapsulation** hides data
- Abstraction answers **what**
- Encapsulation answers **how**

**Key Insight:**

> `Encapsulation` protects **"what's inside"** of an object (data), whereas, `Abstraction` focuses on **"how to use"** that object (functionalities).

---

**Q4. What is Method Overloading?**

**A.** **Method Overloading** allows us to have **multiple methods with the same name in the same class**, but with **different parameter lists**.

```java
class Calculator {
	
	int add(int a, int b) {
		return a + b;
	}
	
	int add(int a, int b, int c) {
		return a + b + c;
	}
	
	double add(double a, double b) {
		return a + b;
	}
	
}
```

The compiler decides which method to call at compile time → hence it is called **compile-time polymorphism**.

**Key Insights:**

- Compiler cannot differentiate based only on return type.

```java
int add(int a, int b) {
	return a + b;
}

double add(int a, int b) { // ❌ Compile-time error
	return a + b;
}
```

---

**Q5. What is Method Overriding?**

**A.** **Method Overriding** occurs when a child class provides its own implementation of a method already defined in the parent class.

This supports **runtime polymorphism**.

```java
class Animal {
	void sound() {
		System.out.println("Animal sound");
	}
}

class Dog extends Animal {
	@Override
	void sound() {
		System.out.println("Bark");
	}
}
```

```java
Animal dog = new Dog();
dog.sound(); // output: Bark
```

**Follow Ups:**

- When overriding a method, the return type must be the same or a subclass (more specific type) of the original return type.

```java
class Parent {
    Number getValue() {
        return 10;
    }
}

class Child extends Parent {
    @Override
    Integer getValue() {
        return 20;
    }
}
```

- A child class **CANNOT** reduce the visibility (access level) of the overridden method.

```java
// From most restrictive → least restrictive
private → default → protected → public
```

- Method overriding makes runtime polymorphism possible by allowing a child class to change the behavior of the method defined in the parent class.

---

**Q6. What is Static Binding?**

Happens for:

- `static` methods
- `final` methods
- `private` methods

```java
Animal a = new Dog(); a.staticMethod();   // resolved at compile time
```
 
Because JVM already knows **which method to call**.

> Binding = linking a method call to its method body

---

**Q7. What is Dynamic Binding?**

Happens for:

- **Overridden instance methods**

```java
Animal a = new Dog();
a.sound();
```

JVM checks:

1. What is the **actual object**? → `Dog`
2. Does `Dog` override `sound()`? → YES
3. Call `Dog.sound()`

➡ Output: `Bark`

> Binding = linking a method call to its method body

---

**Q8. What is Runtime Polymorphism?**

**A.** **Runtime polymorphism** is a mechanism where the **method implementation that gets executed is determined at runtime**, based on the **actual object type**, not the reference type.

In Java, runtime polymorphism is achieved using:

1. **Method Overriding**
2. **Dynamic Binding (Dynamic Method Dispatch)**

**Follow Ups:**

Runtime polymorphism **does not apply** to:

- `static` methods (class-level binding)
- `final` methods (cannot be overridden)
- `private` methods (not inherited)

These methods use **static (compile-time) binding**.

---

**Q9. How Runtime Polymorphism works?**

Consider the following example:

```java
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Bark");
    }
}
```

```java
Animal a = new Dog();
a.sound();
```

**Compile Time:**

- The compiler checks whether the **reference type (`Animal`)** has a method called `sound()`.
- Since it exists, compilation succeeds.
- **No decision is made yet** about which method implementation to execute.

**Runtime (JVM Execution)**

- JVM looks at the **actual object** stored in `a`, which is `Dog`.
- It checks whether `Dog` overrides `sound()`.
- Since it does, **`Dog.sound()` is executed**.

```Java
Bark // Output
```

This decision is made **at runtime**, which is why it is called **runtime polymorphism**.

---

**Q10. What is Diamond Problem?**

---

**Q11. How to create a Immutable class in Java?**

- Final class
- Final fields
- No setters
- Defensive copies

---

**Q12. Why String is immutable?**

---

**Q13. Why “Change Behavior Without Overriding” Is Needed?**

Method overriding:

- Requires **inheritance**
- Creates **tight coupling**
- Makes behavior **fixed at compile time**
- Violates **Open/Closed Principle** when overused

In real systems, we often want:

- Behavior to change **at runtime**
- No deep inheritance hierarchies
- Easy extensibility without modifying existing classes

That’s where **Composition, Strategy, and Delegation** come in.

---

**Q14. Explain `SOLID` principles.**

---

Q15. What is Singleton Pattern?

---

Q16. What is Builder Pattern?

---
## Advanced

### Patterns in Spring

- Singleton
    
- Factory
    
- Proxy
    
- Template Method
    

---

### MVC patterns

- Observer
    
- Strategy
    
- Composite
    

---

### Pattern usage examples

- Caching → Proxy
    
- Retry → Template / Decorator
    
- Notifications → Observer



