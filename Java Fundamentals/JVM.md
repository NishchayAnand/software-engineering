# Understanding JVM

Java Virtual Machine (JVM) is a software which creates a sophisticated runtime environment to execute Java bytecode. It performs several tasks, including bytecode verification, memory management, before executing the Java bytecode on the host machine.

Here's a breakdown of what the JVM does with Java bytecode:

- **Loading**: Loads the bytecode from the `.class` files into memory. The JVM knows to look for the class file based on the provided class name and the classpath settings.

- **Verification**: Verifies the bytecode to ensure it adheres to certain rules. This process helps prevent potential security vulnerabilities and ensures the safety and stability of the Java environment.

- **Execution**: Executes the verified bytecode using an **execution engine**. This engine may use `interpretation`, `Just-In-Time (JIT) compilation`, or a combination of both to translate the bytecode into **machine code** that can be executed directly by the CPU.

(continue from here)

Other advantages offered by JVM include:

- **Memory Management**: Performs automatic memory management memory allocation and deallocation, including garbage collection, to ensure efficient memory usage and prevent memory leaks.

- **Security**: The JVM provides a secure execution environment for Java applications, enforcing access controls and preventing unauthorized access to system resources.

- **Portability**: The JVM abstracts away hardware and operating system differences, allowing Java applications to run on any platform that supports the JVM.
