# Spring Data JPA Interview Questions

Q. What is Spring Data JPA?

Spring Data JPA is a module of the Spring Data project, built on top of JPA and Hibernate (or any other JPA implementation), making it easier to develop robust and database-independent data access logic in Spring applications.

---

Q. Explain key features provided by Spring Data JPA.

1. Provides repository interfaces like `JpaRepository` and `CrudRepository` that include pre-defined methods for common database operations (e.g., save, delete, find, etc.), eliminating the need for boilerplate code. 

2. Supports **query derivation**, i.e., methods in repositories can automatically generate queries based on their names.

3. Supports the use of custom `JPQL` or native SQL queries using the `@Query` annotation.

> NOTE: Spring Data JPA eliminates boilerplate code by **dynamically generating proxy instances of the repository interface at runtime**, allowing developers to focus on business logic.

---

Q. What is Domain-Driven Design?

Domain-Driven Design is a methodology and set of principles for designing complex software applications that are closely aligned with the core business domain. The key idea behind DDD is that software should be based on an in-depth understanding of the business, and the design should reflect that understanding.

---

Q. Explain Repository pattern.

The Repository Pattern is a design pattern that acts as a mediator between the application and the data access layer, providing an abstraction for querying and persisting objects. 

> NOTE: The repository pattern aligns closely with the domain layer, enabling the application to work with domain objects instead of raw database entities.

---

Q. Explain the difference between Repository and DAO (Data Access Object) pattern.

The choice between using a repository or a DAO depends on the specific responsibilities you want to handle. Here's a breakdown to help decide:

- **DAO (Data Access Object)**: If your application has a simpler structure, where the domain logic closely interacts with the database schema without much abstraction, simply using DAO should suffice.

- **Repository**: If your application deals with complex business problems, using Repository simplify the domain logic, making it easier to focus on business processes without getting bogged down by the intricacies of data access.

> NOTE: In a modern Spring Boot application, especially when using JPA or Spring Data, repositories are the preferred abstraction.

---

Q. Explain `@Param` annotation.

In Spring Data JPA, the `@Param` annotation is used to **bind method parameters to named parameters in JPQL or native SQL queries**. This helps improve query readability and provides a way to inject method arguments into the query dynamically.

> NOTE: The `@Param` annotation is not a standard JPA or Hibernate annotation. 

---

Q. Explain Spring Boot Database Initialization feature.

Spring Boot can automatically run **.sql** files placed in the **resources** folder to create the schema (DDL scripts) of your DataSource and initialize it (DML scripts).

Three primary SQL files used by Spring Boot to support database initialization include: 

1. `schema.sql`: Used to define the database schema. Executed first in the initialization process, before Hibernate starts schema generation or any other data loading.

2. `data.sql`: Used to insert data into the database. Executed after `schema.sql` but before Hibernate initializes the schema (if Hibernate is configured for schema management). This can lead to timing issues if you're relying on Hibernate to create tables.

3. `import.sql`: A special file intended to populate the database after Hibernate has created the schema. This file is executed only when Hibernate is responsible for schema generation.

---

Q. How does Spring handle database exceptions?

Spring's `JpaRepository` catch `SQLExceptions` and wrap them in `DataAccessException` (a **runtime exception**). This approach simplifies exception handling by allowing you to focus on business logic rather than low-level database issues.

For example, if there is a database connection error or constraint violation, Spring would throw a `DataAccessException`, not a `SQLException`, making your code cleaner and easier to manage.

---

Q. Explain `@Transactional` annotation.


