# What was Java EE before Spring was launched?

Sun Microsystems originally released Java EE in 1999 as Java 2 Platform, Enterprise Edition (J2EE). It started as an extension of the Java 2 Platform, Standard Edition (J2SE), offering a standardized way to develop complex enterprise applications.

J2EE emphasized the development of `multi-tier` applications using `container-based components` adhering to `standard specifications`. Here's a breakdown of why it was such a significant approach:

- **Multi-tier architecture:** J2EE broke down complex applications into distinct tiers (presentation, business logic, data access) promoting modularity and reusability of code. This separation of concerns made development easier to manage, test, and maintain.

- **Container-based components:** J2EE's reliance on container-based components allowed developers to focus on business logic without being burdened by infrastructure concerns.

  - **Components:** Components serve as the foundational elements that can be combined together to create complex enterprise applications. They are essentially self-contained, reusable pieces of code that perform specific functionalities (e.g. EJBs for business logic or Servlets for handling web requests).

  - **Containers:** Containers act as the runtime infrastructure for components, providing a set of pre-built services (e.g. lifecycle management, resource pooling, security) that components could leverage without needing to write them from scratch.

- **Standard specifications:** J2EE's standard specifications (e.g. Servlet, JSP, JPA and EJB) defined the guidelines for developing components within the container environment. Developers could write applications using these standard APIs, ensuring that their code followed established conventions that would work consistently across different environments.

## Limitations associated with J2EE that Spring Solved

Two main drawbacks of J2EE:

- **Complexity:** Setting up and managing J2EE servers can be quite intricate. J2EE servers are heavyweight environments with numerous configurations and components to manage. This can be time-consuming for developers and require specialized knowledge for administrators.

- **Verbosity:** Strict adherence to J2EE specifications can lead to a lot of boilerplate code in development. Developers often need to write a significant amount of repetitive code to handle deployment descriptors, configuration settings, and lifecycle management of components. This can slow down development and make the codebase less readable.
