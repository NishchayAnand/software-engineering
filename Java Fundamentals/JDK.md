## Understanding Java Development Kit (JDK)

**Java Development Kit (JDK)** is a comprehensive development package for building Java applications. It consists of two fundamental components:

- **Java Compiler**
- **Java Runtime Environment (JRE)**

## Java Compiler

The Java compiler, `javac.exe`, is responsible for translating Java source code into **bytecode** (a low-level representation of the source code).

To compile a `HelloWorld.java` file, open your terminal, navigate to the directory where the file is saved and run the following command:

```
javac HelloWorld.java
```

The javac command will invoke the `javac.exe` to compile `HelloWorld.java` into bytecode. By default, the compiler will save the bytecode as `HelloWorld.class` file in the same directory as `HelloWorld.java`.

> **_NOTE:_** The Java compiler is typically found in the `bin` directory of the Java Development Kit (JDK) installation on your system.

## Java Runtime Environment (JRE)

Java Runtime Environment (JRE) includes:

- **Java Virtual Machine (JVM):** Engine that executes Java bytecode.
- **Java Class Libraries:** A set of standard class libraries that provide implementations of common tasks and functionalities, such as input/output operations, networking, data structures, etc.

To execute a Java program named `HelloWorld` (assuming the class contains a main method), open your terminal, navigate to the directory where the `HelloWorld.class` file is saved and run the following command:

```
java HelloWorld
```

The java command tells the `Java Virtual Machine (JVM)` to run the main method of the HelloWorld class, which is located in the `HelloWorld.class` file.

> **_NOTE:_** If you're only interested in running Java programs on your machine without needing to develop or compile Java code, you typically only need the Java Runtime Environment (JRE).
