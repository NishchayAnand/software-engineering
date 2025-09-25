
There are 2 types of communication patterns internal services use to communicate:

1. Synchronous Communication
2. Asynchronous Communication

---
### Synchronous Communication

Synchronous communication like HTTP works well for small-scale systems, but its short-comings becomes obvious as the scale increases. It creates a long request and response cycle that depends on many services.

The drawback of this approach are:

1. **Poor Failure Isolation:** If any service fails, the client will no longer receive a response.
2. **Tight Coupling:** The request sender needs to know the recipient.
3. **Hard to Scale:** Without a queue to act as a buffer, it's not easy to scale the system to support a sudden increase in traffic.

---
### Asynchronous Communication

Asynchronous communication can be divided into 2 categories:

1. **Single Receiver:** Each request (message) is processed by one receiver or service. It's usually implemented via a shared message queue. The message queue can have multiple subscribers, but once a message is processed, it gets removed from the queue.

2. **Multiple Receivers:** Each request (message) is processed by multiple receivers or services. Kafka works well here. When consumers receive messages, they are not removed from Kafka. The same message can be processed by different services. This model maps well to the payment system, as the same request might trigger multiple side effects such as pending push notifications, updating financial reporting, analytics, etc.

---

Generally speaking, synchronous communication is simpler in design, however, it doesn't allow services to be autonomous. 

Asynchronous communication trades design simplicity and consistency for scalability and failure resilience.