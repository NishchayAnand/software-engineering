# Spring Interview Questions

Q. Explain `@RestController` annotation.

The `@RestController` annotation is designed to simplify the creation of RESTful web services. It combines the functionality of `@Controller` and `@ResponseBody` into a single annotation.

- `@Controller`: Marks the class as a Spring MVC controller that can handle HTTP requests in a web application. 

- `@ResponseBody`: Automatically serializes the returned object of a controller method into JSON or XML (depending on the content type in the request header) and writes it directly to the HTTP response body.

> NOTE: Works seamlessly with Spring’s HTTP message converters, such as Jackson for JSON serialization.

---

Q. Explain `@RequestMapping` annotation.

The `@RequestMapping` annotation in Spring MVC is **used to map HTTP requests to handler methods in a controller**. 

> NOTE: Can be used at both the class level and method level to define hierarchical mappings.

---

Q. Explain `@GetMapping` annotation.

The `@GetMapping` annotation in Spring MVC is a specialized version of `@RequestMapping` that **simplifies mapping HTTP GET requests to specific handler methods**.

> NOTE: Use `@GetMapping("/example")` instead of `@RequestMapping(value="/example", method = RequestMethod.GET)` to make the code more concise and readable.

---

Q. Explain `@RequestBody` annotation.

The `@RequestBody` annotation in Spring MVC is used to **map the HTTP request body to a Java object**. 

> NOTE: Works with `HttpMessageConverter` to automatically bound the data in the HTTP request body to the fields of the Java object (based on property names).

---

Q. Explain `@Autowired` annotation.

The `@Autowired` annotation in Spring is used to **automate the dependency injection process**. It's a declarative way to instruct Spring to automatically resolve and inject a bean into a class. It can be used on fields, constructors and setter methods.

> NOTE: By default, `@Autowired` performs injection by type. 

---

Q. "Field Injection using `@Autowired` makes the class mutable, increasing the risk of unintended side effects during testing or debugging." Explain.

When you use field injection, the injected **dependencies** cannot be declared as `final` because they **are assigned by the Spring container after the object is created**. Without `final`, there's no guarantee that the dependency won't be reassigned or modified accidentally elsewhere in the code.

When testing a class with field injection, dependencies are typically injected using reflection or test utilities. These tools bypass normal object initialization, which can lead to unexpected behavior or unintentional overwriting of dependencies during tests.

---

Q. How does Constructor Injection using `@Autowired` promotes immutability?

Constructor injection ensures that all dependencies are explicitly defined and provided during object creation. This approach allows the class to declare its dependencies as `final`, making the object immutable and enhancing its reliability.

---

Q. Explain `@Qualifier` annotation.

By default, `@Autowired` performs injection by type. However, when multiple beans of the same type exist, Spring cannot decide which one to inject and throws an exception. The `@Qualifier` annotation helps specify the exact bean to be used.

> NOTE: Use `@Qualifier` with the `@Autowired` annotation to explicitly specify which bean to inject.

---
