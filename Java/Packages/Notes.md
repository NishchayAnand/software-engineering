# Understanding Packages in Java

Packages are the fundamental way in Java to organize your classes, interfaces, and sub-packages into **logical groupings**.

They act like folders in a file system, essentially grouping together code that serve a similar function.

## How to name your Packages?

- Package names typically follow the **reverse-domain-name** notation. The idea is to use your organization's internet domain name, but in reverse order, as the root of your package name. For example, if your organization’s domain is `example.com`, you would start your package names with `com.example`.

> **_NOTE:_** Since domain names are unique across the internet, using a reverse domain name ensures that your package names are also unique.

- Package names should always start with a lowercase letter. This convention helps to distinguish package names from class names, which typically start with an uppercase letter.

## Advantages of using Packages:

- **Namespace Management:** Packages act as namespaces, preventing naming conflicts between classes with the same name from different packages. For example, you can have a `java.util.ArrayList` and a separate `com.mycompany.util.ArrayList` without any clashes.

## Key Points:

- **Maven** expects source files to be in `src/main/java` by default.
- The following command can be used to compile specific .java files in your project: `javac -d target/classes src/main/java/com/example/model/Customer.java src/main/java/com/example/model/Order.java`
