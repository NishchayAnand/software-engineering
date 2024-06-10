# Thread Pool Interview Questions

**Q1. Why Thread Pools?**

1. The first reason thread pools are often recommended is because it's felt that the overhead of creating a thread is very high _(as much as a few hundred microseconds)_. By using a pool, we can gain some performance when the threads are reused.

2. **A thread pool allows you to delegate all the thread management to the pool itself,** letting you focus on the logic of your program. With a thread pool, you simply create a task and send the task to the pool to be executed.

3. **Anytime you have more active threads than CPUs, a thread pool can play a crucial role in making your program seem to run faster and more effeciently.**

---

**Q2. Why Not Thread Pools?**

1. If your program design nicely separates into multiple threads and you're interested in the end result of all those threads (don't care about the results given by each thread), a thread pool isn't necessary.

2. Thread pools are also not necessary when available CPU resources are adequate to handle all the work the program needs to do (never have fewer runnable threads than CPUs).

---
