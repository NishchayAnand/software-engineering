
**Q. What do we mean by a thread-unsafe class?**

In Java, a thread-unsafe class refers to a class that contains data or methods that _can't be accessed safely by multiple threads concurrently_. This means if multiple threads access the same instance of a thread-unsafe class simultaneously, there's a _risk of data corruption or inconsistencies_.

**Q.Can you reuse a Thread object? Can you give it a new job to do and restart it by calling start() again?**

No. Once a thread's `run()` method has completed, the thread can never be restarted. In fact, at that point the thread moves into a **dead state**.

The `Thread` object might still be on the heap, as a living object that you call other methods on, but the `Thread` object has permanently lost its **'threadness'**. In other words, there is no longer a separate call stack, and the `Thread` object is no loner a thread. It's just an object, at that point, like all other objects.

> **NOTE:** There are design patterns for making a pool of threads that you can keep using to perform different jobs. However, you don't do it by restarting a dead thread.

---

**Q. What are thread priorities?**

Thread priorities are numerical values that tell the scheduler how important a thread is to you. The scheduler can kick a lower priority thread out of the runnable state if a higher priority threas suddenly becomes runnable.

It's important to note that thread priorities might help you influence the scheduler, but they still **don't offer any guarantee**. We recommend that you use priorities only if you want to influence performance, but never, ever reliy on them for program correctness.

---

**Q. What is the difference between running multiple threads on a single-core processor and a multi-core processor?**

When a program with multiple threads is running on a multi-core processor, multiple threads can truly execute concurrently on different cores, leading to significant performance gains.

When running on a single core, the operating system can rapidly switch between threads, giving the illusion of concurrency. This context switching comes with some overhead, but it allows the program to make progress on multiple tasks seemingly at the same time.

---

**Q. Difference between Class and Object locks?**

Locks, also known as synchronizers, are mechanisms used to control access to shared resources between threads. They prevent multiple threads from modifying the same data simultaneously, which can lead to data corruption or inconsistencies.

**Class Lock:** A class level lock is achieved by **using the `synchronized` keyword with `static` methods in a class.** This lock restricts any thread from entering any static synchronized method of that class.

- **Object Lock:** An object level lock is achieved by **using the `synchronized` keyword with `instance` methods or `code blocks`** within a class. This lock restricts other threads from entering synchronized methods or blocks on the same object instance.

---

**Q. What will be the output of the following code snippet?**

```
class Demo {

    public static synchronized void syncStatic() {
        System.out.print(Thread.currentThread().getName() + " ");
    }

    public synchronized void syncInstance() {
        System.out.print(Thread.currentThread().getName() + " ");
    }

}

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Demo d1 = new Demo();
        Demo d2 = new Demo();
        Thread t1 = new Thread(() -> d1.syncStatic(), "A");
        Thread t2 = new Thread(() -> d2.syncInstance(), "B");
        t1.start(); t2.start();
        t1.join(); t2.join();
    }

}
```

---

**Q. What will be the output of the following code snippet?**

```
class Task implements Runnable {

    public synchronized void run() {
        System.out.print(Thread.currentThread().getName() + " ");
        try { Thread.sleep(50); } catch (InterruptedException e) {}
    }

}

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Task t = new Task();
        Thread t1 = new Thread(t, "1");
        Thread t2 = new Thread(t, "2");
        t1.start(); t2.start();
        t1.join(); t2.join();
    }

}
```

---

**Q. What will be the output of the following code snippet?**

```
class Printer {

    public void print() {
        synchronized(this) {
            System.out.print(Thread.currentThread().getName() + " ");
        }
    }

}

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Printer p1 = new Printer();
        Printer p2 = new Printer();
        Thread t1 = new Thread(() -> p1.print(), "X");
        Thread t2 = new Thread(() -> p2.print(), "Y");
        t1.start(); t2.start();
        t1.join(); t2.join();
    }

}
```

---

**Q. What will be the output of the following code snippet?**

```
class MyClass {

    public synchronized static void staticMethod() {
        System.out.print(Thread.currentThread().getName() + " ");
    }

}

public class Test {

    public static void main(String[] args) {
        Runnable r = MyClass::staticMethod;
        Thread t1 = new Thread(r, "A");
        Thread t2 = new Thread(r, "B");
        t1.start(); t2.start();
    }

}
```

---

**Q. What will be the output of the following code snippet?**

```
class Counter {

    private int count = 0;
    
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

}

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> { 
	        for (int i = 0; i < 1000; i++) counter.increment(); 
		});

        Thread t2 = new Thread(() -> { 
	        for (int i = 0; i < 1000; i++) counter.increment(); 
		});

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println(counter.getCount());

    }

}
```

---
