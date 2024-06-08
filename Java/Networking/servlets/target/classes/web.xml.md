# Understaning Web.xml file

- Configuration file for web applications built with Java Servlets.
- It acts as a deployment descriptor, providing instructions to the web container (like `Tomcat`) on how to handle various aspects of your application.

## Key Elements in web.xml:

- **`<web-app>`:** The root element that encompasses all other configurations.

- **`<servlet>`:** Defines a servlet class that handles incoming requests.

- **`<servlet-mapping>`:** Maps a URL pattern to a specific servlet, defining which servlet handles requests for a particular URL path.

- **`<servlet-name>:`** (Within `<servlet>`) Uniquely identifies a servlet class.

- **`<servlet-class>:`** (Within `<servlet>`) Specifies the fully qualified class name of the servlet that handles requests.

- **`<welcome-file-list>`:** (Optional) Defines a list of default files to serve when a directory is requested (e.g., index.html).

- **`<error-page>`:** (Optional) Maps an error code (like `404`) or exception type to a JSP or servlet that handles the error response.

- **`<listener>`:** (Optional) Configures a listener class that can be notified of specific events in the web application's lifecycle (e.g., session creation, context initialization).

- **`<filter>`:** (Optional) Defines a filter class that can intercept requests and responses, allowing for additional processing before or after they reach a servlet.

- **`<filter-mapping>`:** (Optional) Maps a URL pattern to a filter, specifying which requests should pass through the filter.

## Sample Code:

```
<web-app version="3.1" xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app.xsd">

  <servlet>
    <servlet-name>MainServlet</servlet-name>
    <servlet-class>com.example.servlet.MainServlet</servlet-class>
  </servlet>

  <servlet-mapping>
    <servlet-name>MainServlet</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>

  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
  </welcome-file-list>

</web-app>
```

In the above example,

- **version** represents the version of the **Java Servlet specification** that this web application adheres to.

- **xmlns** represents the namespace for the XML elements used in the file.

- **xmlns:xsi** represents the **XSI (XML Schema Instance)** namespace for schema validation.

- **xsi:schemaLocation** represents the location of the schema document that **validates the structure** of the `web.xml` file according to the specified Java Servlet version.
