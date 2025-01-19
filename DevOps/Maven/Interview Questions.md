# Maven Interview Questions

Q. What is Maven?

Maven is a build automation and dependency management tool used primarily in Java projects.

- **Dependency Management**: Maven automatically downloads libraries and dependencies needed for the project from a central repository (like Maven Central). It resolves transitive dependencies (dependencies of your dependencies).

- **Build Automation**: It handles tasks like compilation, testing, and packaging of the application using a predefined build lifecycle.

---

Q. Explain `<optional>` tag in Maven `<dependency>` tag.

When a dependency is marked as `<optional>true</optional>`, it is excluded from transitive dependency resolution, meaning it will not be automatically included in downstream projects that depend on your project.

---

Q. What is Maven Wrapper?

The **Maven Wrapper** (`mvnw`) is a script that allows developers to run Maven builds without requiring Maven to be installed globally on their system. 

It ensures that the exact Maven version needed for the project is used, promoting consistency and simplifying the build process, especially in collaborative environments.

---

Q. Explain `<scope>` tag in Maven `<dependency>` tag.





