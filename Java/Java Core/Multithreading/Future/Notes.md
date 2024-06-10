# Understanding Future Interface

The `Future` interface is a marker interface used to represent the asynchronous result of a task submitted to an `ExecutorService`.

It provides methods like:

- `isDone()`: to check if the task associated with the `Future` object has finished execution.
- `isCancelled()`: to check if the task associated with the `Future` object has been cancelled.
- `get()`: allows you to wait for the task to complete and then retrieve its result.
