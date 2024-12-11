# Java Persistence API (JPA) Interview Questions

Q. What is JPA (Java Persistence API)?

Java Persistence API (JPA) is a standard specification in Java that defines a set of rules and interfaces for object-relational mapping (ORM) and data persistence. It allows developers to **automatically map Java objects (entities) to database tables** and **handle database operations without writing explicit SQL queries**.

---

Q. What is Hibernate?

Hibernate is a Java-based **Object-Relational Mapping (ORM) framework that implements JPA** and extends its functionality with additional features.

---

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

Q. Explain common JPA annotations.

1. **Entity Mapping:**

    - `@Entity`: Marks a class as an entity.
    - `@Table`: Specifies the table name (optional, defaults to class name).

2. **Field Mapping:**

    - `@Id`: Marks the primary key.
    - `@GeneratedValue`: Specifies how the primary key value is generated.
    - `@Column`: Customizes the column mapping.

3. **Relationships:**

    - `@OneToOne`, `@OneToMany`, `@ManyToOne`, `@ManyToMany`: Define relationships between entities.
    - `@JoinColumn`: Specifies the foreign key column.

---

Q. Explain the difference between `GenerationType.AUTO` and `GenerationType.IDENTITY`.

- `GenerationType.AUTO`: Allows the persistence provider (e.g., Hibernate) to automatically choose the best strategy for primary key generation based on the underlying database and JPA provider defaults. **The actual strategy chosen can vary depending on the database type and its capabilities**.

- `GenerationType.IDENTITY`: Explicitly instructs the database to generate the primary key value using an auto-increment column, where the database automatically generates the next available key for each new row. **This strategy requires that the underlying database supports auto-increment functionality**.

---

Q. Explain JPA relationships. 

---

Q. What is JPQL (Java Persistence Query Language)?

JPQL (Java Persistence Query Language) is a query language used to interact with relational databases in Java applications that use JPA (Java Persistence API). It allows developers to create queries using the entity model defined in their Java code, rather than using direct SQL queries on the database.

**NOTE:** JPQL is database-agnostic, meaning the same JPQL query should work across different relational databases as long as they are properly mapped with JPA.

```
Example: A basic JPQL query to find a movie by its title.

@Query("SELECT m FROM Movie m WHERE m.title = :title")
Movie findByTitle(@Param("title") String title);
```

---

Q. Will the following query: `SELECT DISTINCT m FROM Movie m JOIN m.shows s WHERE s.theatre.city = :city")` work if the `Movie` entity does not have a `List<Show> shows` field?

JPQL relies on the mappings defined in your JPA entities to construct queries. If `Movie` does not have a relationship with `Show` (e.g., `@OneToMany` with `List<Show>`), the path expression `m.shows` is invalid because JPQL cannot navigate to the `Show` entity from `Movie`.

---






