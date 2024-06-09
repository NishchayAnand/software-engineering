# Understanding Thread Scheduling

Whenever a program has more threads than the machine hosting the program has CPUs, they end up competing for the CPU, and it's up to someone - either the programmer, the JVM or the OS - to make sure the CPU is shared among these threads.

Each thread in a Java program is assigned a certain priority, a positive integer that falls within a well-defined range. This priority can be changed by the developer.

The priority value is important because the contract between the JVM and the underlying OS is that the OS must choose to run the Java thread with the highest priority.

When a higher-priority thread comes along, that thread interrupts (preempts) whatever lower-priority thread is running at the time.

**The contract with the OS, however is not absolute, which means that the OS can sometimes choose to run a lower-priority thread.**
