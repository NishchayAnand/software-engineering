# SpringBoot Interview Questions

Q. What is the use of `@SpringBootApplication` annotation?



---

Q. Explain `SpringApplication.run(MySpringBootApplication.class, args);`



---

Q. What is the use of `application.properties` file?

The `application.properties` file in a Spring Boot project is used to define configuration properties for your application. 

It is a central place to configure settings such as database connections, server port, logging levels, and other application-specific configurations. Spring Boot automatically loads this file when the application starts and applies the properties to the appropriate components.

---

Q. What are Profiles?

**Profiles** allow you to define different sets of configuration properties to handle environment-specific settings without hardcoding them into your application.

You can have multiple configuration files (e.g., `application-dev.properties`, `application-prod.properties`) to separate properties based on the environment.

> **NOTE**: You can specify the active profile using the command-line argument: `spring.profiles.active` or, can set it in the `docker-compose.yml` using the `SPRING_PROFILES_ACTIVE` environment variable.

---
