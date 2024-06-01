# Understanding Web Servlet Containers

When a request comes in, somebody has to:

- instantiate the `Servlet`
- **make a new thread to handle the request.**
- call the servlet's `doPost()` or `doGet()` method.
- get the **request** and **response** to the servlet.
- manage the life, death, and resources of the servlet.

That somebody is the Web Container.

- The container provides an easy way for your `servlets` to talk to your web server. **You don't have to build a `ServerSocket`, listen on a port, create streams, etc.**

Thanks to container, we get to concentrate more on our own business logic instead of worrying about writing code for **threading, security, and networking.**

## Key Services provided by Web Containers:

- **Communication Support:** The container knows the protocol between the web server and itself. Your servlet doesn't have to worry about an API between, say, the `Apache` web server and your web application code. All you have to worry about is your own business logic that goes in your Servlet.

- **Lifecycle Manangement:** The Container controls the life and death of your `servlets`. With the Container in control, you don't have to worry as much about **resource management.**

- **Multithreading Support:** The container **automatically creates a new Java thread for every servlet request it receives.** When the servlet's done running the HTTP `service` method for a client's request, the thread completes (i.e., dies).

- **Declarative Security:** With a container, you get to use an XML deployment descriptor to configure (and modify) security without having to hard-code it into your servlet (or any other) class code. **This allows you to manage and change your security without touching or recompiling your Java source files.**

## How the Container handles a request?

1. User clicks a link that has a URL to a `Servlet` instead of static page.
2. The container sees that the request is for a servlet, so it creates two objects: `HttpServletRequest` and `HttpServletResponse`.
3. The container finds the correct servlet based on the URL in the request, creates or allocates a thread for that request, and passes the `HttpServletRequest` and `HttpServletResponse` objects to the servlet thread.
4. The container calls the servlet's `service()` method. Depending on the type of request, the `service()` method calls either the `doGet()` or `doPost()` method.
5. The `doGet()` or `doPost()` method generates the dynamic page and stuffs the page into the `HttpServletResponse` object (remember, the container still has a reference to the response object).
6. The thread completes, the container converts the `HttpServletResponse` object into an HTTP response, sends it back to the client, then **deletes the `HttpServletRequest` and `HttpServletResponse` objects.**

> NOTE: The servlet inherits the `service()` method from `HttpServlet`.

## Deployment Descriptor (DD)

When you deploy your servlet into your web Container, you'll create a fairly simple XML document called the **Deployment Descriptor** to tell the Container how to run your servlets.

> NOTE: We can give a special deployment name to servlets. A deployment name is simply a **secret internal** name that doesn't that doesn't have to be the same as the class or file name.

You use 2 XML elements to map URLs to servlets:

1. `<servlet-mapping>`: maps the client-known _public_ URL name to your own _internal_ name.
2. `<servlet>`: maps your own _internal_ name to a fully-qualified _class_ name.

```
<web-app ...>

    <servlet>
        <servlet-name>Internal Name</servlet-name>
        <servlet-class>foo.Servlet1</servlet-class>
    </servlet>

    <servlet-mapping>
        <servlet-name>Internal Name</servlet-name>
        <url-pattern>/Public1</url-pattern>
    </servlet-mapping>

</web-app>
```

Besides mapping URLs to actual servlets, you can use the DD to customize other aspects of your web application including **security roles and error pages.**

> **_NOTE:_** DD gives you the way to modify your application declaratively, i.e., without changing your source code. _This means that those who aren't Java programmers can customize your Java web application without having to drag you back from your tropical vacation._

The Container has a specific place it will look for all servlets for which you've specified a mapping in DD.

---

- A web container, on the other hand, is an application that includes a web server as well as additional components like a servlet container, Enterprise JavaBean (EJB) container, and so forth.

Web Server: A web server can deliver various types of static content, including HTML files, images, CSS, JavaScript, and more. It essentially serves files from the server's filesystem based on the request.

Web Container: A web container primarily deals with dynamic content. It processes requests for servlets and JSPs, which are Java programs that can generate content on the fly, access databases, and interact with other resources.

Examples of web containers include Tomcat, Glassfish, JBoss Application Server, or Wildfly.A web container, on the other hand, is an application that includes a web server as well as additional components like a servlet container, Enterprise JavaBean (EJB) container, and so forth.

Examples of web containers include Tomcat, Glassfish, JBoss Application Server, or Wildfly.

Web containers aimed to separate the web presentation layer (servlets and JSP) from the underlying server infrastructure.

Web containers provided essential services like session management, security, and lifecycle management for web components, simplifying development and ensuring consistency across different server environments.

A web server like Apache can be configured to use a web container like Tomcat to handle requests for servlets and JSPs. The web server acts as the entry point, and the web container takes over for dynamic content generation.

In essence, web servers handle the core mechanics of HTTP communication and deliver static content, while web containers are specialists in processing requests for dynamic content generation using Java technologies.
