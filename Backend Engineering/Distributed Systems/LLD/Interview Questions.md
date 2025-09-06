# Low Level Design Interview Questions

Q. What is a Stateless Service?

A stateless service refers to a service that does not retain any information (state) about previous interactions or requests between executions. **Each request or operation is treated as independent and self-contained.**

> NOTE: By not holding mutable shared state, a stateless service avoids concurrency issues, making it **inherently thread-safe**.

---

Q. What should be the ideal scope of classes in Service and DAO layer?

The classes in both **Service** and **DAO** layer are typically designed to be stateless, so a **singleton scope is ideal**.

---

Q. How Instruction Reordering Works?

1. **Compiler Optimization:** The Java compiler may reorder instructions to reduce delays caused by dependencies, resource contention, or hardware limitations.

2. **CPU-Level Optimization:** Modern CPUs execute instructions out-of-order to maximize resource usage, such as overlapping memory loads and arithmetic computations.

3. **Memory Subsystem Reordering:** The memory model allows reads and writes to occur in an order different from the program's source code.

> NOTE: In a multithreaded environment, instruction reordering can create unexpected behavior because multiple threads may observe variables at different states.

---

Q. What is the role of `volatile` keyword in Singleton Pattern?

The volatile keyword prevents **instruction reordering** by guaranteeing:

- **Happens-before Relationship:** Writes to a volatile variable (like instance) happen before reads by any thread.

- **Memory Consistency:** All threads see the same value of the volatile variable at all times.

---

Q. Can we start a database transaction from the service layer?

Yes, it is generally acceptable to start a transaction from the service layer, and in many cases, it is considered a best practice. 

The service layer is a logical place to manage transactions because it encapsulates business logic and coordinates multiple DAO (Data Access Object) operations. 

Starting transactions at this level allows the business logic to dictate the boundaries of a transaction, ensuring consistency and atomicity across multiple database operations.

---

Q. Explain Concurrency Control.

Locks are managed at the database level, leading to contention as the number of concurrent transactions increases. Requires vertical scaling (e.g., more powerful DB servers), which has limits and costs.

Message Queue handles large volumes of requests by distributing messages across multiple consumers. Enables horizontal scaling by adding more consumer instances without overloading a central resource.

---






