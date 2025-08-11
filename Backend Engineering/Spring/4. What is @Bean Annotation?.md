
The **`@Bean`** annotation is used to explicitly declare a **bean** in the application context from within a Java configuration class.

It’s applied to a **method** inside a class annotated with `@Configuration`. The method’s return value is **registered as a Spring bean**.

**Example**

```
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public EmailService emailService() {
        return new EmailService(); // This object will be managed by Spring
    }
}
```

> **NOTE:** The default bean name is the method name.

---
