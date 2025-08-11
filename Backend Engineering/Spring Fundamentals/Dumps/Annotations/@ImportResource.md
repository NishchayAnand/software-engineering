# Understanding @ImportResource Annotation

When you use the `@ImportResource` annotation, Spring will load the specified XML configuration files and include the beans defined in those files in the application context. This **provides a seamless way to integrate existing XML configurations with new Java-based configurations.**

```
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:beans.xml")
public class AppConfig {
    // Other bean definitions can go here
}
```
