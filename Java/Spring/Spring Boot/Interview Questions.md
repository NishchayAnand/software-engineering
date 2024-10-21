# Interview Questions

**Q. Explain `@SpringBootApplication` annotation.**

`@SpringBootApplication` enables **component-scanning** and **auto-configuration**. It is a composite annotation that combines three crucial annotations:

1. **Spring's `@Configuration`:** Designates a class as a configuration class using Spring's Java-based configuration.

2. **Spring's `@ComponentScan`:** Enables component-scanning so that components you write will be automatically discovered and registered as beans in the Spring Application Context.

3. **Spring Boot's `@EnableAutoConfiguration`:** This humble little annotation might as well be named **@abracadabra** because it's the one line of configuration that enables the magic of Spring Boot auto-configuration, i.e., automatically configuring beans and settings based on the dependencies present in the project. This one line keeps you from having to write the pages of configuration that would be required otherwise.

---

**Q. Explain starter dependencies.**

**Q. Explain `SpringApplication.run(MySpringBootApplication.class, args);`**

The `SpringApplication.run(MySpringBootApplication.class, args)` method is used to launch the Spring Boot application. Here's a detailed breakdown of what actually happens:

1. Initializes an **ApplicationContext**. 

2. Scans the base package (and its sub-packages) where **MySpringBootApplication.class** is located for components (like `@Controller`, `@Service`, `@Repository`, `@Component`, etc.) and registers them in the **ApplicationContext**.

3. Scans the classpath and applies default configurations based on the dependencies. For example, if `spring-boot-starter-web` is present, it configures an embedded web server.

4. Blocks the main thread so that the application continues running, serving requests if it's a web application, or processing tasks if it's a standalone application.

NOTE: If your application is a web application and you have included the `spring-boot-starter-web` dependency, Spring Boot will start an embedded web server (like Tomcat or Jetty) to serve the application.

---

**Q. What is `JpaRepository` in Spring Data JPA?**

JpaRepository offers methods for basic Create, Read, Update, and Delete (CRUD) operations on your entities.

- **save(entity):** Persists a new entity or updates an existing one.
- **findById(id):** Retrieves an entity by its ID.
- **findAll():** Fetches all entities of a particular type.
- **deleteById(id):** Deletes an entity by its ID.

Additional methods exist for variations like `saveAll()`, `delete(entity)`, etc.

---

**Q. Give few annotations provided by JPA for entity fields validations?**

JPA doesn't provide its own annotations for entity field validation. However, it integrates seamlessly with Bean Validation (JSR 380) for defining constraints on your entity fields. Here are some commonly used Bean Validation annotations for JPA entity field validations:

---

**Q. What does the following command do: `mvn spring-boot:run`?**

This goal, provided by the Spring Boot Maven Plugin, is specifically designed for running Spring Boot applications directly from the command line. It takes care of setting up the classpath, environment, and starting your application.
