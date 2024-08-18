# Understanding Synchronous vs Asynchronous Communication

With synchronous communication, a call is made to a remote server, which blocks until the operation completes. With asynchronous communication, the caller doesn't wait for the operation to complete before returning, and may not even care whether or not the operation completes at all.

Asynchronous communication can be very useful for long running jobs, where keeping a connection open for a long period of time between the client and the server is impractical. It also works well when you need **low latency**, where blocking a call while waiting for the result can slow things down.

These two modes of communication can enable two different idiomatic styles of collaboration: **request/response** and **event-based**.

With **request/response**, a client initiates a requests and wait for the response. This model clearly aligns well to synchronous communication, but can work for asynchronous communication too.

With an **event-based collaboration**, we invert things. Instead of a client initiating requests asking for things to be done, it instead says _this thing happened_ and expects other parties to know what to do. Event-based collaboration is highly decoupled. The client that emits the event doesn't have any way of knowing who or what will react to it, which also means you can add new subscribers to these events without the client ever needing to know.

Synchronous calls are simpler, and we get to know if things worked straightaway. If we like the semantics of request/response but are dealing with longer-lived processes, we could just initiate asynchronous requests and wait for callbacks. On the other hand, asynchronous event collaboration helps us adopt a choreographed approach, which can yield significant more decoupled services - something we want to strive for to ensure our services are independently releasable.

## Synchronous Communication (Request/Response)

Two technologies that fit well when we are considering request/response: **Remote Procedure Call (RPC)** and **REpresentational State Transfer (REST)**.

- **Remote Procedure Call (RPC)**: Refers to the technique of making a local call and having it execute on a remote service somewhere. Some implementations are tied to a specific networking protocol (like SOAP, which makes nominal use of HTTP), whereas others might allow you to use different types of networking protocols, which themselves can provide additional features. RPC implementations allow you to generate client and server stub and get started very, very fast. This is often the main selling points of RPC: its ease of use. However, RPCs can lead to technology coupling. For example, the use of Java RMI ties not only the client to the JVM, but the server too.

- **REpresentational State Transfer (REST)**

## Asynchronous Communication (Event-Based)

Two main parts we need to consider for asynchronous communication: a way for our microservices to **emit events**, and a way for our customers to **find out those events have happened**.

Message Brokers like RabbitMQ try to handle both problems. Producers use an API to publish an event to the broker. The broker handles subscriptions, allowing consumers to be informed when an event arrives.
