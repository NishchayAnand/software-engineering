
The **`@Component`** annotation is a **stereotype annotation** used to mark a Java class as a **Spring-managed component (bean)**.

When you annotate a class with `@Component`, you’re telling Spring’s component-scanning mechanism: <span style="color:green;font-weight:bold;background:beige;">"Please detect this class automatically and register it as a bean in the application context"</span>. This eliminates the need for explicit bean definitions in XML or `@Bean` methods.

**Example** 

```
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    public void sendEmail(String to, String message) {
        System.out.println("Email sent to " + to + ": " + message);
    }
}
```

> **NOTE:** You enable component scanning with `@SpringBootApplication` or `@ComponentScan` annotation.

---

<span style="color:red;font-weight:bold">Q. Can</span> `@Component` <span style="color:red;font-weight:bold">annotation be applied to an interface?</span>

<span style="color:green;font-weight:bold;">A:</span> No, you **shouldn’t** annotate an interface with `@Component` in Spring. 

<span style="color:green;font-weight:bold;">Explanation:</span> Interfaces cannot be instantiated directly, so if you put `@Component` on an interface, Spring will detect it but won’t be able to create a bean unless there’s **some special mechanism** (like a dynamic proxy or custom factory) that provides an implementation.

---

<span style="color:red;font-weight:bold">Q. How can you override the default bean name in the below code snippet?</span>

```
import org.springframework.stereotype.Component;

@Component
public class EmailService {
    public void sendEmail(String to, String message) {
        System.out.println("Email sent to " + to + ": " + message);
    }
}
```

<span style="color:green;font-weight:bold;">A:</span>

The default bean name is the class name with first letter lowercase (`EmailService` → `emailService`).

You can customize the default bean name as follows:

```
@Component("customEmailService")
public class EmailService { ... }
```

---

<span style="color:red;font-weight:bold">Q. In a Spring application, you have the following setup:</span>

```
@Configuration
public class AppConfig {

    @Bean
    public EmailService emailService() {
        return new EmailService();
    }
}
```

```
@Component
public class EmailService {
    public void send(String to) { ... }
}
```

<span style="color:red;font-weight:bold">Both definitions are detected by Spring’s component scanning and configuration processing. What happens when the application context starts?</span>

<span style="color:green;font-weight:bold;">A:</span> By default, Spring will fail at startup if two beans with the same name exist and bean definition overriding is disabled (default behavior in Boot is `false` for `spring.main.allow-bean-definition-overriding`).

> **NOTE:** If overriding is allowed, the later definition (in processing order) replaces the earlier one.

---
