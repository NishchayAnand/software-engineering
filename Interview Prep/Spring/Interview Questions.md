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


