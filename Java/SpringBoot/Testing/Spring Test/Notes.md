# Understanding Spring Test

Spring Boot provides robust testing support that makes it easy to write and run tests for your application.

Different types of tests you can write in a Spring Boot application include:

## Unit Testing

Unit tests focus on testing individual components in isolation.

The main tools for unit testing in Spring Boot are `JUnit` and `Mockito`.

- `spring-boot-starter-test`: Provides all the essential libraries for testing Spring Boot applications.

## Integration Testing

Integration tests ensure that different parts of your application work together as expected.

Use `@SpringBootTest` to load the full application context.
