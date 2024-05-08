# Understanding Servlets API in Java

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
