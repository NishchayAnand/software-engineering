# Understanding Runnable Interface

A functional interface with a single abstract method called `run()` that can be used to define the code that runs in a thread.

```
@FunctionalInterface
public interface Runnable {
    void run();
}
```

## Sample Code

```
Runnable task = () -> {System.out.println("Task is running");};
Thread thread = new Thread(task);
thread.start();
```
