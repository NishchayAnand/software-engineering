# Understanding Adaptor Design Pattern

**DEFINITION:** Converts the interface of a class into another interface the clients expect.

Adaptor Pattern allows us to wrap objects to make their interfaces look like something they are not.

The adapter **implements** the interface your classes expect and talks to the vendor interface to service your requests.

**The adapter acts as the middleman by receiving requests from the client and converting them into requests that make sense on the vendor classes.**

> **NOTE:** While most textbook examples show the adapter adapting one class, you may need to adapt many classes to provode the interface the client is coded to.

The intent of Adapter is to alter an interface so that it matches one a client is expecting.

## How to implement Adapter Pattern?

The adapter implements the target interface and holds an instance of the adaptee. The adapter is responsible for delegating all requests to the adaptee.

Adapter needs to figure out what methods to call on the adaptee when the client invokes a method on the target.

In Java, Adapter Pattern is achieved by wrapping the object that has an incompatible interface (target interface) with an object that implements the correct one.

## Advantages of Adapter Pattern

- Allows classes to work together that couldn't otherwise because of incompatible interfaces.

## Real World Example

Early Collection types like vector, Stack, Hashtable, etc. implement a method, element(), which returns an Enumeration. The Enumeration interface allows you to step through the elements of a collection without knowing the specifics of how they are managed in the collection.

The more recent Collection classes use an Interator interface.

We are sometimes faced with lecacy code that exposes the Enumeration interface, yet we'd like for our new code to use only Interators.

When client calls the methods in the Iterator interface type, the adapter needs to delegate the request to the apprporiate method in the Enumeration interface type.
