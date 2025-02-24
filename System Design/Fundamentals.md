
Q. Explain `Availability`.

**Availability** refers to a system’s ability to **remain operational**, even in the presence of failures.

---

Q. Explain `Reliability`.

**Reliability** refers to a system's ability to **function correctly and continuously over time**, even in the presence of failures.

 Typical expectations from a `reliable` system include:

- **Failure Tolerance:** The system should **perform the function that the user expected** and ensure **data integrity** (no corruption or loss) even in the presence of **hardware faults or network partitions**.

- **Error Resilience:** The system should **gracefully handle user mistakes** or unexpected inputs without breaking functionality.

- **Consistent Performance:** The system must maintain **acceptable performance** under the **expected load and data volume**.

- **Security & Abuse Prevention:** The system should prevent **unauthorised access** and mitigate potential misuse or attacks.

> **NOTE:** If a system is reliable, it is available. However, if it is available, it is not necessarily reliable.

---

Q. Explain `Fault Tolerance`.

Fault tolerance is a **design choice** to handle hardware/software failures effectively. 

Achieved through **replication** (e.g., database replicas, redundant servers) and **failover mechanisms** (automatic switching to backups).

**Example:** Imagine a **cart service** in an e-commerce platform like **Amazon**. If a user adds an item to their shopping cart, the system must **not lose it**, even if the cart service fails. A **replicated server** should take over to ensure the cart remains intact.

> **NOTE:** Redundancy has a cost, but a reliable system must invest in eliminating every **single point of failure** to maintain resilience.

---

Q. Explain `Database Replication`.

Replication means keeping a copy of the same data on multiple machines that are connected via a network.

By replicating data across different locations, your system remains in operation even if a database goes offline as you can access data stored in another database server.

> **NOTE:** Every write to the database needs to be processed by every replica, otherwise, the replicase would no longer contain the same data.

---

Q. Explain `Master-Slave Replication`.



> NOTE: **Master-slave replication** is also known as **leader-based replication** or **active/passive replication**.

---

Q. Explain `Scalability`.

**Scalability** refers to a **system's ability to handle increasing workloads** efficiently by adding resources (e.g., servers, storage, network capacity) without compromising performance.

---

Q. Explain common **load parameters** used to describe load on a system.

1. **Requests per Second (RPS):** 
	- Measures how many incoming requests a **web server** processes per second. 
	- High RPS can **overload** a system, leading to increased response times or failures.

2. **Ratio of Reads to Writes:** 
	- Describes how frequently data from a **database** is **read vs. modified (written)**.
	- A **read-heavy** workload (e.g., content streaming) benefits from caching (e.g., Redis).
	- A **write-heavy** workload (e.g., logging systems) may require database partitioning or NoSQL databases optimised for writes.

3. **Number of Simultaneously Active Users:** 
	- Measures how many users are **actively interacting** with a system **at the same time**.
	- More active users mean more concurrent sessions, consuming server resources.

4. **Hit Rate on a Cache:** 
	- Percentage of requests **served from the cache** rather than the database.
	- A **high hit rate** (e.g., 90%+) reduces database load and improves response times.

---

Q. Explain common performance parameters used to describe performance of a system.

 1. **Latency:**
	 - The time taken for a request to travel from the client to the server and back.
	 - **Example:** In a chat app, if you send a message and the receiver gets it after **500ms**, that’s the latency.

 2. **Response Time:**
	 - The total time taken to process a request and return a response.
	 - Includes **network latency + processing time** on the server.
	 - **Example:** A user submits a form, and it takes **1.5 seconds** to receive a confirmation message, that’s the response time.

 3. **Throughput:**
	 - The number of requests processed **per second** (**RPS** or **transactions per second**).
	 - **Example:** An e-commerce site handling **10,000 purchases per second** during a sale.

---

Q. How to scale your compute?

---

Q. Explain `Database Scaling`.

---

Q. How to scale your network bandwidth?

---

Q. Explain the property of `Partition Tolerance` in distributed systems.

 A requirement in distributed systems to ensure **availability** even when network links between nodes fail.

Achieved through **eventual consistency** (syncing data once the partition is resolved) and **retry mechanisms** (handling temporary network failures). ?????

> **Example:** In a distributed database, if the network splits into two isolated parts (partition), each part should continue serving requests independently until the partition is resolved.

---

Q. Explain `Consistency`. 

 Systems often replicate data across multiple nodes, sometimes in real-time, to improve fault tolerance and performance. However, this replication introduces challenges in maintaining **data consistency**.

> **NOTE:** Data consistency is crucial for ensuring that all users and systems have access to the same, up-to-date information.

---

Q. Explain the property of `strong consistency` in distributed systems.

The system guarantees that as soon as a transaction is committed, all subsequent read operations from any user or node will reflect that latest write, regardless of which replica they access. 

This provides the strongest guarantee of consistency, but can potentially impact system performance due to synchronisation overhead.

---

Q. Explain the property of `eventual consistency` in distributed systems.

The system guarantees that all replicas of data **will eventually** converge to the same state, given enough time and in the absence of further updates. However, in the short term, different nodes may return stale or inconsistent data. 

Since updates don’t need immediate synchronisation across all nodes, systems can respond faster.

> **Example:** Imagine a social media platform where a user updates their profile picture. The change is first stored on one server, then gradually propagates to others. Some users may see the old picture until synchronisation completes, but eventually, all servers reflect the change.

---

Q. Explain `CAP Theorem`.

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


