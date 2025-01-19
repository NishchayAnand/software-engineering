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

Q. Explain `spring.jpa.hibernate.ddl-auto` property.

The `spring.jpa.hibernate.ddl-auto` property in Spring Boot configures the behaviour of Hibernate with regard to **DDL (Data Definition Language) generation**. 

It controls whether Hibernate should automatically create, update, or validate the database schema when the application starts.

**Possible values:**

1. `none`: Hibernate does not manage the database schema at all. You must create and manage the schema manually.

2. `validate`: Hibernate checks that the database schema matches the entities in the code but does not make any changes. If the schema does not match the entities, an exception is thrown.

3. `update`: Hibernate updates the schema to match the entity definitions, but it does not drop any existing data.

4. `create`: Hibernate drops the existing schema (if any) and creates a new schema based on the entities in the code.

5. `create-drop`: Hibernate creates the schema when the application starts and drops it when the application stops.

---

Q. What is the `spring.jpa.database-platform` property?

Different databases have different SQL syntaxes and features. For example, PostgreSQL uses `SERIAL` for auto-increment fields, while MySQL uses `AUTO_INCREMENT`. The way **dates**, **joins**, and **native queries** are handled also varies between databases. 

The `spring.jpa.database-platform` property ensures Hibernate generates SQL that works correctly with your database.

---

Q. Explain `spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect` property.

The property **`spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect`** is used in **Spring Boot** to specify the Hibernate dialect for a MySQL database.  This ensures that Hibernate generates SQL that is compatible with MySQL’s syntax and capabilities.

> NOTE: A dialect is a configuration that tells Hibernate how to translate Java-based queries (HQL or JPQL) into SQL specific to the database you are using.

---

Q. How does Spring handle database exceptions?

Spring's `JpaRepository` catch `SQLExceptions` and wrap them in `DataAccessException` (a **runtime exception**). This approach simplifies exception handling by allowing you to focus on business logic rather than low-level database issues.

For example, if there is a database connection error or constraint violation, Spring would throw a `DataAccessException`, not a `SQLException`, making your code cleaner and easier to manage.

---

Q. Explain `@Transactional` annotation.


