# Spring Data JPA Interview Questions

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