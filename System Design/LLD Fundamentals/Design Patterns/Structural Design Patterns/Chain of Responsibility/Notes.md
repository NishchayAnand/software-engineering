# Understanding Chain of Responsibility Principle

The Chain of Responsibility pattern allows multiple objects in a chain to receive a request until one takes responsibility for handling it. This has some similarities to the common implementation of AOP using a chain of interceptors. However, objects using this approach must be aware of the plumbing, and it's necessary to set up a chain of responsibility for each method requiring one. Like the Decorator, this is not a generic solution for crosscutting concerns.
