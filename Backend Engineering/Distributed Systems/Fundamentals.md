
Q. Explain **`Availability`**.

**Availability** refers to a system’s ability to **remain operational**, even in the presence of failures.

---

Q. Explain **`Reliability`**.

**Reliability** refers to a system's ability to **function correctly and continuously over time**, even in the presence of failures.

 Typical expectations from a `reliable` system include:

- **Failure Tolerance:** The system should **perform the function that the user expected** and ensure **data integrity** (no corruption or loss) even in the presence of **hardware faults or network partitions**.

- **Error Resilience:** The system should **gracefully handle user mistakes** or unexpected inputs without breaking functionality.

- **Consistent Performance:** The system must maintain **acceptable performance** under the **expected load and data volume**.

- **Security & Abuse Prevention:** The system should prevent **unauthorised access** and mitigate potential misuse or attacks.

> **NOTE:** If a system is reliable, it is available. However, if it is available, it is not necessarily reliable.

---

Q. Explain **`Fault Tolerance`**.

Fault tolerance is a **design choice** to handle hardware/software failures effectively. 

Achieved through **replication** (e.g., database replicas, redundant servers) and **failover mechanisms** (automatic switching to backups).

**Example:** Imagine a **cart service** in an e-commerce platform like **Amazon**. If a user adds an item to their shopping cart, the system must **not lose it**, even if the cart service fails. A **replicated server** should take over to ensure the cart remains intact.

> **NOTE:** Redundancy has a cost, but a reliable system must invest in eliminating every **single point of failure** to maintain resilience.

---

Q. What is **`Gossip Protocol`**.

In distributed system, it is insufficient to be that a server is down when another server says so. Usually, it requires at least 2 independent sources of information to mark a server down. 

---

Q. Explain **`Scalability`**.

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

Q. How to increase your **`throughput`**?

1. **Data Replication**
2. **Data Partitioning**

---

Q. Explain **`Database Replication`**.

Replication means keeping a copy of the same data on multiple machines that are connected via a network.

Every write to the database needs to be processed by every replica, otherwise, the replicas would no longer contain the same data.

> **NOTE:** To achieve high availability and reliability, data must be replicated.

---

Q. Explain the need for **`Database Replication`**.

1. To keep data geographically close to your users (and thus reduce latency).

2. To allow the system to continue working even if some of its components have failed (and thus increase availability).

3. To scale out the number of machines that can serve read queries (and thus increase read throughput).

> **NOTE:** For better reliability, replicas are placed in distinct data centres, and data centres are connected through high-speed networks.

---

 Q. How to ensure every write is propagated to all replicas?

The most common solution for this is called **leader-based replication** (also known as **active / passive** or **master-slave** replication).

It works as follows:

- One of the replicas is designated the leader (also known as master or primary). When clients want to write to the database, they must send their requests to the leader, which first writes the new data to its local storage. 

- The other replicase are known as followers (read replicas, slaves, secondaries, or hot standbys). Whenever the leader writes new data to its local storage, it also sends the data change to all of its followers as part of a replication log or change stream. Each follower takes the log from the leader and updates its local copy of the database accordingly, by applying all writes in the same order as they were processed on the leader. 

> NOTE: When a client wants to read from the database, it can query either the leader or any of the followers. However, writes are only accepted on the leader (the followers are read-only from the client's point of view).

---

Q. Explain **`Synchronous Replication`**.

**Advantage**: The follower is guaranteed to have an update-to-date copy of the data that is consistent with the leader. If the leader suddenly fails, we can we sure that the data is still available on the follower. 

**Disadvantage**: If the synchronous follower doesn't respond (because it has crashed, or there is a network fault, or for any other reason), the write cannot be processed. The leader must block all writes and wait until the synchronous is available again.

> **NOTE: It is impractical for all followers to be synchronous.**

---

Q. Explain **`Asynchronous Replication`**.

**Advantage:** Leader can continue processing writes, even if all of its followers have fallen behind.

**Disadvantage:** If the leader fails and is not recoverable, any writes that have not yet been replicated to followers are lost. This means that a write is not guaranteed to be durable, even if it has been confirmed to the client. 

> **NOTE: Leader-based replication is often configured to be completely asynchronous.**  

---

Q. How to handle a **`Leader Failure`**?

1. **Determining that the leader has failed:** There is no foolproof way of detecting what has gone wrong, so most systems use a **timeout**: nodes frequently bounce messages back and forth between each other, and if a node doesn't respond for some period of time (say, 30 seconds), it is assumed to be dead.

2. **Choosing a new leader:** The best candidate for leadership is usually the replica with the most up-to-date data changes from the old leader (to minimise any data loss).

3. **Reconfiguring the system to use the new leader:** Clients now need to send their write requests to the new leader and the system needs to ensure that the old leader becomes a follower and recognises the new leader.

> **NOTE:** The process of handling a leader failure is called **Failover**.

---

Q. Explain the limitations of **`Failover`**.

1. If asynchronous replication is used, the new leader may not have received all the writes from the old leader when it failed. While the former leader rejoins the cluster, the new leader may have received **conflicting** writes in the meantime. **The most common solution is for the old leader's unreplicated writes to simply be discarded, which may violate client's durability expectations.**

2. In certain fault scenarios, it could happen that two nodes both believe that they are the leader. This situation is called **split brain**. If both leaders modify the same record at the same time, and there’s no built-in way to resolve conflicts (determine which change should be applied), data is likely to be corrupted. 

3. **What is the right timeout before the leader is declared dead?** A longer timeout means a longer time to recovery. However, if the timeout is too short (e.g., load spike, network glitch), there could be unnecessary failovers. **If the system is already struggling with high load or network problems, an unnecessary failover is likely to make the situation worse, not better.**

---

Q. Explain **`statement-based`** replication method.

- The leader logs every write request (statement) that it executes and sends that statement log to its followers. 

- Each follower parses and executes that SQL statement as if it had been received from a client. 

---

Q. Explain the limitations of **`statement-based replication`**.

1. Any statement that calls a non-deterministic function, such as `NOW()` to get the current date, is likely to generate a different value for each replica. The leader can replace any non-deterministic function calls with a fixed return value when the statement is logged so that the followers all get the same data. 

2. If statements use an auto-incrementing column, or if they depend on the existing data in the database (e.g., `UPDATE ... WHERE <some condition>`), they must be executed in exactly the same order on each replica, or else they may have a different effect. This can be limiting when there are multiple concurrently executing transactions. 

> **NOTE:** Due to so many edge cases, other replication methods are now generally preferred.

---

Q. Explain **`Replication Lag`**.

If an application reads from an asynchronous follower, it may see outdated information if the follower has fallen behind. This leads to apparent inconsistencies in the database. 

In simple terms, if you run the same query on the leader and the follower at the same time, you may get different results, because not all writes have been reflected in the follower.

This inconsistency is just a temporary state. If you stop writing to the database and wait for a while, the follower will eventually catch up and become consistent with the leader. For that reason, this effect is known as **eventual consistency**.

> **NOTE:** In general, there is no limit to how far a replica can fall behind. However, in general operation, the delay between a write happening on the leader and being reflected on a follower (the replication lag) may be only a fraction of a second, considering there is no load peak or network issues. 

---

Q. Explain **`read-after-write (read-your-writes)`** consistency.

With asynchronous replication, if the user views the data shortly after making a write, the new data may not yet have reached the replica. To the user, it looks as though the data they submitted was lost, so they will be understandably unhappy.

In this situation, we need **read-after-write** consistency, also known as **read-your-writes** consistency. This is a guarantee that if the user reloads the page, they will always see any updates they submitted themselves.

> **NOTE:** It makes no promises about other users, other users' updates may not be visible until some later time. However, it reassures the user that their own input has been saved correctly.

---

Q. How to implement **`read-your-writes`** consistency in a system with **`leader-based replication`.**

**When reading something that the user may have modified, read it from the leader**, otherwise, read it from a follower. 

**This requires that you have some way of knowing whether something might have been modified, without actually querying it.** For example, user profile information on a social network is normally only editable by the owner of the profile, not by anybody else. Thus, a simple rule is: **always read the user’s own profile from the leader, and any other users’ profiles from a follower.**

> **NOTE:** If most things in the application are potentially editable by the user, that approach won’t be effective, as most things would have to be read from the leader (negating the benefit of read scaling). In that case, other criteria may be used to decide whether to read from the leader.

---

Q. Explain **`Monotonic Reads`** consistency.

**Monotonic reads** guarantee that if one user makes several reads in sequence, they will not see time go backward, i.e., they will not read older data after having previously read newer data.

For example, if the user makes same query twice, first to a follower with little lag, then to a follower with greater lag (this scenario is quite likely if the user refreshes a web page, and each request is routed to a random server). **The first query returns a comment that was recently added by user 1234, but the second query doesn’t return anything because the lagging follower has not yet picked up that write.**

> **NOTE: Monotonic reads is a lesser guarantee than strong consistency, but a stronger guarantee than eventual consistency.**

---

Q. How to achieve **`Monotonic Reads`** consistency.

One way of achieving monotonic reads is to make sure that each user always makes their reads from the same replica (e.g., the replica can be chosen based on a hash of the user ID).

> **NOTE: Different users can read from different replicas**.

---

Q. Explain the disadvantages of **`Single Leader Replication`**.

- Every write must go over the internet to the datacenter with the leader. This can add significant latency to writes and might contravene the purpose of having multiple data centres in the first place.


---

Q. Explain **`Multi Leader Replication`**.

> **NOTE: Multi-leader replication is often considered dangerous territory that should be avoided if possible**. 

---

Q. Explain the advantages of **`Multi Leader Replication`**.

- Every write can be processed in the local datacenter and is replicated asynchronously to the other data centres. Thus, the inter-datacenter network delay is hidden from users, which means the perceived performance may be better.

- In a single-leader configuration, if the datacenter with the leader fails, failover can promote a follower in another datacenter to be leader. In a multi-leader configuration, each datacenter can continue operating independently of the others, and replication catches up when the failed datacenter comes back online.

- A multi-leader configuration with asynchronous replication can usually tolerate network problems better: a temporary network interruption does not prevent writes being processed.

---

Q. Explain the limitations of **`Multi Leader Replication`**.

The same data may be concurrently modified in two different data centres, leading to write conflicts.

---

Q. How to handle write conflicts in **`Multi Leader Replication`**?

The simplest strategy for dealing with conflicts is to avoid them. If the application can ensure that all writes for a particular record go through the same leader, then conflicts cannot occur.

For example, in an application where a user can edit their own data, you can ensure that requests from a particular user are always routed to the same datacenter and use the leader in that datacenter for reading and writing. 

> **NOTE: Different users may have different “home” data centres (perhaps picked based on geographic proximity to the user), but from any one user’s point of view the configuration is essentially single-leader.**

---

Q. Explain **`Leaderless Replication`**.

Abandoning the concept of a leader and allowing any replica to directly accept writes from clients.

> **NOTE: In a leaderless configuration, failover does not exist.**

---

Q. Explain the working of a system with **`Leaderless Replication`**.

The client (user 1234) sends the write to all three replicas in parallel, and the two available replicas accept the write but the unavailable replica misses it.

Let’s say that it’s sufficient for two out of three replicas to acknowledge the write. After user 1234 has received two ok responses, we consider the write to be successful. The client simply ignores the fact that one of the replicas missed the write.

When the unavailable node comes back online, the clients start reading from it. Any writes that happened while the node was down are missing from that node. Thus, if you read from that node, you may get stale (outdated) values as responses.

To solve that problem, when a client reads from the database, it doesn’t just send its request to one replica: read requests are also sent to several nodes in parallel. The client may get different responses from different nodes; i.e., the up-to-date value from one node and a stale value from another. **Version numbers are used to determine which value is newer.**

---

Q. Explain **`Quorum Consensus`**.

`N` = The number of replicas.

`W` = For a write operation to be considered as successful, write operation must be acknowledged from `W` replicas. For example, `W = 1` means that the coordinator must receive at least on acknowledgment before write operation is considered as successful.

`R` = For a read operation to be considered as successful, read operation must wait for responses from at least r replicas. For example, `R = 1` means that the coordinator must receive at least on acknowledgment before write read is considered as successful.

In Dynamo-style databases (e.g., DynamoDB, Cassandra), the parameters `N`, `W`, `R` are typically configurable. The configuration of these parameters is a typical tradeoff between **latency** and **consistency**.

If `W | R > 1`, the system offers better consistency, however, the query will be slower because the coordinator must wait for the response from the slowest replica.

If `W + R > N`, strong consistency is guaranteed because there must be at least one overlapping node that has the latest data to ensure consistency. **??????**

**Examples:**

1. If `R = 1` and `W = N`, the system is optimised for a fast read.
2. If `R = N` and `W = 1`, the system is optimised for fast write.

> **NOTE:** Normally, reads and writes are always sent to all the `N` replicas in parallel.

---

Q. Explain the limitations of **`Quorum Consistency`**.

- If a write succeeded on some replicas but failed on others (for example because the disks on some nodes are full), and overall succeeded on fewer than w replicas, it is not rolled back on the replicas where it succeeded.

- Allow several clients to concurrently write to the same key, which means that conflicts will occur. In simple terms, if two writes occur concurrently, it is not clear which one happened first. The problem is that events may arrive in a different order at different nodes, due to variable network delays and partial failures. **In order to become eventually consistent, the replicas should converge toward the same value. How do they do that?**

> **NOTE:** If one operation happened before another, the later operation should overwrite the earlier operation, but if the operations are concurrent, we have a conflict that needs to be resolved.

---

Q. How **`Last Write Wins (LWW)`** algorithm help resolve concurrent write conflicts?

**Last Write Wins** algorithm is based on the idea that each replica should only store the **most recent value** and allow **older values to be overwritten / discarded**. 

As long as we know which write is more recent, and every write is eventually copied to every replica, the replicas will eventually converge to the same value.  For example, we can attach a timestamp to each write, **pick the biggest timestamp as the most recent, and discard any writes with an earlier timestamp.**

LWW achieves the goal of eventual convergence, but at the cost of durability: if there are several concurrent writes to the same key, even if they were all reported as successful to the client (because they were written to w replicas), only one of the writes will survive and the others will be silently discarded.

If losing data is not acceptable, LWW is a poor choice for conflict resolution. **The only safe way of using a database with LWW is to ensure that a key is only written once and thereafter treated as immutable, thus avoiding any concurrent updates to the same key.**

> **NOTE:** LWW is the only supported conflict resolution method in Cassandra. a recommended way of using Cassandra is to use a `UUID` as the key, thus giving each write operation a unique key.

---

Q. Explain **`Data Partitioning`**.

Partitioning is necessary when you have so much data that storing and **processing it** on a single machine is no longer feasible. 

Normally, partitions are defined in such a way that each piece of data (each record, row, or document) belongs to exactly one partition.

> **NOTE:** The main reason for wanting to partition data is scalability.

---

Q. Explain key challenges with **`Data Partitioning`**.

1. Distribute data across multiple servers evenly (`routing`).
2. Minimise data movement when nodes are added or removed (`rebalancing`).

> **NOTE: Consistent hashing is a great technique to solve these problems.**

---

Q. Explain different **`Key-Value Data Partitioning`** strategies.

Our goal with partitioning is to spread the data and query load evenly across nodes. Different partitioning strategies include:

**Partitioning by Key Range:**

- **Assign a continuous range of keys** (from some minimum to some maximum) to each partition. This partitioning strategy is used by databases like `Bigtable`, `MongoDB`, etc.

- If you know the boundaries between the ranges, you can easily determine which partition contains a given key. If you also know which partition is assigned to which node, you can make your request directly to the appropriate node. 

- The ranges of keys are not necessarily evenly spaced, because your data may not be evenly distributed. Therefore, in order to distribute data evenly, the partition boundaries need to adapt to the data.

- With each partition, we can keep keys in sorted order. This has the advantage that range scans are easy. 

- **Disadvantage:** Certain access patterns can lead to hot spots (a partition with disproportionately high load). 

> **NOTE:** The simplest approach for avoiding hot spots would be to **assign records to nodes randomly.** That would distribute the data quite evenly across the nodes, but it has a big disadvantage: when you’re trying to read a particular item, you have no way of knowing which node it is on, so you have to **query all nodes in parallel**.

**Partitioning by Hash of Key:**

- Because of this risk of skew and hot spots, many distributed data stores use a hash function to determine the partition for a given key.

- A good hash function takes skewed data and makes it uniformly distributed. Once you have a suitable hash function for keys, you can assign each partition a range of hashes (rather than a range of keys), and every key whose hash falls within a partition's range will be stored in that partition. 

- **Disadvantage:** By using the hash of the key for partitioning, we lose a nice property of key-range partitioning: **the ability to do efficient range queries**. Keys that were once adjacent are now scattered across all the partitions, so their sort order is lost. 

> **NOTE:** In MongoDB, if you enable hash-based sharding mode, any range query has to be sent to all partitions.

**EXTRA:** 

<span style="color: green">Cassandra achieves a compromise between the two partitioning strategies. A table in Cassandra can be declared with a compound primary key consisting of several columns. Only the first part of that key is hashed to determine the partition, but the other columns are used as a concatenated index for sorting the data.</span>

<span style="color: green">The concatenated index approach enables an elegant data model for one-to-many relationships. For example, on a social media site, one user may post many updates. If the primary key for updates is chosen to be (user_id, update_timestamp), then you can efficiently retrieve all updates made by a particular user within some time interval, sorted by timestamp. Different users may be stored on different partitions, but within each user, the updates are stored ordered by timestamp on a single partition.</span>

---

Q. How to deal with **`hot spots`**.

In the extreme case where all reads and writes are for the same key, you still end up with all requests being routed to the same partition. This kind of workload is perhaps unusual, but not unheard of: for example, on a social media site, a celebrity user with millions of followers may cause a storm of activity when they do something. This event can result in a large volume of writes to the same key (where the key is perhaps the user ID of the celebrity, or the ID of the action that people are commenting on).

Today, most data systems are not able to automatically compensate for such a highly skewed workload, so it’s the responsibility of the application to reduce the skew. For example, if one key is known to be very hot, a simple technique is to add a random number to the beginning or end of the key. Just a two-digit decimal random number would split the writes to the key evenly across 100 different keys, allowing those keys to be distributed to different partitions.

However, having split the writes across different keys, any reads now have to do additional work, as they have to read the data from all 100 keys and combine it. This technique also requires additional bookkeeping: it only makes sense to append the random number for the small number of hot keys; for the vast majority of keys with low write throughput this would be unnecessary overhead. Thus, you also need some way of keeping track of which keys are being split.

---

Q. How to choose the right number of partitions?

Choosing the right number of partitions is difficult if the total size of the dataset is highly variable (for example, if it starts small but may grow much larger over time).

Since each partition contains a fixed fraction of the total data, the size of each partition grows proportionally to the total amount of data in the cluster. If partitions are very large, rebalancing and recovery from node failures become expensive. But if partitions are too small, they incur too much overhead.

---

Q. What is **`Rebalancing`**.

Over time, things change in a database:

- The query throughput increases, so you want to add more CPUs to handle the load.
- <span style="color: yellow">The dataset size increases, so you want to add more disks and RAM to store it.</span>
- A machine fails, and other machines need to take over the failed machine’s responsibilities.

All of these changes call for data and requests to be moved from one node to another. The process of moving load (data storage, read and write requests) from one node in the cluster to another is called **rebalancing**.

> **NOTE:** While rebalancing is happening, the database should continue accepting reads and writes.

---

Q. Explain different **`Rebalancing`** strategies. 

**Hash mod N:**

For example, hash(key) mod 10 would return a number between 0 and 9 (if we write the hash as a decimal number, the hash mod 10 would be the last digit). If we have 10 nodes, numbered 0 to 9, that seems like an easy way of assigning each key to a node.

The problem with the **mod N approach** is that if the number of nodes N changes, most of the keys will need to be moved from one node to another.

**Fixed Number of Partitions:**

Create many more partitions than there are nodes, and assign several partitions to each node.

Now, if a node is added to the cluster, the new node can steal a few partitions from every existing node until partitions are fairly distributed once again. If a node is removed from the cluster, the same happens in reverse.

Only entire partitions are moved between nodes. The number of partitions does not change, nor does the assignment of keys to partitions. The only thing that changes is the assignment of partitions to nodes.

This change of assignment is not immediate. It takes some time to transfer a large amount of data over the network, so the old assignment of partitions is used for any reads and writes that happen while the transfer is in progress.

<span style="color: yellow">For databases that use key range partitioning, a fixed number of partitions with fixed boundaries would be very inconvenient: if you got the boundaries wrong, you could end up with all of the data in one partition and all of the other partitions.</span> ??

**Dynamic Partitioning:**

When a partition grows to exceed a configured size (on HBase, the default is 10 GB), it is split into two partitions so that approximately half of the data ends up on each side of the split. Conversely, if lots of data is deleted and a partition shrinks below some threshold, it can be merged with an adjacent partition.

An advantage of dynamic partitioning is that the number of partitions adapts to the total data volume. If there is only a small amount of data, a small number of partitions is sufficient, so overheads are small; if there is a huge amount of data, the size of each individual partition is limited to a configurable maximum.

However, a caveat is that an empty database starts off with a single partition. While the dataset is small—until it hits the point at which the first partition is split—all writes have to be processed by a single node while the other nodes sit idle.

With dynamic partitioning, the number of partitions is proportional to the size of the dataset, since the splitting and merging processes keep the size of each partition between some fixed minimum and maximum. However, the number of partitions is independent of the number of nodes.

**Partitioning proportionally to nodes:**

Have a fixed number of partitions per node. In this case, the size of each partition grows proportionally to the dataset size while the number of nodes remains unchanged, but when you increase the number of nodes, the partitions become smaller again. 

Since a larger data volume generally requires a larger number of nodes to store, this approach also keeps the size of each partition fairly stable.

> **NOTE:** By assigning more partitions to nodes that are more powerful, you can force those nodes to take a greater share of the load. 

---

Q. Explain **`Consistent Hashing`**.

A way to evenly distribute load across an internet-wide system. It uses randomly chosen partition boundaries to avoid the need for central control or distributed consensus. However, this approach actually doesn't work very well for databases, so it is rarely used in practice (the documentation of some databases still refers to consistent hashing, but it is often inaccurate).

> NOTE: Consistent here has nothing to with replica consistency or ACID consistency, but rather describes a particular approach to rebalancing. 

---

Q. Explain how **`Consistent Hashing`** works.

---

Q. Does the rebalancing happen automatically or manually?

Fully automated rebalancing can be convenient, because there is less operational work to do for normal maintenance. However, it can be unpredictable. Rebalancing is an expensive operation, because it requires rerouting requests and moving a large amount of data from one node to another. 

Such automation can be dangerous in combination with automatic failure detection. For example, say one node is overloaded and is temporarily slow to respond to requests. The other nodes conclude that the overloaded node is dead, and automatically rebalance the cluster to move load away from it. This puts additional load on the overloaded node, other nodes, and the network—making the situation worse and potentially causing a cascading failure.

For that reason, it can be a good thing to have a human in the loop for rebalancing. It’s slower than a fully automatic process, but it can help prevent operational surprises.

---

Q. Explain **`Service Discovery`**.

Answer to the question: **`When a client wants to make a request, how does it know which node to connect to?`

---

Q. Explain the property of **`Partition Tolerance`** in distributed systems.

 A requirement in distributed systems to ensure **availability** even when network links between nodes fail.

Achieved through **eventual consistency** (syncing data once the partition is resolved) and **retry mechanisms** (handling temporary network failures). ?????

**Example:** In a distributed database, if the network splits into two isolated parts (partition), each part should continue serving requests independently until the partition is resolved.

> **NOTE:** In a distributed system, partitions cannot be avoided, and when a partition occurs, we must choose between consistency and availability.

---

Q. Explain **`Consistency`**. 

 Systems often replicate data across multiple nodes, sometimes in real-time, to improve fault tolerance and performance. However, this replication introduces challenges in maintaining **data consistency**.

> **NOTE:** Data consistency is crucial for ensuring that all users and systems have access to the same, up-to-date information.

---

Q. Explain the property of **`Strong Consistency`** in distributed systems.

The system guarantees that as soon as a transaction is committed, all subsequent read operations from any user or node will reflect that latest write, regardless of which replica they access. 

This provides the strongest guarantee of consistency, but can potentially impact system performance due to synchronisation overhead.

Strong consistency is usually achieved by forcing a replica not to accept new reads / writes until every replica has agreed on current write.

> **NOTE:** This approach is not ideal for systems that require high availability (because it can block new operations).

---

Q. Explain the property of **`Eventual Consistency`** in distributed systems.

The system guarantees that all replicas of data **will eventually** converge to the same state, given enough time and in the absence of further updates. However, in the short term, different nodes may return stale or inconsistent data. 

Since updates don’t need immediate synchronisation across all nodes, systems can respond faster.

> **Example:** Imagine a social media platform where a user updates their profile picture. The change is first stored on one server, then gradually propagates to others. Some users may see the old picture until synchronisation completes, but eventually, all servers reflect the change.

---

Q. Explain **`CAP Theorem`**.

CAP theorem states that it is impossible for a distributed system to simultaneously provide more than two of these 3 guarantees: `consistency`, `availability` and `partition tolerance`.

In a distributed system, partitions cannot be avoided. When a partition occurs, we must choose between consistency and availability.

If we choose consistency over availability (CP), we must block all write operations to avoid data inconsistency among nodes (servers), which makes the system unavailable. For example, **Bank systems usually have extremely high consistent requirements.**

If we choose availability over consistency (AP), the system keeps accepting reads, even though it might return stale data.

---
## EXTRA

Q. Explain the concept of two-phase commit in caching.

---

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


