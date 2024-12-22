# Logging Interview Questions

Q. What is Logback?

Logback is a logging framework for Java applications, designed as a successor to the `Log4j` framework.

**Key Features:**

1. Designed to be faster and more efficient than its predecessor, `Log4j`, especially in terms of logging overhead and memory usage.

2. Supports automatic log file rotation based on file size, time, or custom conditions, keeping logs manageable.

> NOTE: By default, Spring Boot uses a Logback configuration file named `logback-spring.xml` or `logback.xml`. You can customize logging behavior using this file.

---

Q. What is SLF4J?

SLF4J **(Simple Logging Facade for Java)** is a logging abstraction or facade that provides a unified API for various logging frameworks. 

Instead of tying an application to a specific logging implementation (e.g., `Log4j`, `Logback`, `java.util.logging`), SLF4J decouples the application from the underlying logging framework, allowing developers to switch between logging implementations with minimal changes.

---