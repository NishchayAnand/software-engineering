# Understanding Message Queue

We need to decouple different components of the system so they can be scaled independently. Message Queue is a key strategy employed by many real-world distributed systems to solve this problem.

Message Queues support asynchronous communication. The basic architecture of a message queue is simple. Input services, called producers/publishers, create messages, and publish them to a message queue. Other services or servers, called consumers/subscribers, connect to the queue, and perform actions defined by the messages.

With the message queue, the producer can post a message to the queue when the consumer is unavailable to process it. The consumer can read messages from the queue when the producer is unavailable.
