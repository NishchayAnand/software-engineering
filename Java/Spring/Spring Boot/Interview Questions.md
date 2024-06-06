# Interview Questions

**Q1. What does the following command do: `mvn spring-boot:run`?**

This goal, provided by the Spring Boot Maven Plugin, is specifically designed for running Spring Boot applications directly from the command line. It takes care of setting up the classpath, environment, and starting your application.

---

**Q2. What is `JpaRepository` in Spring Data JPA?**

JpaRepository offers methods for basic Create, Read, Update, and Delete (CRUD) operations on your entities.

- **save(entity):** Persists a new entity or updates an existing one.
- **findById(id):** Retrieves an entity by its ID.
- **findAll():** Fetches all entities of a particular type.
- **deleteById(id):** Deletes an entity by its ID.

Additional methods exist for variations like `saveAll()`, `delete(entity)`, etc.

---

**Q3. Give few annotations provided by JPA for entity fields validations?**

JPA doesn't provide its own annotations for entity field validation. However, it integrates seamlessly with Bean Validation (JSR 380) for defining constraints on your entity fields. Here are some commonly used Bean Validation annotations for JPA entity field validations:

---

**Q4. Explain `SpringApplication.run(MySpringBootApplication.class, args);`**

When you run the application with `SpringApplication.run(MySpringBootApplication.class, args);`, the following steps occur:

1. **Bootstrapping the Application:** Spring Boot initializes the application context. The `@Configuration` annotated class registers the beans.

2. **Auto-Configuration:** Spring Boot scans the classpath and applies default configurations based on the dependencies. For example, if `spring-boot-starter-web` is present, it configures an embedded web server.

3. **Component Scanning:** Spring Boot scans the package and its sub-packages for `components`, `services`, `repositories`, and `controllers` and registers these components in the application context.

---
