# Understanding Java Virtual Machine (JVM)

Java Virtual Machine (JVM) is a software that provides a sophisticated runtime environment for executeing Java bytecode. It abstracts away hardware and operating system differences, allowing Java applications to run on any platform that supports the JVM.

While the primary purpose of JVM is to execute Java bytecode, its undertakes a range of preparatory tasks before actual execution takes place. These preparatory tasks are essential for ensuring the smooth and secure execution of your program.

Here's a quick breakdown of what JVM does when you execute a command like `java HelloWorld` in your terminal:

- **Loading:** Looks for the `HelloWorld.class` in the project's CLASSPATH (by default, the directory where the corresponding `HelloWorld.java` file resides) and loads the bytecode from the `.class` file into memory.

- **Verification:** Verifies the bytecode to ensure it adheres to certain rules. This process helps prevent potential security vulnerabilities (such as illegal access to memory or unauthorized system resource access) and ensures the safety and stability of the runtime environment.

- **Memory Allocation:** Allocates memory for storing class metadata (class definition, static variables, method information), objects, the program's variables and data structures.

data areas are specific regions of memory allocated to store different types of data during program execution.

allocates memory for various runtime data areas, including the method area for storing class metadata, the heap for object and instance data, the stack for method invocations and local variables, and the native method stack for native method invocations.

method area is the memory block that stores the class code, variable code(static variable, runtime constant), method code, and the constructor of a Java program.

    - Heap: It is used to allocate memory to objects at run time.

    - Stack: It is used to store data and partial results which will be needed while returning value for method and performing dynamic linking.

    - Program Counter Register: used for the working of threads. -> (to be discussed in OS)

    - Native method Stacks: used for the working of threads.  -> (to be discussed in OS)

- **Execution**: Use the **execution engine** (may be an `interpretation`, `Just-In-Time (JIT) compilation`, or a combination of both) to translate the bytecode into **machine code** and instruct CPU to execute it.
