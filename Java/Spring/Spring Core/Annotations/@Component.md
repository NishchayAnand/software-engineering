# Understanding @Component Annotation in Spring

The `@Component` annotation is a generic stereotype annotation that can mark any plain old Java object (POJO) as a Spring component.

> **NOTE:** A Stereotype annotation is a special type of annotation used to define the role and purpose of a Java class within an application.

Spring can scan for classes annotated with `@Component` and automatically register them as Spring beans.

## Sample Code

```
import org.springframework.stereotype.Component;

@Component
public class MyComponent {
    // Class implementation
}
```
