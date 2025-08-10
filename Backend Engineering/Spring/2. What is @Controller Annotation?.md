
The `@Controller` annotation is a specialized form of `Component` annotation, provided by **Spring MVC** to define classes that can handle **HTTP requests**.

Methods in a Controller class typically handle the request logic, retrieve data, and then return a response to the client. This response can be:

- A String representing the view name (for rendering HTML templates).
- A ModelAndView object containing both the view name and model data.
- An object or data structure that gets serialized (e.g., JSON) and sent back as the response body (often used for REST APIs).

> **NOTE:** By default, methods in a `@Controller` return a logical view name, which is resolved to an actual view (like a **JSP** or **HTML** page) by a **ViewResolver**.

## @RequestMapping

Methods within a controller class can be annotated with `@RequestMapping` to map them to specific URLs (endpoints).

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

> NOTE: `@RequestMapping` can also be applied to a controller class to specify a base path for all the request handling methods within that class.

## @ResponseBody

Methods can be annotated with `@ResponseBody` annotation to indicate that the **return value of a method should be written directly to the HTTP response body** instead of being treated as a view name. The return value of the method (often an object or data structure) gets serialized (e.g., JSON, XML) and sent back to the client as the response body.

Here's a sample code using `@ResponseBody` annotation:

```
@Controller
public class MyController {

  @GetMapping("/data")
  @ResponseBody
  public List<Product> getProducts() {
    // Fetch product data from a service or repository
    List<Product> products = ...;
    return products;
  }
}
```

> **NOTE:** When you include Spring Boot in your project, it automatically configures the `Jackson` library to convert Java objects to `JSON` by default.
