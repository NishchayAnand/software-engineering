# Understanding @SpringBootApplication Annotation in Spring Boot

`@SpringBootApplication` enables Spring **component-scanning** and Spring **auto-configuration**. It is actually a composite annotation that combines three crucial annotations:

1. Spring's `@Configuration`: Designates a class as a configuration class using Spring's Java-based configuration.

2. Spring's `@ComponentScan`: Enables component-scanning so that the web controller classes and other components you write will be automatically discovered and registered as beans in the Spring Application Context.

3. Spring Boot's `@EnableAutoConfiguration`: This humble little annotation might as well be named **@abracadabra** because it's the one line of configuration that enables the magic of Spring Boot auto-configuration. This one line keeps you from having to write the pages of configuration that would be required otherwise.

> **NOTE:** In older versions of Spring Boot, you'd have annotated the `Application.java` class with all three of these annotations. But since Spring Boot 1.2.0, `@SpringBootApplication` is all you need.

Here's a sample code using `@SpringBootApplication` annotation.

```
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

Passing the reference of `Application` class to `SpringApplication.run()`, along with the command-line arguments, will kick off the application.

You'll almost never need to change `Application.java` file. If your application requires any additional Spring configuration beyond what Spring Boot auto-configuration provides, it's usually best to write it into separate `@Configuration` configured classes (will be picked up by component-scanning).
