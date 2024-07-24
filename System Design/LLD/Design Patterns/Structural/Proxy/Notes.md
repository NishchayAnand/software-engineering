# Understanding Proxy Pattern

**DEFINITION:** Provides a surrogate or placeholder for another object to control access to it.

Use a Proxy Pattern to create a representative object that controls access to another object, which may be remote, expensive to create, or in need of securing.

> **NOTE:** Think of Proxy as a _representative_ for another object.

The Proxy Pattern provides a way to create a "surrogate" or "wrapper" object that controls access to another object. This proxy object intercepts method calls made on the original object and potentially modifies them before or after execution.

**The main purpose of proxies is to control and manage access**. This control may be needed if the actual object (subject) is running on a remote machine, if the subject is expensive to create, or if access to the subject needs to be protected in some way. For example:

1. A remote proxy controls access to a remote object.
2. A virtual proxy controls access to a resource that is expensive to create.
3. A protection proxy controls access to a resource based on access rights.

## Class Diagram

- `Subject Interface`: Both the Proxy and RealSubject implement the Subject interface. This allows any client to treat the proxy just like the RealSubject.
- `RealSubject`: The object that does most of the real work (proxy controls access to the RealSubject object).
- `Proxy`: Keeps a reference to the Subject, so it can forward requests to the Subject when necessary.

## Remote Proxy

A remote proxy act as a local representative to a remote object. We can call local methods on the remote proxy object and have them forwarded on to the remote object.

Your client object acts like it's making remote method calls. But what it's really doing is calling methods on a local heap proxy object that handles all the low-level details of network communication.

> **NOTE:** A remote object lives in the heap of a different Java Virtual Machine (JVM).

Java's Remote Method Invocation (RMI) functionality allows us to find objects in a remote JVM and invoke methods on them. RMI provides all the runtime infrastructure, including a lookup service that the client can use to find and access remote objects.

Make sure that the arguments and return types of a remote method must be **Primitive** or **Serializable**. Any argument to a remote method has to be packaged up and shipped across the network, and that's done through `Serializaion`. The same thing applies with return values. If you use primitives, Strings and the majority of types provided by Java, you are fine. If you are passing around your own types, just be sure that you make your classes implement **Serializable**.

**CRUX:** With Remote Proxy, the proxy act as the local representative for an object that lives in a different JVM. A method call on the proxy results in the call being transferred over the wire and invoked remotely, and the result being returned back to the proxy and then to the client.

## Virtual Proxy

The virtual proxy act as a representative for an object that is expensive to create.

## Protection Proxy

Protection proxy is a proxy that controls access to an object based on access rights.

## EXTRA

Dynamic proxies leverage the Proxy Design Pattern principles by providing a more convenient and standardized way to implement them in Java. They offer a powerful mechanism for adding functionalities like security, logging, or performance monitoring without modifying the target object's code.

**Analogy:** Imagine a security guard acting as a proxy for a building entrance (target object). The guard (proxy object) intercepts everyone entering (method call) and checks their credentials (invocation handler) before allowing access. Dynamic proxies provide a built-in mechanism for creating and managing these security guards for your objects in Java.
