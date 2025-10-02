# Understanding Callable Interface

A functional interface containing a single abstract method called `call()`. A **callable object** can return a result or throw a check exception, unlike a **runnable object**.

```
package java.util.concurrent;
public interface Callable<V> {
    public <V> call() throws Exception;
}
```

Callable objects are used only by executor services (not simply executors). When you ask a executor service to run a `Callable` object, the service returns a `Future` object that allows you to retrieve the result of the call, monitor the status of the task, and cancel the task.

> **NOTE:** Every callable object that is sent to an executor service returns a matching future object. In other words, the `get()` method of the future object returns the results of its corresponding `call()` method.
