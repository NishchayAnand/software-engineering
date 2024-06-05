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

- **Home Interface:** Defines the methods that allow clients to create, find, and remove instances of the enterprise bean. It acts as a factory for creating instances of the bean. The home interface should either extend `javax.ejb.EJBHome` interface (for remote access) or `javax.ejb.EJBLocalHome` (for local access) interface.

- **Component Interface:** Declares all the business methods that the client can invoke on the bean. The component interface should either extend `javax.ejb.EJBObject` interface (for remote access) or `javax.ejb.EJBLocalObject` interface (for local access).

- **Bean Class:** Provides the actual implementation of the business methods defined in the component interface. The bean class must implement one of the three interfaces: `javax.ejb.SessionBean`, `javax.ejb.EntityBean`or `javax.ejb.MessageDrivenBean`, depending on the chosen bean type.

The `Home` and `Component` interfaces serve as the primary means of interaction between the client and the enterprise bean. The container generates the implementation classes for these interfaces during deployment.

> **_NOTE:_** Unlike session beans or entity beans, message-driven beans are not directly accessed by clients. Hence, they do not implement component or home interfaces.

## How does an EJB work?

Instead of directly calling the EJB's code, the client interacts through a component interface. This interface acts like a _facade_, **delegating the call to a container-generated behind-the-scenes class.** This hidden class allows the container to intervene before reaching the actual EJB implementation. The container can then perform security checks, manage transactions, and inject resources like database connections before passing the request along to the EJB to execute the business logic.

> **_NOTE:_** The bean implementation class can, but shouldn't normally implement the component interface. If the bean class implements the component interface, it would also need to implement the EJBObject interface (or EJBLocalObject for local interfaces). Implementing both interfaces in the bean class can lead to synchronization issues, especially for stateful session beans. This is because updates made within the bean class wouldn't necessarily be reflected in the container-generated implementation, causing inconsistencies.
