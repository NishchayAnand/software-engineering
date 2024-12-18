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

Q. How does Spring Boot support database initialization?

Spring Boot can automatically run **.sql** files placed in the **resources** folder to initialize or populate your database.

These files are typically named as follows:

- **schema.sql**: Used for creating database schema, such as tables or indexes.
- **data.sql**: Used for inserting data into tables (initialization data).

> NOTE: By default, this feature is enabled when you use an embedded database (e.g., H2, HSQLDB). For external databases, you need to enable it explicitly.

---

Q. Explain `spring.jpa.database-platform=org.hibernate.dialect.H2Dialect` property.

Hibernate, the JPA implementation used in Spring Boot, requires a dialect to translate Java Persistence Query Language (JPQL) or HQL into database-specific SQL.

---


