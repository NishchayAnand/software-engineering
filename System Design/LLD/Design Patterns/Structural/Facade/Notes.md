# Understanding Facade Design Pattern

**DEFINITION:** Provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.

Facade Pattern can be used to hide all the complexity of on or more classes behind a clean, well-lit facade.

In simple terms, the intent of Facade Pattern is to provide simplified interface to a subsystem.

Based on the idea that when designing a system, it's better to keep the number of interactions between classes to a minimum.

The Facade Pattern take a complex subsystem and make it easier to use by implementing a Facade class that provides one, more reasonable interface. However, it still leaves the subsystem accessible so it can be used directly. If you need the advanced functionality of the subsystem classes, they are available for your use.

Facades don't encapsulate the subsystem classes, they merely provide a simplified interface to their functionality. The subsystem classes still remain available for direct use by clients that need to use more specific interfaces.

## How to implement Facade Pattern?

The first step is to use composition so that the facade has access to all the components of the system.

The facade is passed a reference to each component of the subsystem in its constructor. The facade then assigns each to the corresponding instance variable.

## Real World Example

A stateless session bean (EJB component) can provide facade methods that hide the operations of multiple entity beans behind it.

## Advantages

- Allows us to avoid tight coupling between clients and subsystems.
