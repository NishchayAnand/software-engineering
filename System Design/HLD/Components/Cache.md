# Understanding Cache

A Cache is a **temporary storage area** that **stores the result of expensive responses** or frequently accessed data in memory so that sequent requests are served more quickly.

> **NOTE:** The application performance is greatly affected by calling the database repeatedly.

Consider using Cache when data is read frequently but modified infrequently.

It's a good practice to implement an expiration policy. Once the data is expired, it is removed from the cache. When there is no expiration policy, cached data will be stored in the memory permanently. It is advisable **not to make the expiration data too short** as this will cause the system to reload data from the database top frequently. Meanwhile, it is advisable **not to make the expiration data too long** as the data can become stale.

> **NOTE:** If a cache server starts, all the data in memory is lost.

Once the cache is full, any requests to add items to the cache might cause existing items to be removed. This is called cache eviction. **Least-Recently-used (LRU)** is the most popular cache eviction policy.

## How does the Cache Tier works?

After receiving a request, a web server first checks if the cache has the available response. If it has, it sends data back to the client. If not, it queries the database, stores the response in cache, and sends it back to the client. This cache strategy is called **read-through cache**.

> **NOTE:** Interacting with cache servers is simple because most cache servers provide APIs for common programming languages.

## How to handle Inconsistency?

Inconsistency can happen because data-modifying operations on the data store and cache are not in a single transaction.
