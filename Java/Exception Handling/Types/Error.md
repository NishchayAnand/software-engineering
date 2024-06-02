# Understanding Error Exceptions

These are exceptional conditions that are external to the application, and that the application usually cannot anticipate or recover from.

**Errors are not subject to the Catch or Specify Requirement.**

For example, suppose that an application successfully opens a file for input, but is unable to read the file because of a hardware or system malfunction. The unsuccessful read will throw `java.io.IOError`. An application might choose to catch this exception, in order to notify the user of the problem — **but it also might make sense for the program to print a stack trace and exit.**
