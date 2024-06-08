# Understanding Servlets API in Java

- Servlets don't have a `main()` method. They're under the control of another Java application called a **Container.**

- Tomcat is an example of a Container.

- When your web server (like `Apache`) gets a request for a `servlet` (as opposed to, say, a plain old static `HTML` page), the server hands the request **not to the servlet itself**, **but to the Container** in which the `servlet` is deployed. **It's the Container that gives the servlet the `HTTP` request and response, and it's the Container that calls the servlet's methods (like `doPost()` or `doGet()`).**

-

---

- Implement methods to handle initialization of the servlet and handling requests messages.

- Without configuration, a servlet does not have an accessible URL. Beginning with Servlet 3.0 (Java EE 6), annotations can be used to map URLs to servlets (before that web.xml file was used).

- A deployment descriptor is an XML-based configuration file.

- Web application deployment descriptors:

  - are named `web.xml` and placed in the `WEB-INF` directory.
  - configure URL mapping information and other configuration settings.
  - Are optional in Java EE 6. Annotations are used to provide configuration information.
  - Take precedence over annotation-based configuration.

  - RequestDispatcher interface provides a forward() method which can be used to transfer control from a servlet (controller) to a target component.

- Client can share the session ID with the server via:

  - Cookies
  - URI rewrite

- **load-on-startup:** this will load the servlet at the time of deployment on server.
