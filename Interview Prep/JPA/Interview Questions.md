# Java Persistence API (JPA) Interview Questions

Q. What is an Entity?

An Entity represents a real-world object or concept that has a distinct identity and is typically mapped to a row in a database table. This mapping can be done manually or with an ORM (Object-Relational Mapping) tool.

> NOTE: Each entity instance is uniquely identifiable, typically using a primary key (e.g., id in a database).

---

Q. Explain DTO (Data Transfer Object).

A Data Transfer Object (DTO) is a plain object designed to carry data between layers or across systems. It is not tied to any database or persistence logic and typically lacks behavior (i.e., it only contains getters and setters).

> NOTE: A DTO simply holds data and doesn’t require a unique identifier (e.g., a primary key).

---

Q. Explain DAO (Data Access Object) pattern.

The Data Access Object (or DAO) pattern is a structural design pattern used to separate a data resource's client interface from its data access mechanisms. This allows data access mechanisms to change independently of the code that uses the data.

> NOTE: DAO can be used when working with a simple application or when direct database operations are the primary concern (ideal for small-scale projects or when the complexity of domain logic is low).