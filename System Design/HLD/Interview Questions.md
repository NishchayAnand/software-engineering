Q. What does `Consistency` mean in distributed systems?

Distributed systems often replicate data across multiple nodes, sometimes in real-time, to improve fault tolerance and performance. However, this replication introduces challenges in maintaining **data consistency**.

> **NOTE:** Data consistency is crucial for ensuring that all users and systems have access to the same, up-to-date information.

---

Q. Explain different types of **consistency patterns**.

- **Strong consistency:** All operations appear to be executed in some total order. Each read operation will return the value of the most recent write to the same data item. This provides the strongest guarantee of consistency, but can potentially impact system performance due to synchronisation overhead.

- **Eventual consistency.** The system guarantees that if no new updates are made to a data item, all replicas will converge to the same value eventually. It allows replicas to diverge temporarily and reconcile later, making it more scalable but providing weaker consistency guarantees.

---

Q. Explain the property of `Availability` in distributed systems.

Any client which requests data gets a response even if some of the nodes are down.

---

Q. Explain the property of `Partition Tolerance` in distributed systems.

A partition indicates a communication breakdown between two nodes. Partition tolerance means the system continues to operate despite network partitions.

---

Q. Explain CAP Theorem.

CAP theorem states that it is impossible for a distributed system to simultaneously provide more than two of these 3 guarantees: `consistency`, `availability` and `partition tolerance`.

In a distributed system, partitions cannot be avoided. When a partition occurs, we must choose between consistency and availability.

If we choose consistency over availability (CP), we must block all write operations to avoid data inconsistency among nodes (servers), which makes the system unavailable. For example, **Bank systems usually have extremely high consistent requirements.**

If we choose availability over consistency (AP), the system keeps accepting reads, even though it might return stale data.

---

## EXTRA

Q. What is Load Balancer?

---
Q. Different algorithms of load balancing

---
Q. Explain Caching Layer?

---
Q. Explain different algorithms of caching?

---
Q. What is Redis?

---
Q. What is API Gateway?

---
Q. What is Rate Limiter?

---
Q. Differences between SQL and NoSQL

---
Q. Explain Proxy

---
Q. Explain forward Proxy.

---
Q. Explain reverse Proxy.

---
Q. Explain sharding / partitioning of data.

---
Q. Explain eventual consistency

---
Q. What is a Message Queue?

---
Q. What is Apache Kafka?

---
Q. What is GraphQL?

---
Q. What is WebSocket?

---
Q. What is gRPC?

---
