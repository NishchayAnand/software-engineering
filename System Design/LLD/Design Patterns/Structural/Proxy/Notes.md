# Understanding Proxy Pattern

The Proxy Pattern provides a way to create a "surrogate" or "wrapper" object that controls access to another object. This proxy object intercepts method calls made on the original object and potentially modifies them before or after execution.

The main purpose of proxies is to control and manage access.

## Remote Proxy

A remote proxy act as a local representative to a remote object. We can call local methods on the remote proxy object and have them forwarded on to the remote object.

Your client object acts like it's making remote method calls. But what it's really doing is calling methods on a local heap proxy object that handles all the low-level details of network communication.

> **NOTE:** A remote object lives in the heap of a different Java Virtual Machine (JVM).

Java's Remote Method Invocation (RMI) functionality allows us to find objects in a remote JVM and invoke methods on them. RMI provides all the runtime infrastructure, including a lookup service that the client can use to find and access remote objects.

Make sure that the arguments and return types of a remote method must be **Primitive** or **Serializable**. Any argument to a remote method has to be packaged up and shipped across the network, and that's done through `Serializaion`. The same thing applies with return values. If you use primitives, Strings and the majority of types provided by Java, you are fine. If you are passing around your own types, just be sure that you make your classes implement **Serializable**.

## How to implement Proxy Pattern?

## EXTRA

Dynamic proxies leverage the Proxy Design Pattern principles by providing a more convenient and standardized way to implement them in Java. They offer a powerful mechanism for adding functionalities like security, logging, or performance monitoring without modifying the target object's code.

**Analogy:** Imagine a security guard acting as a proxy for a building entrance (target object). The guard (proxy object) intercepts everyone entering (method call) and checks their credentials (invocation handler) before allowing access. Dynamic proxies provide a built-in mechanism for creating and managing these security guards for your objects in Java.
