# Understanding Enterprise JavaBeans (EJBs)

Many of the low-level APIs (e.g. JDBC, JTA, JAAS) essential for building robust enterprise applications are not ideal end-user APIs. Using them correctly requires a lot of boilerplate code and substantial developer efforts.

EJB specification aimed to address this challenge by providing a higher-level, component-based model for building enterprise applications. EJBs abstract away many of the complexities associated with low-level APIs, allowing developers to focus more on business logic and less on infrastructure concerns.

> **Business Logic:** The set of business-specific rules that help identify the structure and behavior of the business objects, along with the pre and post conditions that must be met when an object exposes its behavior to other objects in the system.

It offers 3 kinds of components: `Session Beans`, `Entity Beans`, and `Message-Driven Beans`, each providing specific functionalities catering to common enterprise needs.

> **_NOTE:_** Bean is another name for component.

## Session Beans

Session beans **represent transient client sessions** within an application and are typically encapsulating business logic specific to a client. They can be either **stateful**, maintaining conversational state between method invocations for a particular client, or **stateless**, where each method invocation is independent of previous invocations. Session beans are ideal for implementing business processes and workflows (e.g. a credit card processing system).

## Entity Beans

Entity beans **represent persistent data entities** within an application and are typically mapped to database tables. They provide object-relational mapping (ORM) capabilities, allowing developers to manipulate database records as Java objects. Entity beans support features such as CRUD (Create, Read, Update, Delete) operations and transactional integrity, making them suitable for managing complex data models and relationships.

## Message-Driven Beans

Message-driven beans are **designed to process asynchronous messages** from message-oriented middleware (MOM) systems such as JMS (Java Message Service). They act as message consumers, executing business logic in response to incoming messages without maintaining state between invocations.

> Remember that "An Entity Bean **_IS_** Something, A Session Bean **_DOES_** Something."

## How to implement an EJB?

We typically need three Java source files to implement an enterprise bean:

- **Home Interface:** Defines the methods that allow clients to create, find, and remove instances of the enterprise bean. It acts as a factory for creating instances of the bean. The home interface extends either `javax.ejb.EJBHome` (for remote access) or `javax.ejb.EJBLocalHome` (for local access).

- **Component Interface:** Declares all the business methods that the client can invoke on the bean. It extends either `javax.ejb.EJBObject` (for remote access) or `javax.ejb.EJBLocalObject` (for local access).

- **Bean Class:** Provides the actual implementation of the business methods defined in the component interface. It must implement one of the three interfaces: `javax.ejb.SessionBean`, `javax.ejb.EntityBean`or `javax.ejb.MessageDrivenBean`, depending on the chosen bean type.

The `Home` and `Component` interfaces serve as the primary means of interaction between the client and the enterprise bean. The container generates the implementation classes for these interfaces during deployment.

> **_NOTE:_** A client does not directly access a message-driven bean; instead, a client asynchronously sends a message to a JMS queue or topic. Because message-driven beans have no need to expose their methods to clients, they do not implement component or home interfaces. They also do not maintain state on behalf of a client.

## How does an EJB work?

It is by implementing these interfaces that the container can intercept client calls made on the component interface's methods and inject its services (e.g. security checks, transaction management) before delegating the call to the actual EJB implementation class.

When a client calls a business method listed in the component interface, the container steps in the middle of every method call from a client to a bean inserts the "services" like security and transaction before calling the business method defined in the enterprise bean class.
