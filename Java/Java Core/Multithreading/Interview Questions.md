# Multithreading Interview Questions

**Q1.Can you reuse a Thread object? Can you give it a new job to do and restart it by calling start() again?**

No. Once a thread's `run()` method has completed, the thread can never be restarted. In fact, at that point the thread moves into a **dead state**.

The `Thread` object might still be on the heap, as a living object that you call other methods on, but the `Thread` object has permanently lost its **'threadness'**. In other words, there is no longer a separate call stack, and the `Thread` object is no loner a thread. It's just an object, at that point, like all other objects.

> **NOTE:** There are design patterns for making a pool of threads that you can keep using to perform different jobs. However, you don't do it by restarting a dead thread.

---

**Q2. What are thread priorities?**

Thread priorities are numerical values that tell the scheduler how important a thread is to you. The scheduler can kick a lower priority thread out of the runnable state if a higher priority threas suddenly becomes runnable.

It's important to note that thread priorities might help you influence the scheduler, but they still **don't offer any guarantee**. We recommend that you use priorities only if you want to influence performance, but never, ever reliy on them for program correctness.

---
