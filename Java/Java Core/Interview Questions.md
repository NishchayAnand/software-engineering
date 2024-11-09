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