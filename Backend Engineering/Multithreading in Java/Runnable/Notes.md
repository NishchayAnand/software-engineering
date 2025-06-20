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

Java permits the Runnable to read variables from its outer scope. Therefore, in the below code, `ballsInPlay` is not thread-safe.

```
public class PinballSimulator {

    public void simulate() {
        int numberOfLives = 3;
        List<Ball> ballsInPlay = new ArrayList<>();

        new Thread(new Runnable() {
            public void run() {
                ballsInPlay.add(new Ball());
            }
        }).start();
    }
}
```

In a system where you create and start new threads, sharing fields and local variables with inner Runnable instances is common.
