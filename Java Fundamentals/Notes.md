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

> **_NOTE:_** The javac compiler is typically found in the `bin` directory of the Java Development Kit (JDK) installation on your system.

To compile a `HelloWorld.java` file, open your terminal, navigate to the directory where the file is saved and run the following command:

```
javac HelloWorld.java
```

The javac command will compile `HelloWorld.java` and save the compiled bytecode in a `HelloWorld.class` file in the same directory as `HelloWorld.java`.

> **_NOTE:_** The full directory path of the JDK's bin directory should be added to your system's PATH environment variable to allow the javac compiler to work from any directory.

## Java Virtual Machine (JVM)

Java Virtual Machine (JVM) is a sophisticated runtime environment whose primary purpose is to execute Java bytecode.

```
java HelloWorld.class
```

that performs several tasks, including bytecode verification, memory management, and execution of the bytecode on the host machine.

Here's a breakdown of what the JVM does with Java bytecode:

- **Loading**: Loads the bytecode from the `.class` files into memory.

- **Verification**: Verifies the bytecode to ensure it adheres to certain rules. This process helps prevent potential security vulnerabilities and ensures the safety and stability of the Java environment.

- **Execution**: Executes the verified bytecode using an **execution engine**. This engine may use `interpretation`, `Just-In-Time (JIT) compilation`, or a combination of both to translate the bytecode into **machine code** that can be executed directly by the CPU.

(continue from here)

Other advantages offered by JVM include:

- **Memory Management**: Performs automatic memory management memory allocation and deallocation, including garbage collection, to ensure efficient memory usage and prevent memory leaks.

- **Security**: The JVM provides a secure execution environment for Java applications, enforcing access controls and preventing unauthorized access to system resources.

- **Portability**: The JVM abstracts away hardware and operating system differences, allowing Java applications to run on any platform that supports the JVM.

## Core Java Libraries

Java Development Kit (JDK) includes a comprehensive set of libraries, providing pre-built classes and methods for performing common tasks in Java programming.
