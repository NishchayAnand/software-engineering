# Understanding @Import Annotation

The `@Import` annotation in Spring is used to import additional configuration classes into the current application context.

This annotation is useful for **modularizing** and organizing your configuration by **separating different parts of your configuration into distinct classes, which can then be imported as needed**.

## How @Import Works?

When you use the `@Import` annotation, Spring will include the specified configuration classes, effectively combining them with the current configuration. This allows beans defined in the imported classes to be available in the application context.

```
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DataSourceConfig.class)
public class AppConfig {
    // Other bean definitions can go here
}
```

You can import multiple configuration classes by listing them in the `@Import` annotation.

```
@Import({ DataSourceConfig.class, AnotherConfig.class })
```
