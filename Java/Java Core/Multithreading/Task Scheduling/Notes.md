# Understanding Task Scheduling in Java

Task schedulers give us the opportunity to execute particular tasks **after** a fixed point in time in the future. They allow us to setup repeated execution of tasks.

Ways to schedule tasks in the future:

1. `java.util.Timer` class
2. `ScheduledThreadPoolExecutor` class (uses a thread pool)

The key benefit of task ececutors and timers is that they free you from having to worry about thread-related programming for your tasks. You simply feed the task to the imer or executor and let it worry about the necessary thread controls. This makes the code you write much simpler.
