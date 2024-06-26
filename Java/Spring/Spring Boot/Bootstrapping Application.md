## Understanding How to Bootstrap a Spring Boot Application

- `Application.java`: In a typical Spring Boot application, the Application.java (or any main class with a similar name) serves as the entry point of the application. This class serves two purposes in a Spring Boot application: **configuration** and **bootstrapping**.

- `application.properties`: Comes in handy for fine-grained configuration of the stuff that Spring Boot automatically configures.

> **NOTE:** We do not need to explicitly tell Spring Boot to load `application.properties` for you. By the virtue of the fact that `application.properties` exists, it will be loaded and its properties made available for configuring both Spring and application code.
