
Here’s a clean, interview-oriented list of important Java topics, ordered roughly from must-know to good-to-have.

---

<span style="color:indigo;font-weight:bold;">Q. What is an abstract class?</span>

An abstract class is a class that:

1. Is declared using the `abstract` keyword
2. Cannot be instantiated
3. Can have both abstract and concrete methods
4. Can maintain state (fields)

```java
abstract class Vehicle {
	
	int speed; // state
	
	abstract void start(); // abstract method
	
	void accelerate() { // concrete method
		speed+=10; 
	}

}
```

```java
class Car extends Vehicle {
	@Override
	void start() {
		System.out.println("Car starts with key");
	}
}
```

```java
Vehicle v = new Car(); // polymorphism
v.start();
v.accelerate();
```

Key Rules:

- <span style="color:green;">Interfaces <strong>cannot hold mutable state</strong>. Abstract classes can.</span>
- Abstract class allows you to protect internal logic by providing access to `protected` methods, `private` helper methods and controlled extension. In interfaces, all methods are `public` by default.

---

<span style="color:indigo;font-weight:bold;">Q. What are default methods in an interface?</span>

A default method is a method inside an interface that has:

1. The `default` keyword
2. A method body (implementation)

```java
interface Vehicle {
	default void start() {
		System.out.println("Vehicle is starting");
	}
}
```

**Before Java 8:**

- Interfaces could only have **abstract methods**
- Adding a new method to an interface would **break all implementing classes**.

Default methods solved this.

---

<span style="color:indigo;font-weight:bold;">Q. What are static methods in an interface?</span>

A static method in an interface is:

1. Declared using the `static` keyword
2. Has a method body
3. Belongs to the interface itself, not to any implementing class

**Introduced in Java 8 (along with default methods)**

```java
interface Validator {
	boolean isValid(String s);
	
	static boolean isEmpty(String s) {
		return s == null || s.isEmpty();
	}
}
```

The primary reason for static methods in interface is to <span style="color:green;">allow related utility methods to be defined alongside the interface without being inherited, overridden</span>, or affecting implementing classes.

---

<span style="color:indigo; font-weight:bold;">Q. What is Generics?</span>



---

<span style="color:indigo; font-weight:bold;">Q. What is Functional Interface?</span>

An interface with exactly one abstract method.

```java
@FunctionalInterface
interface Calculator {
	int add(int a, int b);
}
```

Usage with a lambda:

```java
Calculator cal = (a, b) -> a + b;
System.out.println(cal(2, 3));
```

> **NOTE**: A functional interface can have multiple `default` and `static` methods. 

---

<span style="color:indigo; font-weight:bold;">Q. Can a functional interface extend another interface?</span>

Yes, only if the parent interface **does not introduce an additional abstract method**.

**Example**

```java
interface Logger {
	default void log(String msg) { // default method
		System.out.println(msg);
	}
}
```

```java
@FunctionInterface
interface Task extends Logger {
	void execute(); // only one abstract method
}
```

**Mental Model**: Count abstract methods across the entire inheritance chain. If the total is exactly one, it's a functional interface.

---

<span style="color:indigo; font-weight:bold;">Q. Explain different types of functional interfaces.</span>

1. `Predicate<T>`: Contains an abstract function: `boolean test(T t)` that tests a condition and returns `true` or `false`.

```java
Predicate<Integer> isEven = n -> n % 2 == 0;
isEven.test(10);
```

2. `Function<T, R>`: Contains an abstract function: `R apply(T t)` that takes input of type `T` and returns output of type `R`.

```java
Function<String, Integer> length = s -> s.length();
length.apply("Java"); // 4
```

3. `Consumer<T>`: Contains an abstract function: `void accept(T t)` that consumes input but returns nothing.

```java
Consumer<String> print = s -> System.out.println(s);
print.accept("Hello");
```

4. `Supplier<T>`: Contains an abstract function: `T get()` that supplies a value without any input.

```java
Supplier<Double> random = () -> Math.random();
random.get();
```

5. `Runnable`: Contains an abstract function: `void run()` that neither takes an input nor returns an output.

```java
Runnable task = () -> System.out.println("Running");
new Thread(task).start();
```

6. `Callable<V>`: Contains an abstract function: `V call() throws Exception` that takes no input but returns an output. 

```java
Callable<Integer> task = () -> 42;
```

**Quick Comparison Table**

| Interface      | Input | Output  | Use Case         |
| -------------- | ----- | ------- | ---------------- |
| Predicate      | 1     | boolean | Filter           |
| Function       | 1     | 1       | Transform        |
| Consumer       | 1     | none    | Side effects     |
| Supplier       | 0     | 1       | Lazy creation    |
| UnaryOperator  | 1     | same    | Update           |
| BinaryOperator | 2     | same    | Reduce           |
| BiFunction     | 2     | 1       | Combine          |
| Runnable       | 0     | none    | Task             |
| Callable       | 0     | 1       | Task with result |

---

<span style="color:indigo;font-weight:bold;">Q. Given an array</span> `nums` <span style="color:indigo;font-weight:bold;">containing</span> `n` <span style="color:indigo;font-weight:bold;">distinct numbers in the range</span> `[0, n]`<span style="color:indigo;font-weight:bold;">, return the only number in the range that is missing from the array.</span>

```
Example 1:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
```

A. Sum of the first `n` nums subtracted by the sum of numbers in `nums` should give us the missing number.

```java
public int missingNumber(int[] nums) {
	int n = nums.length;
	// Sum of the first N numbers
	int firstNSum = (n*(n+1))/2;
	// Sum of numbers in nums array
	int totalSum = 0;
	for(int num: nums) totalSum += num;
	// return the difference 
	return firstNSum - totalSum;   
}
```

---

<span style="color:indigo;font-weight:bold;">Q. Given an integer array</span> `nums`<span style="color:indigo;font-weight:bold;">, return</span> `true` <span style="color:indigo;font-weight:bold;">if any value appears at least twice in the array, and return</span> `false` <span style="color:indigo;font-weight:bold;">if every element is distinct.</span>

```
Example 1:

Input: nums = [1,2,3,1]
Output: true
Explanation: The element 1 occurs at the indices 0 and 3.
```

A.The most efficient way is to use a HashSet to track elements seen so far.

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

If you don’t want extra space:

- Sort the array → check adjacent elements
- Time: `O(n log n)`, Space: `O(1)` (if in-place)

---


### EXTRA

long vs Long, long vs float vs double

type casting

Q. Explain Exceptions in Java.

Exceptions are events that occur during program execution and disrupt the normal flow of the application. They are objects that represent an error or unexpected behavior, and Java provides a robust mechanism to handle them.

> NOTE: The `Throwable` class is the root of all exceptions and errors in Java.

---

Q. Explain different types of Exceptions in Java.

- **Checked Exceptions**: Checked at compile-time. The programmer is required to handle them using `try-catch` or declare them in the `throws` clause.

- **Unchecked Exceptions (Runtime Exceptions)**: Occur during runtime and are not checked at compile-time.
Caused by programming bugs, such as logic errors or improper use of APIs.

---

Q. Explain Exception Handling in Java. 

Effective exception handling ensures that your application can gracefully **recover from errors and continue to operate as expected without crashing**. 

Below are the steps to handle exceptions in Java:

1. **Catch Exceptions**: The try-catch block is the primary way of handling exceptions in Java. Always catch the most specific exception first and then catch more general exceptions.

2. **Log the Exception Details**: It’s important to log the details of the exception (e.g., the error message and stack trace) for debugging and future reference.

3. **Return the Fallback Values**: In the catch block, return the fallback values when the exception occurs.

4. **Re-throwing Exceptions**: Sometimes, after handling an exception, you might need to re-throw it for higher-level components to handle it, often with additional context or custom messages.

> NOTE: In complex applications, especially web applications (e.g., Spring Boot), you can use exception-handling frameworks to handle exceptions globally and return consistent error responses (e.g., HTTP status codes and error messages).

---

Q. Explain the difference between StringBuilder and StringBuffer.

The key differences between `StringBuilder` and `StringBuffer` in Java revolve around thread safety.

- **StringBuffer**: It is thread-safe. Methods in StringBuffer are synchronized, which means multiple threads cannot access it simultaneously. This ensures data consistency but introduces overhead due to locking and unlocking mechanisms.

- **StringBuilder**: It is not thread-safe. Methods in StringBuilder are not synchronized, so it does not guarantee thread safety when accessed by multiple threads simultaneously.

> NOTE: Use `StringBuffer`when you need to work with a mutable string in a multi-threaded environment, and synchronization is required. Use `StringBuilder` when you need to work with a mutable string in a single-threaded environment, where performance is a priority and thread safety is not a concern.

---

Q. Write a solution to sort strings based on their length. If the length of two strings are equal, compare the two strings aphabetically.

We can create a custom comparator (by implementing `Comparator` interface) to define custom sorting logic for strings objects.

```
import java.util.Comparator;

public class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int lengthDifference = Integer.compare(s1.length(), s2.length());
        if (lengthDifference == 0) {
            return s1.compareTo(s2);
        }
        return lengthDifference;
    }
}
```

### HashMap is not thread-safe. Comment.

---

### Strings are immutable. Comment.

It means that once a String object is created, its value cannot be changed. When you perform operations on strings, such as concatenation, substring, or replace, the original string remains unchanged, and a new string is returned with the desired modifications.

> NOTE: Strings in Java are stored as an array of characters internally (char[]), which is declared as final.

Since strings are immutable, they are inherently thread-safe. Multiple threads can share the same string object without worrying about synchronization issues.

---

### What is a String Pool?

A special memory area within the heap where string literals are stored. It is used to optimize memory usage and improve performance when dealing with string literals by avoiding the creation of multiple identical `String` objects.

---

### Q. Why is Java a platform independent language?

Java is a compile-type language. The compiled code, i.e, bytecode can run on various operating systems and hardware infrastructures without requiring modifications.

---

### Q. What is Stack Memory?

Stack memory is a specific area of memory in a computer's RAM (Random Access Memory) that stores temporary variables created by each function.

---

### Q. What is classpath?

The `classpath` is an **environment variable** that tells the Java compiler and JVM where to look for compiled class files (.class) when running your program.

---

### Q. What were the differences between `Abstract Classes` and `Interfaces` before Java 8?

Before Java 8, the differences between abstract classes and interfaces in Java were more pronounced. Here are the key distinctions:

**Abstract Classes:**

1. **Abstract classes can have both abstract methods (methods without an implementation) and concrete methods (methods with an implementation).** Concrete methods in abstract classes can provide a default behavior that subclasses can use or override.

2. **Abstract classes can have instance variables (fields) with various access modifiers** (private, protected, public).

3. A **class can inherit from only one abstract class** due to Java’s single inheritance constraint.

4. **Methods** in abstract classes **can have any access modifier**: private, protected, public, or package-private (default).

5. Though Abstract classes cannote be instantiated, they can have constructors, which can be used to initialize fields in the abstract class. Subclasses can call the constructor of the abstract class using super().

**Interfaces:**

1. Interfaces could only have abstract methods (methods without an implementation).

2. Interfaces cannot have any instance variables (fields). We can **only define constants** which were implicitly `public`, `static`, and `final`.

3. A class can implement multiple interfaces, **providing** a form of **multiple inheritance**.

4. All methods in interfaces were implicitly `public` and `abstract`.

5. Interfaces cannot have constructors because they cannot have any instance fields.

---

### Q3. What are the differences between `Abstract Classes` and `Interfaces` after Java 8?

After Java 8, the distinctions between abstract classes and interfaces have narrowed due to the introduction of `default` and `static` methods in interfaces. Here are the key distinctions:

1. **Abstract Classes can have instance variables that maintain instance-specific `state`, whereas Interfaces cannot.**

2. A class can only implement one Abstract Class whereas it can implement multiple Interfaces. **If a class implements multiple interfaces that have `default` methods with the same signature, the class must override the method to resolve the conflict.**

---

### Q. State the differences between equals() method and equals operator.

An object may contain multiple types of data. Using the equals (`==`) operator does not work for comparison of objects. Hence, we need to use equals() method. The equals() method compares the value.

---

# Core Java Interview Questions

Q. What is Garbage Collection?

Garbage collection is the process by which the **Java Virtual Machine (JVM)** automatically manages memory by identifying and disposing of objects that are no longer in use, freeing up memory resources. 

This is essential for preventing memory leaks, ensuring efficient memory use, and avoiding **OutOfMemoryErrors**.

> NOTE: Java objects are created in a memory area called the heap. When objects are no longer referenced, they become eligible for garbage collection, and the memory can be reclaimed. 

---

Q. Explain the issues associated with modifying `String` in Java?

**When you try to modify a `String`, a new `String` object is created rather than changing the original**. This leads to extra memory usage, especially in cases where strings are modified frequently, like concatenation in loops.

> NOTE: In Java, strings are immutable, meaning once a String object is created, it cannot be changed. Immutability makes strings inherently thread-safe, as they can be shared between threads without causing concurrency issues.

---

Q. What is Dynamic Binding?

Dynamic binding in Java is a concept that **allows Java to determine the method to invoke at runtime rather than compile-time**. It’s a part of Java’s polymorphism and is also known as late binding or runtime polymorphism.

---

Q. Explain `StringBuilder` and `StringBuffer`.

`StringBuilder` and `StringBuffer` are classes in Java used to create and manipulate strings dynamically. 

**Similarity**: Both classes are mutable, meaning you can modify the string content without creating new objects, unlike `String`, which is immutable.

**Difference**: `StringBuffer` is **thread-safe** whereas `StringBuilder` is not. 

> NOTE: `StringBuffer` was introduced in Java 1.0, and `StringBuilder` was added later (Java 5) to provide a faster alternative for single-threaded applications.

---

Q. What are the different ways of creating Threads?

1. **Extending the `Thread` Class**: Create a new class that extends the `Thread` class and override its `run()` method with the code that should execute in the new thread. Instantiate the subclass and call `start()` to begin execution.

```
class MyThread extends Thread {
    @Override
    public void run() {
        // Code to execute in the new thread
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // Starts the new thread
    }
}
```

> NOTE: Java doesn't support multiple inheritance, so extending `Thread` limits the class from extending other classes.

2. **Implementing the `Runnable` Interface**: Create a new class that implements the `Runnable` interface and implement its `run()` method with the code that should execute in the new thread. Create an instance of `Thread`, passing the `Runnable` instance to its constructor and call `start()` on the Thread instance to begin execution.

```
class MyRunnable implements Runnable {
    @Override
    public void run() {
        // Code to execute in the new thread
        System.out.println("Runnable thread running: " + Thread.currentThread().getName());
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start(); // Starts the new thread
    }
}
```

> NOTE: Using `Runnable` interface encourages separation of thread code from thread management.

3. **Implementing the Callable Interface and Using Future**: Create a class that implements `Callable<V>` (V is the result type) and implement its `call()` method with the code to execute and return a result. Use an `ExecutorService` to submit the `Callable` task and retrieve the result using a `Future` object.

```
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        // Code to execute in the new thread
        return "Callable thread result: " + Thread.currentThread().getName();
    }
}

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<String> callable = new MyCallable();
        Future<String> future = executor.submit(callable);

        try {
            String result = future.get(); // Blocks until result is available
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
```

> NOTE: Using `Callable` interface gives us the ability to return results from threads.

---

Q. What are the different states of a Thread?

1. **NEW**: A thread enters `NEW` state when a new Thread object is instantiated but the start() method has not been called.

2. **RUNNABLE**: A thread enters the `RUNNABLE` state when start() is called, making it eligible for CPU time.

> NOTE: Even if a thread is in the `RUNNABLE` state, it may still not be running due to CPU scheduling, as it might be waiting for CPU time.

3. **BLOCKED**: A thread enters `BLOCKED` state when it tries to enter a synchronized block but another thread currently holds the lock. It remains in this state until the lock becomes available.

4. **WAITING**: A thread is in the `WAITING` state when it’s waiting indefinitely for another thread to perform a particular action. For example, when `Thread.join()` is called on another thread, causing the current thread to wait for the other thread to complete.

5. **TIMED_WAITING**: A thread is in the `TIMED_WAITING` state when it’s waiting for a specific amount of time before automatically resuming. For example, calling `Thread.sleep(1000)` will put the thread in `TIMED_WAITING` state for 1000 milliseconds, i.e., 1 second.

6. **TERMINATED**: A thread enters `TERMINATED` state when it finishes executing the `run()` method or encounters an unhandled exception.

---

Q. What is bucketing in HashMaps?

When a key-value pair is added to the HashMap, the HashMap first computes the hash code of the key. The hash code is then processed by a hashing function to determine an index in the internal array. This index indicates the specific bucket where the key-value pair will be stored.

---

Q. What is a ConcurrentHashMap in Java?

`ConcurrentHashMap` is a thread-safe version of HashMap **designed for concurrent access in highly concurrent environments**. It allows concurrent reads and updates from multiple threads without the need for explicit synchronization. 

**It performs internal locking at the bucket level, allowing individual buckets (buckets in linked-list or tree nodes) to be updated without locking the entire map.**

> NOTE: `ConcurrentHashMap` provides a form of weak consistency, i.e., updates made by one thread may not be immediately visible to other threads. However, it does ensure that all entries are eventually consistent, meaning all updates will eventually propagate to all threads.

---

Q. Explain `Comparable` and `Comparator` interface. 

**Similarity**

Both are used to define the natural ordering of objects, allowing them to be sorted in a specific order. 

**Difference**

**Comparable**: Provides the "natural order" of objects. A class implementing `Comparable` is responsible for defining how to compare its own instances by implementing its `compareTo()` method. Comparable can be sorted directly by Java’s sorting algorithms (like `Collections.sort()` or `Arrays.sort()`).

```
public class MyClass implements Comparable<MyClass> {
    private int value;

    @Override
    public int compareTo(MyClass other) {
        return Integer.compare(this.value, other.value);  // Ascending order
    }
}
```

> NOTE: Each class can have only one natural ordering if it implements `Comparable`.

**Comparator**: Used to define custom ordering for objects, providing flexibility to **define multiple ways of ordering a particular class**. It is often used when you want to sort objects in more than one way (e.g., by age, by name, etc.).

```
import java.util.*;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " (" + age + ")";
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35)
        );

        Comparator<MyClass> comparator = new Comparator<MyClass>() {
            @Override
            public int compare(MyClass o1, MyClass o2) {
                return Integer.compare(o1.value, o2.value);  // Ascending order
            }
        };
        
        // Sort by age using Comparator
        people.sort(comparator);
        System.out.println("Sorted by age: " + people);
        
    }
}
```

---

Q. Difference between `float` and `double`.

Both `float` and `double` are used to represent floating-point numbers (numbers with decimal points), but they differ in precision and size:

- `float`: It is a 32-bit floating-point data type (occupies 4 bytes in memory). It has a precision of about 6-7 decimal digits.

- `double`: It is a 64-bit floating-point data type (occupies 8 bytes in memory). It has a precision of about 15-16 decimal digits, making it more accurate than float.

> NOTE: Java treats decimal literals as double by default, so if you want to use a literal as a float, you need to append f or F (e.g., 3.14f). 

--- 

Q. What is Stream API?

The Stream API, introduced in Java 8, is a powerful tool for **processing collections of data in a declarative and functional style**. It allows for efficient and clean manipulation of data without modifying the original data source. 

---

Q. Why was `Stream` API introduced if we already had `Collection` API?

Because developer wanted to add new and efficient way of processing data and didn't want to alter the existing Collection API.

---

Q. Explain nested classes in Java.

Nested inner classes are classes defined within another class. They can be categorized into static and non-static types:

- **Static Nested Class**: A static nested class is declared with the static keyword. It does not require an instance of the outer class and can access only the static members of the outer class.

- **Non-Static Inner Class**: A non-static inner class (also called an instance inner class) does not use the static keyword. It is associated with an instance of the enclosing class and can access all members (static and instance) of the outer class.

---

Q. Explain local variable type inference.

Local variable type inference is a feature introduced in **Java 10**, which allows the type of a local variable to be inferred by the compiler at compile-time. 

This means that instead of explicitly declaring the type of a variable, you can now use the keyword **var**, and the compiler can determine the variable's type based on the value assigned to it.

```
var list = new ArrayList<Map<String, Integer>>();
```

**Benefit**: Reduces verbosity in cases where the type is obvious or redundant.

> NOTE: Java remains statically typed. Even though the type is inferred, it is fixed at compile-time and cannot change.

---

