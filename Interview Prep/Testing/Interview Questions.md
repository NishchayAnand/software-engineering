# Testing Interview Questions

Q. What is Test-Driven Development?

Test-Driven Development (TDD) is a software development methodology where **tests are written before the actual code is implemented**. It focuses on designing and developing software by defining its expected behavior upfront through test cases.

---

Q. What is Unit Testing?

Unit testing is a software testing methodology where individual units or components of a program are tested in isolation to verify that they work as intended.

> NOTE: Unit testing usually involves writing tests for each method of a class.

---

Q. What are Assertions?

---

Q. Do we need to test `Repository` interfaces?

You don't need to write tests for Spring Data JPA's built-in repository methods since they're already well-tested. However, you should test custom query methods and complex logic in repositories, typically using integration tests with a test database.

--- 

Q. What is Mocking?

Since repositories interact with the database, mocking them won’t test the actual database behavior. Instead, use mocking when testing higher-level components (e.g., service or controller layers).

---

Q. What is Integration Testing?

---