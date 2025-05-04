# Understanding Concurrency

Concurrency means multiple computations are happening at the same time. Concurrency is everywhere in modern programming, whether we like it or not. For example, Eclipse compiles your Java code while you’re still editing it.

There are two common models for concurrent programming: **shared memory** and **message passing**.

## Shared Memory

Concurrent modules interact by reading and writing shared objects in memory. For example, A and B might be two threads in the same Java program, sharing the same Java objects.

## Message Passing

Concurrent modules interact by sending messages to each other through a communication channel. Modules send off messages, and incoming messages to each module are queued up for handling. For example, A and B might be a web browser and a web server – A opens a connection to B and asks for a web page, and B sends the web page data back to A.

## EXTRA

A concurrent system can have two programs in progress at the same time where progress doesn’t imply execution. One program can be suspended while the other executes.

In concurrent systems, the goal is to **maximize throughput** and **minimize latency.** These two goals often have a trade-off relationship:

1. **Focus on Throughput:** When you prioritize throughput, you try to handle a large volume of requests simultaneously. This might involve techniques like _creating more threads or processes to handle tasks concurrently_. However, increasing concurrency can lead to more context switching between tasks, potentially _increasing latency for individual requests_.

2. **Focus on Latency:** Conversely, focusing on minimizing latency means _prioritizing the responsiveness of the system to individual requests_. This might involve techniques like optimizing code for faster execution or _prioritizing tasks with lower latency requirements_. However, prioritizing low latency might _limit the overall number of tasks handled concurrently_, potentially impacting throughput.

## Links

1. https://web.mit.edu/6.031/www/sp19/classes/19-concurrency/#reading_19_concurrency
