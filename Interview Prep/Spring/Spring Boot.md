# SpringBoot Interview Questions

Q. What is the use of `@SpringBootApplication` annotation?

The `@SpringBootApplication` annotation is a key annotation in Spring Boot that **marks a class as the main configuration class and entry point for a Spring Boot application**. It is a composite annotation that combines three crucial annotations:

- `@EnableAutoConfiguration`: Part of SpringBoot framework. **Automatically configures the Spring application context based on the dependencies on the classpath**. For example, if **spring-boot-starter-web** is on the classpath, it configures a web application context.

- `@Configuration`: Part of Spring framework. **Automatically scans the package where the annotated class is located** and its sub-packages for Spring components (@Component, @Service, @Repository, @Controller, etc.) to **register them as beans in the Spring application context**.

- `@ComponentScan`: Part of Spring Framework. **Indicates that the class contains Spring bean definitions**.

> **NOTE:** The `@SpringBootApplication` annotation simplifies configuration in a Spring Boot project by eliminating the need to declare these annotations individually. 

---

Q. What is the use of `application.properties` file?

The `application.properties` file in a Spring Boot project is used to define configuration properties for your application. 

It is a central place to configure settings such as database connections, server port, logging levels, and other application-specific configurations. Spring Boot automatically loads this file when the application starts and applies the properties to the appropriate components.

---

Q. Explain `@ExceptionHandler` annotation.