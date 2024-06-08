# Multithreading Interview Questions

**Q1.Can you reuse a Thread object? Can you give it a new job to do and restart it by calling start() again?**

No. Once a thread's `run()` method has completed, the thread can never be restarted. In fact, at that point the thread moves into a **dead state**.

The `Thread` object might still be on the heap, as a living object that you call other methods on, but the `Thread` object has permanently lost its **'threadness'**. In other words, there is no longer a separate call stack, and the `Thread` object is no loner a thread. It's just an object, at that point, like all other objects.

> **NOTE:** There are design patterns for making a pool of threads that you can keep using to perform different jobs. However, you don't do it by restarting a dead thread.

---
