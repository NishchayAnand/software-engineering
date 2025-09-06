# Understanding Asynchronous Microservices

Fire and forget interactions. We make a request, we accept a default response but we don't wait for the actual response.

One form of asynchronous communication is event-based communication using a component called `Message Broker`. We treat our transactions and actions as events and messages and we also decouples the clients and the back-end services. All the messages remain on the message broker until someone can process those messages. Within the message broker, we have a number of queues where these messages live, and these queues can have different queueing patterns for different needs.

Another option to incorporate asynchronous communication is through the use of async API calls (call to downstream microservice is handled by a separate thread as a background task). The request contains a **callback address**, which tells our downstream microservice that **please notify this address once you've completed this long running task**.

## Event-Based

Event-based communication is also sometimes referred to as event-driven architecture. One of its key componens is a Message Broker or a messaging system which enables event-based communication.

The sender of the events are commonly referred as `Publishers` or `Producers`. The recipients of an event are commonly referred to as `Subscribers` or `Consumers`.

> NOTE: An event is basically a message. However, message is usually send to a single recipient, where event can have multiple recipients. Hence, it is better to use the term event.

Inside the Message Broker, messages are received onto queues. The queues hold the event until a recipient is available and keeps the copy of the event until it receives an acknowledgment from the recipient that the task is completed successfully. If the recipient fails to process the event, it is then re-queued.
