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
