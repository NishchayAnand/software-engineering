# Understanding Key-Value Databases

For performance reason, a short key works better.

Examples of key-value store include: `Amazon DynamoDB`, `Memcached`, `Redis`, etc.

Developing a key-value store that resides in a single server is easy. An intuitive approach is to store key-value pairs in a hash table, which keeps everything in memory. Even though memory access is fast, fitting everything in memory would be impossible due to space constraints.

Two optimizations that can be done to fit more data in a single server:

1. Data Compression
2. Store only frequently used data in memory and rest in disk.

## Data Partition

Even with these optimizations, a single server can reach its capacity very quickly. A distributed key-value store is required to support big data. Two challenges associated with partitioning data:

1. Distribute data across multiple servers evenly.
2. Minimize data movement when nodes (servers) are added or removed.

Consistent hashing is a great technique to solve these problems.

## Data Replication

To achieve high availability and reliability across distributed systems, data must be replicated asynchronously across N servers.

Nodes in the same data center often fail at the same time due to power outages, network issues, natural disasters, etc. For better reliability, replicas are placed in distinct data centers.

## EXTRA

Distributed key-value stores are classified based on the 2 CAP properties they support:

1. **CP (Consistency and Partition Tolerance) Systems**
2. **AP (Availability and Partition Tolerance) Systems**
3. **CA (Consistency and Availability) Systems:** Since network failure is unavoidable, a distributed system must tolerate network partition. Thus, a CA system cannot exist in real-world applications.

Choosing the right CAP guarantees that fit your use case is an important step in building a distributed key-value store.
