# Testing Interview Questions

Q. What is Test-Driven Development?

Test-Driven Development (TDD) is a software development methodology where **tests are written before the actual code is implemented**. It focuses on designing and developing software by defining its expected behavior upfront through test cases.

---

Q. What is Unit Testing?

Unit testing is a software testing methodology where individual units or components of a program are tested in isolation to verify that they work as intended.

> NOTE: Unit testing usually involves writing tests for each method of a class.

---

Q. What is Junit?

JUnit is a popular open-source testing framework for Java. It provides a structured way to write and run unit tests.

> NOTE: JUnit is an essential tool in Test-Driven Development (TDD). 

---

Q. Explain `@Test` annotation.

The `@Test` annotation in JUnit **marks a method as a test case**. 

> NOTE: The JUnit framework can automatically detect and run methods annotated with `@Test` during test execution.

---

Q. Explain `BeforeEach` annotation.

The `@BeforeEach` annotation in JUnit 5 is used to **indicate that the annotated method should be executed before each test method** in the current test class. 

It is **commonly used for** test setup operations, such as initializing objects or **configuring mock behaviors**.

---

Q. What are Assertions?

Assertions in unit testing are the core mechanism used to validate whether the actual outcomes of the code being tested match the expected outcomes.

> NOTE: Experience has shown that writing assertions while programming is one of the quickest and most effective ways to detect and correct bugs.

---

Q. What is Integration Testing?

Integration Testing is a level of software testing where individual units or **components of a system are combined and tested as a group** to verify their interactions. This type of testing focuses on testing the communication between different modules, ensuring that they work together as intended.

---

Q. Do we need to test `Repository` interfaces?

You don't need to write tests for Spring Data JPA's built-in repository methods since they're already well-tested. However, you should test custom query methods and complex logic in repositories, typically using integration tests with a test database.

--- 

Q. What is H2 database?

The H2 database is an **in-memory database often used for unit and integration testing** because it doesn't require a persistent database setup and resets with each test run.

---

Q. What is Mockito?

Mockito is a popular Java mocking framework that allows you to **create mock objects that simulate the behavior of real objects** without the need for actual implementations.

---

Q. What is Mocking?

Mocking means creating a simulated version of an object to mimic the behavior of real dependencies.

In other words, it allows you to create "mock" versions of objects or components that your code interacts with, enabling you to isolate the unit under test. This helps you focus on testing just the logic of the unit itself, without involving real external systems like databases, web services, or third-party APIs.

Example:
```
UserService mockUserService = mock(UserService.class);
```

---

Q. Explain `@Mock` annotation.

The `@Mock` annotation is part of the Mockito framework and is used to **automatically create mock objects in your test class**.

Example:
```
@Mock
private UserService userSevice;
```

---

Q. Explain `@InjectMocks` annotation. 

The `@InjectMocks` annotation in Mockito simplifies the process of setting up the class under test and its dependencies. It can automatically instantiate and inject mocks (created using `@Mock` or `Mockito.mock()`) into the class under test.

> NOTE: The `@InjectMocks` annotation supports constructor injection, setter injection, and field injection.

---

Q. What is Stubbing?

Stubbing is the process of configuring a mock object in a test to return a specific response or behavior when a particular method is invoked. 

It is a key feature of mocking frameworks like Mockito, used to simulate the behavior of dependencies and isolate the unit being tested.

Example:
```
when(mockUserService.getUserById(1)).thenReturn(new User("John Doe"));
```

---

Q. Explain Dynamic Stubbing.

Dynamic stubbing refers to defining the behavior of a mock object based on the inputs provided during the test. 

Unlike fixed stubbing (where a specific input always returns a predefined output), dynamic stubbing calculates or generates the response at runtime using the inputs passed to the mocked method.

Example:
```
when(mapper.toDTO(any(Entity.class))).thenAnswer(invocation -> {
    Entity entity = invocation.getArgument(0);              // retrieve the input argument
    return new EntityDTO(entity.getId(), entity.getName()); // dynamically create the output
});
```

> NOTE: `invocation` refers to the **event of calling a mocked method** during the execution of a test. It captures the details of the method call, including the arguments passed, the method being called, and other metadata related to the invocation.

---

Q. Explain `@SpringBootTest` annotation. 

The `@SpringBootTest` annotation in Spring Boot is used to write integration tests that **bootstrap the entire Spring application context**. In simple words, this annotation ensures that the Spring application context is loaded during the test.

It is a part of the **Spring Boot Test** module and is used when you need to test how various components of your Spring Boot application interact with each other.

---

Q. Explain `@MockBean` annotation.

The `@MockBean` annotation in Spring Boot is used to add or replace mock instances of a bean in the application context for the duration of the test.

The mocked bean behaves according to the behavior defined by the test setup (e.g., using Mockito's when() method).

---

Q. Explain `@WebMvcTest` annotation.



