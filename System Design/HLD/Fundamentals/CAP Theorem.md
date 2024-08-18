# Understanding CAP Theorem

The CAP theorem states that it is impossible for a distributed system to simultaneously provide more than two of these 3 guarantees: `consistency`, `availability` and `partition tolerance`.

- **Consistency:** All clients see the same data at the same time no matter which node they connect to.

- **Availability:** Any client which requests data gets a response even if some of the nodes are down.

- **Partition Tolerance:** A partition indicates a communication breakdown between two nodes. Partition tolerance means the system continues to operate despite network partitions.

In a distributed system, partitions cannot be avoided. When a partition occurs, we must choose between consistency and availability.

If we choose consistency over availability (CP), we must block all write operations to avoid data inconsistency among nodes (servers), which makes the system unavailable. For example, **Bank systems usually have extremely high consistent requirements.**

If we choose availability over consistency (AP), the system keeps accepting reads, even though it might return stale data.
