# Understanding J2EE

Sun Microsystems originally released Java EE in 1999 as Java 2 Platform, Enterprise Edition (J2EE). It started as an extension of the Java 2 Platform, Standard Edition (J2SE), offering a standardized way to develop complex enterprise applications.

J2EE emphasized the development of `multi-tier` `distributed` applications using `container-managed` `components` adhering to `standard specifications`. Here's a breakdown of why it was such a significant approach:

- **Multi-tier architecture:** J2EE broke down complex applications into distinct tiers (presentation, business logic, data access) promoting modularity and reusability of code. This separation of concerns made development easier to manage, test, and maintain.

- **Standard specifications:** J2EE standardized a range of **enterprise services** by offering a set of well-defined APIs (e.g. JDBC, JNDI, Servlet API, JSP). These APIs served as the foundation for developing enterprise applications, providing a common ground for developers to build robust, scalable, and maintainable applications.

- **Components:** While object-oriented development excels at encapsulating individual (finer-grained) concepts, it can be too granular for large-scale projects. J2EE addressed this by introducing **component-based development**, which focuses on encapsulating entire (coarse-grained) services within components. This higher-level approach provides a more manageable view of **functionality**, promoting reusability, maintainability, and scalability for building complex enterprise applications. Some key component models supported by J2EE include:

  - **Web Component Model:** Specifies the standards and guidelines for building server-side components (software entity) that handle web requests and generate web presentation content. `Java Servlets` and `JavaServer Pages (JSPs)` form the core of the web component model in J2EE, providing developers with powerful tools for building dynamic and interactive web applications.

  - **Enterprise JavaBeans Components:** Enterprise JavaBeans (EJBs) are server-side application components adhering to a standard model.

- **Containers:**

- **Distributed:**

## Limitations associated with J2EE
