Master-slave mode of replication is a built-in feature of many relational databases. However, it is also used in some non-relational databases, including MongoDB. 

Leader-based replication is not limited to databases. Distributed message brokers such as Kafka and RabbitMQ also use it. 

> NOTE: Normally, replication is quite fast. Most database systems apply changes to followers in less than a second. 

---
## Write-Ahead Log (WAL) Shipping

---
## Logical (Row-Based) Log Replication

---
## Trigger-Based Replication

---

Single-node transactions have existed for a long time. However, in the move to distributed (replicated and partitioned) databases, many systems have abandoned them, claiming that transactions are too expensive in terms of performance and availability, and asserting that eventual consistency is inevitable in a scalable system.

Leader-based replication has one major downside: there is only one leader, and all writes must go through it.iv If you can’t connect to the leader for any reason, for example due to a network interruption between you and the leader, you can’t write to the database.

A natural extension of the leader-based replication model is to allow more than one node to accept writes. Replication still happens in the same way: each node that processes a write must forward that data change to all the other nodes. We call this a multi-leader configuration (also known as master–master or active/active replication).

---
## Multi-leader Replication

Have a leader in each data centre. Within each data centre, regular leader-follower replication is used. 

**Use case 1:** 

If you have an application that needs to continue to work while it is disconnected from the internet.

For example, consider the calendar apps on your mobile phone, your laptop, and other devices. You need to be able to see your meetings (make read requests) and enter new meetings (make write requests) at any time, regardless of whether your device currently has an internet connection. 

If you make any changes while you are offline, they need to be synced with a server and your other devices when the device is next online.

In this case, every device has a local database that acts as a leader (it accepts write requests), and there is an asynchronous multi-leader replication process (sync) between the replicas of your calendar on all of your devices. 

> **NOTE: From an architectural point of view, this setup is essentially the same as multi-leader replication between data centres, taken to the extreme: each device is a “datacenter,” and the network connection between them is extremely unreliable.**

**Use Case 2:**

Real-time collaborative editing applications allow several people to edit a document simultaneously.

If you want to guarantee that there will be no editing conflicts, the application must obtain a lock on the document before a user can edit it. If another user wants to edit the same document, they first have to wait until the first user has committed their changes and released the lock. This collaboration model is equivalent to single-leader replication with transactions on the leader.

However, for faster collaboration, you may want to make the unit of change very small (e.g., a single keystroke) and avoid locking. This approach allows multiple users to edit simultaneously, but it also brings all the challenges of multi-leader replication, including requiring conflict resolution.

---














