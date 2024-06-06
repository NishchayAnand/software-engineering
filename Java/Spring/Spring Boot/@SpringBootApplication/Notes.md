# Understanding @SpringBootApplication in Spring Boot

`@SpringBootApplication` is composite annotation that combines three crucial annotations: `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`. This single annotation can be used to set up a Spring Boot application with minimal configuration.

```
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class, args);
    }
}
```
