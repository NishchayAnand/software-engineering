# Understanding Thread Pools in Java

The idea behind a thread pool is to set up a number of threads that sit idle, waiting for work that they can perform.

As your program has tasks to execute, it encapsulates those taks into some object (typically a `Runnable` object) and informs the thread pool that there is a new task.

One of the idle threads in the pool takes the task and executes it. When it finishes the task, it goes back and waits for another task.

> **NOTE:** When you add a task to a thread pool, it might have to wait for an available thread to run it.

## Executors

Executors are a useful design pattern for multithreaded programs because they allow you to model your program as a series of tasks.

`Executor` interface provides a simple and abstract way to submit tasks for execution without directly managing the creation or lifecycle of threads.

`ExecutorService` interface provides a means for you to manage the executor and its tasks. An executor service allows you to handle many tasks in ways that the simple `Executor` interface does not accomodate. Tasks can be sent to an executor service via a `submit()` method, which returns a `Future` object that can be used to track the progress of the task.

## How to use a Thread Pool?

To use a thread pool, you must do 2 things:

1. Use `Runnable` to create the tasks that the pool is to run,
2. Use `ThreadPoolExecutor` to create the pool itself.

## What affects a Thread Pool?

The 2 fundamental things that affect the thread pool are its size and the queue used for the tasks.
