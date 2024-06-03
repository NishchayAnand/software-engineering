# Understanding Profiles in Spring Boot

Allows you to have different sets of configurations (like database connections, logging levels, bean creation) based on where your application is running (development, testing, production, etc.).

## Creating Profiles

Simply create separate properties files for each profile, named following the convention `application-{profile}.properties` (e.g., application-dev.properties, application-test.properties).

Use the `@Profile` annotation on a **bean** class or **configuration** class to specify when that bean or configuration should be loaded.

Spring Boot will automatically load the properties for the active profile(s).

For example,

```
@Configuration
@Profile("dev")
public class DevConfig {
    // Development-specific configurations
}
```

## Activating Profiles

Set the `-Dspring-boot.run.profiles = {profile}` to activate `{profile}` when running your Spring Boot application using the `spring-boot:run` Maven command: For example,

```
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

Here,

- `mvn spring-boot:run` tells Maven to run the **spring-boot:run** goal of **Spring Boot Maven Plugin,** which starts your application.
- `-Dspring.run.profiles=dev` sets the **spring.profiles.active** property for the running application instance.

> **_NOTE:_** This approach overrides any `spring.profiles.active` property defined within your application's `application.properties` file.
