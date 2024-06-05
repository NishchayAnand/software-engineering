# Understanding Limitations Associated With J2EE

Enterprise JavaBeans (EJBs) played a significant role in the decline of J2EE. Here are some reasons why EJB faced criticism:

## Verbosity

Each EJB typically involves creating a `component` interface, a `home` interface, and a `bean implementation` class, alongside configuring verbose deployment descriptors like `ejb-jar.xml` and `web.xml`.

This verbosity lead developers' to focus more on dealing with the complexities of EJB configuration rather than working on core functionalities, making the development process more cumbersome and time-consuming.

## Increased Boilerplate Code Due to Container-Generated Classes

During deployment, the EJB container automatically generated additional classes, based on the bean definition files (`component` interface, `home` interface, and `bean implementation` class), to handle functionalities like **lifecycle management** and **security**, among others.

The container-generated code results in multiple source files per EJB, making the overall codebase larger and harder to maintain.

## Redundant Thread Management

EJB container thread pooling was generally unnecessary for web applications because web containers already have their own thread pools to handle client requests.

## Restrictive Programming Model

EJB container offers no support for managing relationships between EJBs. We need to perform `JNDI` lookups within an EJB to access to another EJB. This introduces extra complexity and boilerplate code in the EJB implementation, which should ideally focus solely on business logic.

EJB's Object-Relational (O/R) mapping solution through `Entity Beans` is complex and under-specified, neglecting issues like mapping objects with inheritance hierarchies to relational database tables.

Customizing EJB services is also challenging. For instance, it provides no straightforward way to enforce custom security restrictions often needed in real applications.

EJBs, being coarse-grained components, typically depend on multiple fine-grained components like DAOs and helper classes, however, the EJB container doesn't provide any built-in support for managing the lifecycle or dependencies of these fine-grained objects.

## Network Overhead with Distributed Objects

Remote Method Invocation (RMI) enabled developers to build distributed applications in Java. It provided a mechanism for a client program to invoke methods on a remote object as if it were a local object, abstracting away the complexities of network communication.

In theory, distributed objects offered the potential to scale applications by distributing workload across multiple machines. However, the practical scalability benefits might not have been fully realized due to challenges such as **network latency** and **instability** prevalent at that time.

> NOTE: A distributed object lives on a remote machine, accessible across a network.

## Heavy Weight EJB Container

EJB followed an all-or-nothing approach, where developers must adopt the entire EJB framework rather than selectively choosing components or features.

The EJB container is typically packed with all the features offered by the EJB framework, resulting in a heavyweight architecture that is often less suitable for simple applications.
