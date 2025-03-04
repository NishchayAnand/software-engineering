# Cassandra System Design

Key Functional Requirements:
- put(key, value)
- get(key)

The value in a key-value can be strings, lists, objects, etc. 

The value is usually treated as an opaque object in key-value stores.

Designing a key-value store that resides in a single server is easy. Store key-value pairs in a hash table, which keeps everything in memory.

Optimisations can be done to store more data in a single server:
- Data Compression
- Store only frequently used data in memory and the rest on disk.

A distributed key-value store is required to store big data.

In distributed systems, data is usually replicated multiple times. 

Non-Functional Requirement
- **Automatic scaling:** Solved through the concept of Consistent Hashing
- **Eventual Consistency**

From current writes, eventual consistency allows inconsistent values to enter the system.



