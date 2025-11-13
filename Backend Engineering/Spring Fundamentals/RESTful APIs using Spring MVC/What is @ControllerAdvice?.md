
 It helps you handle exceptions, bind global data, and apply logic across multiple controllers in one centralized place.

**It is part of Spring MVC and is mainly used to handle exceptions globally.**

---

Normally, in a Spring Boot REST API:

- You’d use `@ExceptionHandler` in each controller to handle exceptions.
- But repeating it in multiple controllers is ugly and error-prone.

So Spring created `@ControllerAdvice` to define cross-cutting exception handling in a single place.

---
### How it works?

Internally, Spring:

1. Scans for all classes annotated with `@ControllerAdvice`.

2. Registers their methods marked with:
    - `@ExceptionHandler` → for exception handling
    - `@ModelAttribute` → for adding model attributes globally
    - `@InitBinder` → for data binding configuration

3. Applies them automatically to every controller in the application (or a subset, if specified).

> **NOTE:** It’s part of **Spring’s AOP (Aspect-Oriented Programming)** mechanism, meaning it intercepts controller executions and injects your global logic.

---


