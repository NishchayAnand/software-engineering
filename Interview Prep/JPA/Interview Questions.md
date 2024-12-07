# Java Persistence API (JPA) Interview Questions

Q. Explain DAO (Data Access Object) pattern.

The Data Access Object (or DAO) pattern is a structural design pattern used to separate a data resource's client interface from its data access mechanisms. This allows data access mechanisms to change independently of the code that uses the data.

> NOTE: DAO can be used when working with a simple application where complexity of domain logic is low, i.e., when direct database operations like CRUD (Create, Read, Update, Delete) are the primary concern. 

---

Q. Explain DTO (Data Transfer Object).

A Data Transfer Object (DTO) is a plain object designed to carry data between layers or across systems. It is not tied to any database or persistence logic and typically lacks behavior (i.e., it only contains getters and setters).

> NOTE: A DTO simply holds data and doesn’t require a unique identifier (e.g., a primary key).

---

Q. What is an Entity?

An Entity represents a real-world object or concept that has a distinct identity and is typically mapped to a row in a database table. This mapping can be done manually or with an ORM (Object-Relational Mapping) tool.

> NOTE: Each entity instance is uniquely identifiable, typically using a primary key (e.g., id in a database).

---

Q. What is an EntityManager?

An EntityManager is responsible for managing the lifecycle of entities (domain objects that are mapped to database tables).

---

Q. What is a Persistance Context?

The EntityManager maintains a persistence context (essentially a cache or memory area) during a transaction. 

The persistence context keeps track of the state of entities (new, managed, detached, or removed). The entities in the persistence context are synchronized with the database when the transaction is committed.

> NOTE: The persistence context is created when the EntityManager is instantiated. In a Spring Boot application, this typically happens with each HTTP request (if using Spring's `@Transactional` support).

---

Q. What is an EntityManagerFactory?

EntityManager is closely tied to a specific transaction. Each EntityManager typically represents a unit of work (a single transaction).

A single EntityManager instance cannot be shared safely across multiple threads. Each thread that requires interaction with the database (such as saving or updating an entity) needs its own EntityManager instance to ensure thread safety.

An EntityManagerFactory is responsible for creating EntityManager instances.

> NOTE: In a Spring Boot application, Spring automatically configures and manages the EntityManagerFactory, so you typically don’t need to create it manually.

---

Q. What is Hibernate?



