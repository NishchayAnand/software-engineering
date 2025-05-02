# Understanding Runtime Exceptions

These are exceptional conditions that are internal to the application, and that the application usually cannot anticipate or recover from.

These usually indicate programming bugs, such as logic errors or improper use of an API.

**Runtime exceptions are not subject to the Catch or Specify Requirement.**

For example, consider the application described previously that passes a file name to the constructor for FileReader. If a logic error causes a null to be passed to the constructor, the constructor will throw `NullPointerException`. The application can catch this exception, but **it probably makes more sense to eliminate the bug that caused the exception to occur.**
