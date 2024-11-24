# Low Level Design Interview Questions

Q. What is DAO layer?

A DAO layer, or Data Access Object layer, is an architectural pattern that **separates the database access logic from the business logic** in an application.

The DAO allows data access mechanisms to change independently of the code that uses the data.

---

Q. Difference between DAO and DTO.

**DAO** is a design pattern used to abstract and encapsulate all access to a data source (like a database). 

**DTO** is an object used to transfer data between layers. It allows us to control and limit the information that is exposed or transferred between different layers or components of an application.

---

Q. Difference betwen DAO and Repository.

The DAO (Data Access Object) and Repository are both design patterns used in software development to manage data access and interaction with the database. However, they serve slightly different purposes:

- `DAO`: Low-level abstraction, close to the database. Exposes operations like **save()**, **update()**, **delete()**, and **find()**.

- `Repository`: High-level abstraction, closer to the domain logic. Exposes operations like **findUsersByAge()**, **getActiveAccounts()**, etc., which are meaningful in the context of business logic.

---

Q. What is a Stateless Service?

A stateless service refers to a service that does not retain any information (state) about previous interactions or requests between executions. **Each request or operation is treated as independent and self-contained.**

> NOTE: By not holding mutable shared state, a stateless service avoids concurrency issues, making it **inherently thread-safe**.

---

Q. What should be the ideal scope of classes in Service and DAO layer?

The classes in both **Service** and **DAO** layer are typically designed to be stateless, so a **singleton scope is ideal**.

---

Q. What is the role of `final` keyword in Singleton Pattern?

Declaring the instance variable as `final` ensures that the singleton instance cannot be reassigned once initialized. This guarantees that the same instance is used throughout the application's lifecycle.

> NOTE: Any object assigned to a `final` variable is fully constructed before being visible to other threads (due to Java's memory model). Hence, it is typically used for **eager initialization, where the singleton instance is created at class-loading time**.

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







