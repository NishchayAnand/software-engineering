# Understanding Exception Handling in Java

An exception is an event, which occurs during the execution of a program, that disrupts the normal flow of the program's instructions.

> NOTE: The term exception is shorthand for the phrase **"exceptional event."**

When an error occurs within a method, the method creates an object and hands it off to the runtime system. The object, called an `exception` object, contains information about the error, including its type and the state of the program when the error occurred.

**Creating an exception object and handing it to the runtime system is called throwing an exception.**

After a method throws an exception, the runtime system attempts to find something to handle it. It searches the call stack for a method that contains a block of code that can handle the exception. This block of code is called an `exception handler`.

If the runtime system exhaustively searches all the methods on the call stack without finding an appropriate exception handler, the runtime system terminates.

## Advantages of Exceptions

1. **Separates error handling code from regular code.**
2. **Allows us to propagate error reporting up the call stack of methods.**

## Catch or Specify Requirements

The code that might throw certain exceptions must be enclosed by either of the following:

- A `try` statement that catches the exception.
- A method that specifies that it can throw the exception. The method must provide a `throws` clause that lists the exception.

Code that fails to honor the Catch or Specify Requirement will not compile.

## Types of Exceptions

The Three Kinds of Exceptions: `Checked`, `Error`, `Runtime`.

> NOTE: `Errors` and `runtime` exceptions are collectively known as `unchecked` exceptions.

## User Defined Exceptions

**If a client can reasonably be expected to recover from an exception, make it a checked exception. If a client cannot do anything to recover from the exception, make it an unchecked exception.**

> **_NOTE:_ Always think of exception handling from client's perspective.**
