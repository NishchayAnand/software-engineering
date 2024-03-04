# Java Fundamentals

Java is a `platform-independent` `statically-typed` programming language based on the class-based `object-oriented` programming paradigm.

It is largely open-source, with the `OpenJDK` being the reference implementation.

> **OpenJDK**: Stands for **Open Java Development Kit**. It's an open-source project that provides a reference implementation of the Java Platform **(Java Standard Edition)** for developing Java applications.

**Java Development Kit (JDK)** consists of three fundamental components:

- **Java Compiler**
- **Java Virtual Machine (JVM)**
- **Core Java Libraries**

## Java Compiler

The Java compiler, `javac`, is responsible for translating Java source code (files with .java extension) into **bytecode** (files with .class extension), a low-level representation of the source code.

> **_NOTE:_** The **javac compiler** is typically found in the `bin` directory of the **Java Development Kit (JDK)** installation on your system.

To compile a Java program, open your terminal, navigate to the directory where the Java program is saved and run the following command:

```
>> javac [filename].java
```

The javac command will compile `[filename].java` and save the compiled bytecode in a `[filename].class` file in the same directory as `[filename].java`.

> **_NOTE:_** The full directory path of the **JDK's bin directory** should be added to your system's PATH environment variable to allow the **javac compiler** to work from any directory.

## Java Virtual Machine (JVM)

Runtime environment responsible for interpreting bytecode into machine understandable code and executing it on your machine.

Includes a comprehensive set of libraries, providing pre-built classes and methods for performing common tasks in Java programming.
