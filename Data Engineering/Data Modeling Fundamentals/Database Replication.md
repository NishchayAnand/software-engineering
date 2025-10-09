# Understanding Database Replication

Database replication can be used in many database management systems, usually with a **master/slave** relationship between the **original (master)** and the **copies (slaves)**.

**A master database generall supports write operations.** All the data-modifying commands like `insert`, `delete`, or `update` must be sent to the master database.

**A slave database gets copies of the data from the master database and only supports read operations.** Most applications require a much higher ratio of reads to writes, thus, the number of slave databases in a system is usually larger than the number of master databases.

## Advantages of Database Replication

1. **Better Performance:** In the master-slave model, all writes and updates happen in master nodes, whereas, read operations are distributed across slave nodes. This model improves performance because it allows more queries to be processed in parallel `(?)`.

2. **Reliability:** If one of your database servers is destroyed by a natural disaster, such as an earthquake, data is still preserved. You do not need to worry about data loss because data is replicated across multiple locations.

3. **High Availability:** By replicating data across different locations. your website remains in operation even if a database is offline as you can access data stored in another database server.

---

## EXTRA

If the master database goes offline, a slave database will be promote to be the new master. In production systems, promoting a new master is more complicated as the data in a slave database might not be up to date.
