# Understanding Enterprise JavaBeans (EJBs)

Many of the low-level APIs (e.g. JDBC, JTA, JAAS) essential for building robust enterprise applications are not ideal end-user APIs. Using them correctly requires a lot of boilerplate code and substantial developer efforts.

EJB specification aimed to address this challenge by providing a higher-level, component-based model for building enterprise applications. EJBs abstract away many of the complexities associated with low-level APIs, allowing developers to focus more on business logic and less on infrastructure concerns.

> **Business Logic:** The set of business-specific rules that help identify the structure and behavior of the business objects, along with the pre and post conditions that must be met when an object exposes its behavior to other objects in the system.

It offers 3 kinds of components: `Session Beans`, `Entity Beans`, and `Message-Driven Beans`, each providing specific functionalities catering to common enterprise needs.

## Session Beans

Session beans encapsulate business logic and **represent transient client sessions** within an application. They can be **stateless**, maintaining no conversational state between method invocations, or **stateful**, preserving conversational state across multiple method calls. Session beans are ideal for implementing business processes, workflows, and session management logic.

## Entity Beans

Entity beans **represent persistent data entities** within an application and are typically mapped to database tables. They provide object-relational mapping (ORM) capabilities, allowing developers to manipulate database records as Java objects. Entity beans support features such as CRUD operations, object identity, and transactional integrity, making them suitable for managing complex data models and relationships.

## Message-Driven Beans

Message-driven beans process asynchronous messages from message-oriented middleware (MOM) systems such as JMS (Java Message Service). They act as message consumers, asynchronously handling incoming messages and executing business logic in response. MDBs are useful for implementing asynchronous processing, event-driven architectures, and integration with external systems.
