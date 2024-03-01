# Java Fundamentals

Java is a `platform-independent` `statically-typed` programming language based on the class-based `object-oriented` programming paradigm.

It is largely open-source, with the `OpenJDK` being the reference implementation.

> **OpenJDK**: Stands for **Open Java Development Kit**. It's an open-source project that provides a reference implementation of the Java Platform **(Java Standard Edition)** for developing Java applications.

**Java Development Kit (JDK)** consists of three fundamental components:

- **Java Compiler**
- **Java Virtual Machine (JVM)**
- **Core Java Libraries**

## Java Compiler

The Java compiler `javac.exe` (present in the `./bin` folder of your JDK directory) is responsible for translating your Java source code (files with `.java` extension) into **bytecode** (files with `.class` extension), a low-level representation of your source code.

To compile your Java program, open your terminal, navigate to the directory where your Java program is saved and execute the following command:

```
javac filename.java
```

The above command will run the java compiler to compiler your Java program to bytecode and save it in your defined classpath. ???

> For the above command to work, the location of the `./bin` folder of the your JDK directory should be added to your system's path environment variable. adding full directory path of the Java SE SDK bin directory to your PATH environment variable allows you to run the Java compiler and the Java application launcher from any directory. You should have only one bin directory for the JDK in the path at a time (those following the first are ignored). ??

## Java Virtual Machine (JVM)

Runtime environment responsible for interpreting bytecode into machine understandable code and executing it on your machine.

Includes a comprehensive set of libraries, providing pre-built classes and methods for performing common tasks in Java programming.
