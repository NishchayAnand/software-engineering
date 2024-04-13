# Understanding Java EE

Java EE, or Java Enterprise Edition, is a set of specifications, APIs (Application Programming Interfaces), and runtime environments that provide a platform for developing and running enterprise-level applications in Java.

When Java EE (originally Java 2 Enterprise Edition) launched in the late 1990s, it stood out for several key features that addressed the needs of complex enterprise applications at that time.

Some of its key features (offered back then) include:

- **Standardization:** J2EE promised a standardized approach to enterprise development. Developers could write code using a defined set of APIs to handle common enterprise tasks like database access and security, saving developers time and effort.

- **Middleware:** J2EE runtime consists of an application server that acted as a middleware, providing container-based services needed for efficient development of enterprise applications. The containers act as intermediaries, handling the **low-level details and lifecycle management (configuration)** of your application components, allowing developers to focus on the core business logic.

> Key containers included in an Application Server:
>
> - **EJB container:** Manages the lifecycle of Enterprise Java Beans (EJBs), resource management (e.g., database connections), security, and transaction management.
>
> - **Web containers:** Responsible for handling HTTP requests and generate dynamic web content.

## Challenges associated with J2EE:

Few of the challenges associated with earlier versions of Java EE include:

- **Heavy and Slow Application Servers:** J2EE application servers were built with a monolithic architecture, where all components and services (e.g. security, messaging, database access) were bundled together into a single runtime environment. This resulted in large memory footprints and slower startup times because the server had to load and initialize all components, even if a specific application only needed a small subset of these functionalities.

- **Inconsistent Programmation Models:** J2EE specifications did have some inconsistencies in their programming models. This meant developers needed to learn and manage separate configuration mechanisms for different components (web.xml for web components and ejb-jar.xml for EJBs).

> **_NOTE:_** In 2017, Oracle decided to donate the Java EE specifications to the Eclipse Foundation, a non-profit organization promoting open-source software development. The Eclipse Foundation has renamed Java EE to Jakarta EE to avoid trademark conflicts with Oracle.
