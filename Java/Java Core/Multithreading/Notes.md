# Understanding Multithreading in Java

Multithreading is the way to obtain fast, lightweight **concurrency** within a single process space.

On single-processor machines, threads can give the illusion of multitasking even though at any given point in time the CPU is executing only one thread. Each thread gets a slice of time on the CPU and then gets switched out either because it initiates a task which requires waiting and not utilizing the CPU or it completes its time slot on the CPU.

Applications can take advantage of multi-core architectures and have a dedicated CPU run each thread.

It is possible to have the overhead of context switching among threads steal away any throughput gains and result in worse performance than a single-threaded scenario. However such cases are unlikely and an exception, rather than the norm.

Web servers that use threads instead of creating new processes when fielding web requests, consume far fewer resources.

## Problems with Multithreading

1. Usually very hard to find bugs.
2. Higher cost of code maintenance since the code inherently becomes harder to reason about.
3. Increased utilization of system resources. Creation of each thread consumes additional memory, CPU cycles for book-keeping and waste of time in context switches.
4. Programs may experience slowdown as coordination amongst threads comes at a price.
5. Acquiring and releasing locks adds to program execution time. Threads fighting over acquiring locks cause lock contention.

## Main Thread

Every Java application starts up a main thread - the thread that puts the main() method on the bottom of the stack. The JVM is responsible for starting the main thread (and other threads, as it chooses, including the garbage collection thread).

As a programmer, you can write code to start other threads of your own.

> **NOTE:** Unless you have multiple processors on your computer, each new Java thread is not actually a separate process runnning on the OS. But it almost feels as though it is.

## How Multithreading works?

With more than one thread, you get the appearance of having multiple things happen at the same time.

In reality, the execution between threads move back and forth so rapidly that you feel as though all threads are executing at the same time.

Remember, Java is just a process running on your underlying OS. So first, Java itself has to be the **currently executing process** on the OS. But once Java gets its turn to execute, JVM runs whatever is on the top of the currently-running stack.

> **NOTE:** One of thinngs a thread must do is keep track of which statement (of which method) is currently executing on the thread's stack.

## How to launch a new Thread?

You can launch a separate thread of execution (with its own call stack) by creating a new `Thread` object.

Sample Code:

```
Thread  t = new Thread();
t.start();
```

The thread `t` defined above would actually do nothing. It "dies" virtually the instant it's born. We need the code that you want to have run by a separate thread passed in as the constructor argument to `Thread()`.

A Thread object needs a job. A job that the thread will run when the thread is started. A thread's jobs can be defined in any class that implements the `Runnable` interface.

When you pass a `Runnable` to a `Thread` constructor, you're really just giving the `Thread` a way to get to a `run()` method (define the code that we want the thread to execute).

Sample Code:

```
Runnable r = new MyThreadJob();
Thread t = new Thread(r);
t.start();
```

Here, `MyThreadJob` is the class that implements the Runnable interface (defines its `run()` method which ). `t.start()` actually starts a new thread, putting the `Runnable` object's `run()` method on the bottom of the new thread's stack.

> **NOTE:** Runnable is the job a thread is supposed to run.

## Three States of a new Thread

1. `Thread t = new Thread(r);`: A `Thread` instance has been created but not started **(initial state)**. In other words, there's a `Thread` object, but no thread of execution.

2. `t.start();`: When you start the thread, it moves to the **Runnable state**. This means the thread is ready to run and just waiting for its chance to be selected for execution. At this point, there is a new call stack for this thread.

3. In the **Running state** state, a thread (and ONLY this thread) has an active call stack, and the method on the top of the stack is executing.

## Thread Scheduler

The **JVM thread scheduler** is responsible for selecting the thread to execute next. You can sometimes influence that decision, but you cannot forve a thread to move from **Runnable** to **Running** state. There is not API for calling methods on the scheduler.

Once the thread becomes runnable, it can move back and forth between runnable, running and an additional state: `temporarily not-runnable (a.k.a blocked)`.

The thread scheduler can move a running thread into a blocked state. For example,

1. A thread might be executing code to read from a `Socket` input stream, but there isn't any data to read. The scheduler will move the thread out of the running state until something becomes available.
2. The executing code might have told the thread ot put itself to sleep (`sleep()`).
3. The thread might be waiting on an object which is **locked**. In that case, the thread can't continue until the object's lock is freed by the thread that has it.

> **NOTE:** The scheduler implementations are different for different JVM's, and even running the same program on the same machine can give you different results.

## Putting a thread to sleep

Putting a thread to sleep, even for a few milliseconds, forces the currently-running thread to leave the running state, thus giving another thread a chance to run.

Calling `Thread` class static `sleep()` method, passing in the sleep duration (in milliseconds), will knock a thread out of the running state, and keep it out of the runnable state for 2 seconds.

Sample Code:

```
Thread.sleep(2000);
```

A bit unfortunately, the sleep throws an `InterruptedException`, a checked exception, so all calls to sleep must be wrapped in a `try/catch`.

Sample Code:

```
try {
    Thread.sleep(2000);
} catch(InterruptedException ex) {
    ex.printStackTrace();
}
```

> **NOTE:** Your thread will probably never be interrupted from sleep. The exception is in the API to support a thread communication mechanism that almost nobody uses in the Real World. But, you still have to obey the handle or declare law, so you need to get used to wrapping your `sleep()` calls in a `try/catch`.

The thread won't wake up at the designated time and become the currently-running thread. When a thread wakes up, the thread is once again at the mercy of the thread scheduler.

## Threads can lead to Concurrency Issues

Concurrency issues lead to race condition. Race conditions lead to data corruption.

**It all comes down to one potentially deadly scenario: _"two or more threads have access to a single object's data"_. In other words, methods executing on two different stacks are both calling, say, getters or setters on a single object on the heap.**

> **NOTE:** When a thread is not running, and in runnable (or blocked) it's essentially knocked unconscious. When it becomes the currently-running thread again, it doesn't know that it ever stopped.

Use the `synchronized` keyword to modify a method so that only one thread at a time can access it.

> **NOTE:** We can use the synchronized keyword to synchronize at the more fin-grained level of one or more statements, rather than at the whole-method level.

## Lock

Every object has a lock. When an object has one or more synchronized methods, a thread can enter a synchronized method **only if the thread can get the key to the object's lock.**

While a thread is holding the key, **no other threads can enter any of that object's synchronized methods** (because the one key for that object won't be available).

> **NOTE:** Locks are not per _method_, they are per _object_.

## Problems with Synchronizations

1. A synchronized method forces other threads to get in line and wait their turn. This will lead to a performance hit, though you'd never notice it.

2. **Dead Lock:** Thread deadlock happens when you have two threads, both of which are holding a key the other thread wants. There's no way out of this scenario, so the two threads sit and wait.

> **NOTE:** A good rule of thumb is to synchronize only the bare minimum that should be synchronized.

Links:

1. Head First Java
2. Java Threads by Scott Oaks and Henry Wong
