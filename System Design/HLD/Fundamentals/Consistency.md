# Understanding Consistency in Distributed Systems

Consistency in distributed systems refers to the guarantee that all replicas of a shared data store have the same data at any given time. In other words, it ensures that all users see the same data simultaneously.

Consistency can be broken down into several models, each with its own trade-offs between performance, availability, and fault tolerance:

## Strong Consistency

After an update completes, any subsequent access (by any client) will return the updated value. For example, Banking systems where transactions must reflect immediately across all nodes.

## Eventual Consistency

Given enough time, all replicas in the system will converge to the same value. For example, Social media feeds where slight delays in data propagation are acceptable.

## Read-Your-Writes Consistency

A user will always read their own writes. This ensures that after a user updates a data item, they will always see their updates. For example, after posting a status update on social media, the user will see their post immediately.
