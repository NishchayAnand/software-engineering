# Understanding Multithreading in Java

A concurrent program is one that can be decomposed into constituent parts and each part can be executed out of order or in partial order without affecting the final outcome.

> **NOTE:** With concurrency, the execution of two programs or units of the same program may not happen simultaneously.

Multithreading is the way to obtain fast, lightweight **concurrency** within a single process space.

On single-processor machines, threads can give the illusion of multitasking even though at any given point in time the CPU is executing only one thread. Each thread gets a slice of time on the CPU and then gets switched out either because it initiates a task which requires waiting and not utilizing the CPU or it completes its time slot on the CPU.

Applications can take advantage of multi-core architectures and have a dedicated CPU run each thread.



Web servers that use threads instead of creating new processes when fielding web requests, consume far fewer resources.


## Thread Scheduler



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
