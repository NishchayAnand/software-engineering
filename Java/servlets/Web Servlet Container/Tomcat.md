# Understanding Tomcat Servlet Container

- Tomcat Directory Structure:

```
- Tomcat
    - webapps
        - your_webapp_name
            - WEB-INF
                - web.xml
                - classes
```

The directory structure provided above represents the core installation of Tomcat and a specific web application deployed within it.

- **Tomcat:** The root directory for your Tomcat installation. It typically contains various configuration files, **server startup scripts**, and subdirectories for core functionalities.

- **webapps:** It houses all the web application that you deploy on your tomcat server.

- **WEB-INF:** It serves as a secure location to store essential application resources that aren't meant for direct access through a web browser. The primary goal of `WEB-INF` is to safeguard sensitive information and resources used by your web application.

- **web.xml:** Deployment descriptor for your web application.

- **classes:** stores the compiled Java class (bytecode) files for your web application. These are the actual files that Tomcat executes when requests are made to your application.
