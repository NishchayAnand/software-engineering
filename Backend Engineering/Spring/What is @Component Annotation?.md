
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