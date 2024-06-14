# Understanding Concurrency

A concurrent system can have two programs in progress at the same time where progress doesn’t imply execution. One program can be suspended while the other executes.

In concurrent systems, the goal is to **maximize throughput** and **minimize latency.** These two goals often have a trade-off relationship:

1. **Focus on Throughput:** When you prioritize throughput, you try to handle a large volume of requests simultaneously. This might involve techniques like _creating more threads or processes to handle tasks concurrently_. However, increasing concurrency can lead to more context switching between tasks, potentially _increasing latency for individual requests_.

2. **Focus on Latency:** Conversely, focusing on minimizing latency means _prioritizing the responsiveness of the system to individual requests_. This might involve techniques like optimizing code for faster execution or _prioritizing tasks with lower latency requirements_. However, prioritizing low latency might _limit the overall number of tasks handled concurrently_, potentially impacting throughput.
