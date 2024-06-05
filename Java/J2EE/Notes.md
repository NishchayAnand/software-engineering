# Understanding J2EE

Sun Microsystems originally released Java EE in 1999 as Java 2 Platform, Enterprise Edition (J2EE). It started as an extension of the Java 2 Platform, Standard Edition (J2SE), offering a standardized way to develop complex enterprise applications.

J2EE emphasized the development of `multi-tier` `distributed` applications using `container-managed` `components` adhering to `standard specifications`. Here's a breakdown of why it was such a significant approach:

- **Multi-tier Architecture:** J2EE broke down complex applications into distinct tiers (presentation, business logic, data access) promoting modularity and reusability of code. This separation of concerns made development easier to manage, test, and maintain.

- **Standard Specifications:** J2EE standardized a range of **enterprise services** by offering a set of well-defined APIs (e.g. JDBC, JNDI, Servlet API, JSP). These APIs served as the foundation for developing enterprise applications, providing a common ground for developers to build robust, scalable, and maintainable applications.

- **Components:** While object-oriented development excels at encapsulating individual (finer-grained) concepts, it can be too granular for large-scale projects. J2EE addressed this by introducing **component-based development**, which focuses on encapsulating entire (coarse-grained) services within components. This higher-level approach provides a more manageable view of **functionality**, promoting reusability, maintainability, and scalability for building complex enterprise applications. Some of the key component models supported by J2EE include:

  - **Web Component Model:** Specifies the standards and guidelines for building server-side components (software entities) that handle web requests and generate web presentation content. `Java Servlets` and `JavaServer Pages (JSPs)` form the core of the web component model in J2EE, providing built-in declarative support for middleware services such as **Request Handling**, **Session Management**, **Error Handling** and **Security**.

  - **Enterprise JavaBeans (EJBs) Component Model:** Specifies the standards and guidelines for building server-side components (software entities) that handle the core business logic of an enterprise application. J2EE promoted `Enterprise JavaBeans (EJBs)` as the core component model for managing business objects, providing built-in declarative support for middleware services such as **Lifecycle Management**, **Transaction Management**, **Concurrency Control**, **Security**, **Remote Access** and **Distribution**.

- **Containers:** Containers are the system-level software entities that provide pre-built middleware services that components in enterprise applications can leverage to deal with the low-level infrastructure concerns. Each component model typically has its own container, providing specific services and functionalities tailored to the needs of that component type. Some of the key component containers in J2EE include:

  - **Web Container:** Provide the necessary middleware services to manage the execution of `Servlets` components within web applications.

  - **Enterprise JavaBeans (EJB) Container:** Provide the necessary middleware services to manage the execution of `Enterprise JavaBeans (EJBs)` within enterprise applications.

- **Distributed Architecture:** Remote Method Invocation (RMI) is a set of APIs in Java that enable developers to create distributed applications. You define remote objects using interfaces, and RMI takes care of behind-the-scenes communication. It uses Java serialization to convert method arguments into a transferable format and the Java Remote Method Protocol (JRMP) protocol to send them between Java Virtual Machines (JVMs) on potentially different machines.
