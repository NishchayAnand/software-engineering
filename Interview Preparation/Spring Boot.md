
**Q1. What is Dependency Injection?**

**A.** Dependency Injection is a design pattern where an object does not create its own dependencies. Instead, dependencies are provided (injected) by an external entity, such as Spring IoC container.

**Without DI (tight coupling):**

```java
class OrderService {
	private PaymentService payment = new PaymentService();
	// Hard to replace PaymentService
}
```

**With DI (loose coupling):**

```java
class OrderService {
	private PaymentService payment;
	
	public OrderService(PaymentService payment) {
		this.payment = payment;
	}
}
```

**Key Insights:**

- DI is a way to achieve IoC.

---

**Q2. What is Aspect-Oriented Programming?**

**A.** **Aspect-Oriented Programming** is a programming paradigm that **separates cross-cutting concerns** (logging, security, and transactions) from business logic, so the core code stays clean and focus.

**Without AOP (code scattering & tangling):**

```java
public void transfer() {
    log();
    authenticate();
    beginTx();
    businessLogic();
    commitTx();
}
```

**With AOP:**

```java
@Transactional
public void transfer() {
	businessLogic();
}
```

---

**Q3. What is Spring?**

A. Spring framework started as a lightweight alternative to Java Enterprise Edition (`J2EE`), enabling **dependency injection** and **aspect-oriented programming** with plain old Java objects (POJOs).

> **NOTE:** While **Spring** was lightweight in terms of component code, it was heavyweight in terms of configuration. Component-scanning reduced configuration and Java configuration made it less awkward, but Spring still required a lot of configuration.

---

**Q4. What is Spring Boot?**

**A.** Spring Boot is an extension of Spring framework that simplifies application development by providing three foundational features:

1. **Auto-Configuration:** Can automatically configure beans (objects) based on the dependencies (libraries) present at the application's classpath. 

2. **Simplified Dependency Management:** It can be challenging to add dependencies to project's build. Each primary dependency incorporates numerous other secondary dependencies in order to fulfill its promised functionality. Spring Boot's starter dependencies free you from worrying about which versions of the libraries you need. All dependencies encompassed by a starter are version-synchronized. 

3. **Simplified Deployment:** Comes with an embedded servlet container (`Tomcat`) that allows us to create web applications as self-executable JAR files that can be run on the command line.

---

**Q5. What is `@SpringBootApplication`?**

The `@SpringBootApplication` annotation is a key annotation in Spring Boot that marks a class as the main configuration class and entry point for a Spring Boot application. It is a composite annotation that combines three crucial annotations:

- `@EnableAutoConfiguration`: Part of SpringBoot framework. Automatically configures the Spring application context based on the dependencies on the classpath. For example, if `spring-boot-starter-web` is on the classpath, it configures a web application context.

- `@Configuration`: Part of Spring Framework. Indicates that the class contains Spring bean definitions.

- `@ComponentScan`: Part of Spring framework. Automatically scans the package where the annotated class is located and its sub-packages for Spring components to register them as beans in the Spring application context.

> **NOTE:** The `@SpringBootApplication` annotation simplifies configuration in a Spring Boot project by eliminating the need to declare these annotations individually.

---

**Q6. What is `@Controller` annotation?**

The **`@Controller`** annotation is a specialized form of `Component` annotation, provided by **Spring MVC** to define classes that can handle **HTTP requests**.

Methods in a controller class typically handle the request logic, retrieve data, and then return a response to the client.

> **NOTE:** By default, methods in a controller class return a logical view name, which is resolved to an actual view (like a **JSP** or **HTML** page) by a `ViewResolver`.

---

**Q7. What is `@RestController` annotation?**

The **`@RestController`** annotation is a specialized version of `@Controller` within Spring MVC. It simplifies the development of **RESTful web services** by eliminating the need to annotate each method with `@ResponseBody`.

It is essentially:

```
@RestController = @Controller + @ResponseBody
```

All handler methods automatically have their return values **written directly to the HTTP response body** (`@ResponseBody`), without the need to annotate each method individually.

---

**Q8. What is `@RequestMapping` annotation?**

The **`@RequestMapping`** annotation is used to map HTTP requests to controller classes, handler methods within the controller classes, or both .

**Example**

```java
@Controller
@RequestMapping("/products") // Base path for all methods in this controller
public class ProductController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String listProducts() {
        return "List of products";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addProduct() {
        return "Product added";
    }
}
```

---

**Q9. What is `@PathVariable` annotation?**

**A.** Extracts value from URL path.

---

**Q10. What is `@RequestParam` annotation?**

The **`@RequestParam`** annotation is used to **bind HTTP request parameters** to method parameters in a controller.

Example

```
@RequestMapping(value = "/greet", method = RequestMethod.GET)
public String greetUser(@RequestParam String name) {
    return "Hello, " + name;
}
```

Request

```
GET /greet?name=John
```

You can make parameters **optional** and set a default value.

```
@GetMapping("/greet")
public String greetUser(@RequestParam(required = false, defaultValue = "Guest") 
                        String name) {
    return "Hello, " + name;
}
```

If `name` is not provided:

```
GET /greet
Response: Hello, Guest
```

> **NOTE:** Since Spring assigns the default value directly, you avoid writing extra code to handle `null` or missing values.

If the **parameter name in the request** is different from your method parameter name, you can map it.

```
@PostMapping("/api/user")
public String addUserRename(
        @RequestParam(name = "user_id") int id,
        @RequestParam(name = "full_name") String name) {
    return "User ID: " + id + ", Name: " + name;
}
```

> **NOTE:** It **decouples your internal method variable names from the external API parameter names**, giving you flexibility in both design and maintenance. You can change your internal method parameter names without breaking client requests.

---

**Q. Is it possible to use `@RequestParam` in a `POST` request?**

**A.** Normally, people associate `@RequestParam` with **GET** requests, but Spring actually allows it in **POST** requests too. The key point is: `@RequestParam` always reads **parameters**, not JSON body.

Those parameters can come from:

1. **Query Parameters:** If you send parameters in the URL (e.g., `/submit?id=101&name=John`), `@RequestParam` will map them to method parameters.
    
2. **Form Data (`application/x-www-form-urlencoded`)**: If you submit a form with a `POST` request and `Content-Type` is `application/x-www-form-urlencoded`, `@RequestParam`can still capture the submitted form fields.

---

**Q. Explain exceptional handling in Spring.**

Spring provides annotation based exception handling to:

- Catch exceptions
- Return meaningful HTTP responses
- Keep controllers clean

The two key tools are:

1. `@ExceptionHandler`
2. `@ControllerAdvice`

---

**Q. What is `@ExceptionHandler`?**

**A.** `@ExceptionHandler` is used **inside a controller** to handle exceptions **thrown by that controller only**. 

```java
@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/{id}")
	public User getUser(@PathVariable int id) {
		if (id == 0) {
			throw new IllegalArgumentException("Invalid ID");
		}
		return new User(id, "Nish");
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArg(IllegalArgumentException e) {
		return ResponseEntity
			.badRequest()
			.body(ex.getMessage());
	}
	 
}
```

---

**Q. What is `@ControllerAdvice`?**

**A.** `@ControllerAdvice` is used to create global exception handlers that apply to all controllers.

```java
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArg(IllegalArgumentException e) {
		return ResponseEntity
			.badRequest()
			.body(ex.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGeneric(Exception e) {
		return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body("Something went wrong");
	}
}
```

---

**Q. What is `@Qualifier`?**

**A.** When **more than one bean of the same type** is present, Spring cannot decide which one to inject and throws `NoUniqueBeanDefinitionException`.

```java
@Component
class CreditCardPayment implements PaymentService {}

@Component
class UpiPayment implements PaymentService {}

@Service
class OrderService {
	@Autowired
	private PaymentService paymentService; // ❌ Ambiguous
}
```

`@Qualifier` can be used to resolve this ambiguity by explicitly specifying which bean should be injected.

```java
@Service
class OrderService {
	
	@Autowired
	@Qualifier("upiPayment")
	private PaymentService paymentService;
	
}
```

---

**Q. What is `@Primary`?**

**A.** `@Primary` marks the bean as the default choice when multiple beans of the same type are available for dependency injection.

---







