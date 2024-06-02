# Understanding Checked Exceptions

These are exceptional conditions that a well-written application should anticipate and recover from.

For example, suppose an application prompts a user for an input file name, then opens the file by passing the name to the constructor for `java.io.FileReader`. If the user supplies the name of a nonexistent file, the constructor throws `java.io.FileNotFoundException`.

They can be identified at the compile stage.

**Checked exceptions are subject to the Catch or Specify Requirement.** In simple words, Developers are required to handle the checked exceptions before hand.

> NOTE: All exceptions are checked exceptions, except for those indicated by `Error`, `RuntimeException`, and their subclasses.
