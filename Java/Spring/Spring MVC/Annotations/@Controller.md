# Understanding @Controller Annotation in Spring

The `@Controller` annotation is a specialized form of `Component` annotation, provided by **Spring MVC** to define classes that can handle **HTTP requests**.

Methods within a controller class can be annotated with `@RequestMapping` to map them to specific URLs (endpoints).

Methods in a controller class typically handle the request logic, retrieve data, and then return a response to the client. This response can be:

- A String representing the view name (for rendering HTML templates).
- A ModelAndView object containing both the view name and model data.
- An object or data structure that gets serialized (e.g., JSON) and sent back as the response body (often used for REST APIs).

> **NOTE:** By default, methods in a `@Controller` return a logical view name, which is resolved to an actual view (like a **JSP** or **HTML** page) by a **ViewResolver**.

Example:

```
@Controller
public class MyController {

  @RequestMapping("/hello")
  public String helloWorld() {
    return "hello"; // Return the view name "hello" (assuming a template exists)
  }
}
```

Methods can be annotated with `@ResponseBody` annotation to indicate that the **return value of a method should be written directly to the HTTP response body** instead of being treated as a view name. The return value of the method (often an object or data structure) gets serialized (e.g., JSON, XML) and sent back to the client as the response body.
