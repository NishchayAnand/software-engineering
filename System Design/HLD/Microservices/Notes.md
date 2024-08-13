# Understanding Microservices Architecture

Microservices architecture is a design approach where a large application is broken down into `smaller`, `independently deployable` services. Each service focuses on a specific business capability and **communicates with others through well-defined APIs over the network**.

A service is a piece of software that provides functionality to other pieces of software within your system.

> NOTE: Essentially the differences between web applications and other applications are confined to the presentation tier. The service layer should be identical.

The communication between the software components and the service normally happen over a network using some kind of communication protocol.

A system which uses a service or multiple services is known to have service-oriented architecture (SOA). Main idea behind SOA is instead of using package modules within
each client application, you instead use a service to provide functionality to each client application.

Microservice architecture is an improved version of the service-oriented architecture.

Advantage of Monolithic Architecture: You can run the entire code base on one machine. So, when you are developing or testing, you can eaily replicate the entire application on
your machine.

## Microservices design principles

**Autonomous:**

- Loose Coupling: Each service is independently changeable and deployable. Another way to make sure that our microservices are loosly coupled is to make sure that they have their own dedicated database that is not shared with any other microservice.
- Concurrent Development: Other way to make the microservices more autonomous is by having specific teams own specific microservices.
- Contracts and Interfaces: Should always be honored.
- Backward Compatibility: use "Semantic Versioning Strategy" to maintain version of each microservice.
- Stateless Service: Microservices don't have any in-memory data that is required to process related requests. We should be able to replace any of our microservices without having to worry about what's actually in the memory of each one of the microservices.
- Conceptual Microservice: A microservice may not be a single application. It can be a conceptual microservice which actually includes multiple applications.

**Domain-driven Cohesion**:

- Business Domain: Each service represents a specific part of the business with a "cohesive" focus. E.g.: Accounts Domain Microservice, Product Domain Microservice, Orders Domain Microservice, Inventory Domain Microservice, Promotions Domain Microservice.
- Bounded Context.
- Event Storming.
- Strangler Application Pattern: A proven methodolgy that can assist you in transitioning from a large application to microservices using the ideas behind domain-driven cohesion principle.
- Easily Rewritable: Ensure that the amount of code within each one of the microservices is of a certain size that it can be rewritten within 2-3 weeks.

**Ownership Culture**:

- Each service is a product with a team behind it.
- Each one of the microservices should have a product manager, or using Agile terminology, a product owner, which acts a representative, a reference point, an advocate for each one of the microservice's data and functionality within your organization.
- Product (API) Catalog is important to show off exactly what microservices you have and what data and functionality they provide.

**Resiliency**:

- Each service fails fast and alternates functionality.
- Circuit Breaker Pattern: Special connectivity code that we can use within our calling client or service application.
- Retry Pattern: Allows us to retry a connection if we receive a failure from that connection. Should always be used in conjunction with the circuit breaker pattern.
- Timeout Pattern: allows you to set the amount of time you will wait for a connection to downstream component to respond.
- Caching Strategy.
- Asynchronous Communication.
- Active Backups.
- Reliable Network.

**Observability:**

- Workflows and component health is visible and traceable.
- central logging: we need to see the health of all our components, both hardware and software. Difficult to go through lots of local log files specific to each component spread across the software architecture.
- Use consistent logging structure across all microservices (having log level is a good practice).
- All components part of a logical transaction should be given a correlation ID.
- Central Monitoring.

**Automation:**

- On-demand Hosting.
- Automated Deployment Pipeline.
- Automated Unit and Integration Testing.
- Monolithic Architecture Disadvantages: An appliation or service has way too much functionality and data contained within one package.
- Microservices can talk to each other using asynchronous communication using components like "message broker".

## EXTRA

- Synchronous Communication:

  - Temporal Coupling: chaining too many synchronous calls between the microservices, making the client application wait too long for a response.

- Asynchronous Communication:

  - Help reduce temporal coupling and avoid physical distributed transactions.

- REST encourages stateless services.

- OpenAPI: - can make the microservices self-documenting which can then be used to create API catalog. Swagger is one such tool which provides the implementation openAPI.

- Asynchronous Communication:

  - using a messaging system - clients place messages on a message broker in a file-and-forget style, which are eventually processed by microservices.
  - a message broker can be called a service bus, a message bus or an event bus.
  - dead letter can be used to store messages that you can completely process.
  - help us for event-driven architecture and eventual-consistency.

- Transaction Manager:

  - used for managing logical distributed transactions.
  - logical distributed transactions means that we don't have to wait for each part of our transaction to complete, instead, it can happen in the background using aysnchronous
    communication using a system like a message broker.
  - transaction manager can manage the state of our logical distributed transaction.
  - each microservice sends a message to the transaction manager, notify that they have done their part. If any of the microservice isn't able to complete its task, it notifies
    the transaction manager and the transaction manager can do something called failure compensation where it can basically send out messages to all the microservices
    to undo their part of the partially successful transaction.
  - Saga pattern is one such pattern which is used for implementing transaction manager.

- Eventual Consistency and Event-Driven Architecture.

- containers and orchestration engines on the cloud provide a lot of resiliency and automation.

- Orchestration engines ensure that the right number of containers or right number of each type of microservice are running and also provide load balancing and service registry
  functionality. They can handle all the stresses of scaling out your microservices are handled by the orchestration engine.

- Cloud platform can manage most of the hardware in the background that is running your microservices (often known as serverless services).

  - Infrastructure as a Service (IAAS): You need to manage the OS/Runtime.
  - Platform as a Service (PAAS): You need to manage applications/sevices and data only. No control over the runtime/OS running the application.
  - Function as a Service (FAAS): Serverless functions. Deploy code, i.e., functions instead of applications. Cloud handles the running, concurrency and resources. Cloud
    platform may limit concurrency, duration of running and tech choices.

- Centralized Security: Authentication and Authorization (standards set by OAuth2, OpenID Connect and Token Exchange)

- Centralized logging: - Implementations -> Elastic/Kibana, Splunk, Graphite.

- Automation Tools and Patterns (handled by DevOps Team):

  - Source Control Systems: Azure DevOps, AWS CodeCommit, git.
  - Continuous Integration Tools: Performs Automatic builds (build server), has the ability to detect changes in our source control system. Perform automated test before
    deployment.
  - Continuous Delivery Tools: Environment configuration, release configuration, validation gates.

- Greenfield Situation (Starting New):

  - Limited Resources:
    - Small Team, Limited Budget, Limited Requirement.
    - Have Front-end Applications and a back-end API (modular monolith).
    - Use bounded context technique to bind all related classes and data in the back-end API, representing specific business domains (can easily be divided intomicroservices later).
    - Use separation patterns such as sevice pattern or facade pattern to call external APIs.

- Resources Team:

  - Have the required budget and traffic.
  - Start with modular Monolith -> transition to mini-microservice architecture -> incorporate all scaling components such as central monitoring, central logging, API Gateway
    -> develop continuous CI/CD pipeline -> then start migrating your monolithic architecture to microservice architecture (use techniques such as event storming).

- Microservice Challenges:
  - Initial Expense: initially there will cost related to the transition and costs related to the new software, hardware and services. In addition, you will have ongoing cost
    around training staff and hiring new staff and paying for platforms like cloud platforms where the costs are based on usage.
  - Distributed Architecture: Technical culture change. We would need to worry about things like network capacity, increased network communication, as well as having
    logical distributed transactions.
