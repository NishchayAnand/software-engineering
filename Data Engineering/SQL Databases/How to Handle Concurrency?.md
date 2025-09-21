
---
### Pessimistic Locking

Prevents simultaneous updates by placing a lock on a record as soon as one user starts to update it. 

Other users who attempt to update the record have to wait until the first user has released the lock (committed the changes).

`SELECT ... FOR UPDATE` 

**Pros:**

It is easy to implement and it avoids conflict by serializing updates. Pessimistic locking is useful when data contention is heavy. 

**Cons:**

Deadlocks may occur when multiple resources are locked. Writing deadlock-free application code could be challenging.

**This approach is not scalable. If a transaction is locked for too long, other transactions cannot access the resource.** This has a significant impact on database performance, especially when transactions are long-lived or involved a lot of entities.

---
### Optimistic Locking

It allows multiple concurrent users to attempt to update the same resource.

Two ways to implement:
1. Version number
2. timestamp

Version number is considered better because the server clock can be inaccurate over time.

**Version Number**

A column called `version` is added to the database table. 

Before user modifies a database row, the application reads the version number of the row. When user updates the row, the application increases the version number by 1 and writes it back to the database. 

A database validation check is put in place. The next version number should exceed the current version number by 1. The transaction aborts if the validation fails and the user tries again.

**Optimistic locking is usually faster than pessimistic locking because we do not lock the database. However, the performance of optimistic locking drops dramatically when concurrency is high.**

Consider the case when may users try to reserve a hotel room at the same time. Because there is no limit on how many users can read the available room count, all of them read back the same available room count and the current version number. When different users make reservations and write back to the database, only one of them will succeed, and the rest of the clients receive a version check failure message. The clients have to retry. In the subsequent round of retries, there is only one successful client again, and the rest have to retry. Although the end result is correct, the repeated retries cause a very unpleasant user experience.

**Pros:**

There's actually no locking from the database point of view. It's entirely up to the application to handle the logic with the version number.

**Optimistic locking is generally used when data contention is low. When conflicts are rare, transactions can complete without the expense of managing locks.** 

**Cons:**

Performance is poor when data contention is heavy. 

---
### Database Contraints

This approach is very similar to optimistic locking.

```
CONSTRAINT check_room_count CHECK((total_rooms - reserved_rooms >= 0))
```

**Pros:**

Easy to implements. Works well when data contention is minimal.

**Cons:**

Similar to optimistic locking, when data contention is heavy, it can result in a high volume of failures. Users could see there are rooms available, but when they try to book one, they get the "no rooms available" response. The experience can be frustrating to users.

The database constraints cannot be version-controlled easily like the application code. 

Not all databases support constraints. It might cause problems when we migrate from one database solution to another.

---










