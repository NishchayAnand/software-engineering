# Understanding ApplicationContext

**Root Context** is loaded by `ContextLoaderListener`. It typically loads the root context from a configuration file (like `applicationContext.xml`) during web application startup.

**Child Context** is loaded by `DispatcherServlet`. DispatcherServlet is a core component in Spring MVC that handles incoming requests. It creates its own child context based on a separate configuration (often defined within the servlet mapping in `web.xml`).
