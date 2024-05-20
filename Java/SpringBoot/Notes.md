# Understanding SpringBoot

- In 2014, SpringBoot was launched.

- Based on Spring, it allows creation of standalone Spring apps aiming microservices.

- Spring Boot provides a lot of magic and assume a lot of default approaches (magic may be cumbersome when you don't want the default behavior).

- MicroProfile Specifications came up.

- Spring Boot made integrating Spring MVC very easy, allowing developers to simply code the business logic.

- Spring Boot handles the integration of Spring MVC and then it sets up the Jackson JSON library so that when we send the shipreck info across the HTTP connection, Spring Boot and Spring MVC are automatically marshalling the JSON into and out of the Java objects.

- Spring Boot automatically sets up View Resolvers, which determines how to respond based off the content type.

- Spring Boot can automatically configure and tell Spring MVC that is should serve out static resources that are located at the root of the classpath in the `static`, `public` or `resources` path.

- Spring Boot sets up some standard Spring MVC `HTTPMessageConverters` so that it can use sensible defaults to convert JSON objects into Java ones and vice-versa.

- Basic string encoding is set to UTF-8 out of the box by Spring Boot and Spring MVC.

- Spring Boot also automatically setup your datasaource pooling for you. For enterprise applications, having a strong connection pool can greatly improve your **database throughout** and performance (`tomcat-jdbc` is the default pooling strategy used by Spring Boot as it provides good performance and concurrency out of the box).

- `Hibernate` act as the EntityManager.

- **Even though we can do a lot of configuration in the Spring Boot properties in application properties file, we may find a need to do some configuration for your application that falls outside of the auto-configuration options.**

## Application Properties

Spring Boot provides an easy way to handle environment configuration changes as you move your application from one environment to another.

- `application.properties`: Spring Boot will load it to apply any property configurations to your application when your application starts up. Can be placed at the root of your classpath at `src/main/resources` folder.

- `application.yml`: SpringBoot will accept YAML files if you have **SnakeYAML** dependency on your classpath.

- `application-{profile}.properties`: Additional properties file that have profile embedded in the name of the file. For example, we can create `application-dev.properties` file that has development environment specific configuration in it. These profile-specific property files will be loaded over the main application properties file and any environment-specific properties will be overridden and set for that particular environment.

## Major Spring Boot Dependencies

- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`

## Major Annotations used in Spring Boot

- `@RestController`
- `@RequestBody`
- `@RequestMapping`
- `@PathVariable`

## How to provide custom configuration with Spring Boot?

Any configuration Java class that has public methods with the `@Bean` annotation gets loaded on app startup and the return values of these methods will theh be set as beans inside the Spring context.

```
@Configuration
public class PersistenceConfiguration {

    @Bean // --> tell Spring and Spring Boot that the return value of this method, which is a DataSource needs to be setup and stored as a Spring bean in the Spring context.

    @ConfigurationProperties(prefix="spring.datasource") // --> tells the DataSourceBuilder to use the connection and pooling properties located in the application.properties file where the properties began with the "spring.datasource" prefix.

    @Primary // tells Spring Boot to use this datasource as the primary data source if there's ever any ambiguity when wiring up a DataSource in the application.

    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

}
```
