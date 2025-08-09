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

## What is a Bounded Context?

## What are Transactional Boundaries?

Transactions allow us to say **_"these events either all happen together, or none of them happen"_**. They let us update multiple tables at once, knowing that if anything fails, everything gets rolled back, ensuring our data doesn't get into an inconsistent state.

Simply put, a transaction allows us to group together multiple different activities that take our system from one consistent state to another - **everything works or nothing works**.

> NOTE: Transactions don't just apply to databases, although we must often use them in that context. Message brokers, for example, have long allowed you to post and receive messages within transactions too.

With a monolithic schema, all our create and updates will probably be done within a single transactional boundary. When we split apart our databases, we lose the safety afforded to us by having a single transaction. For example, when creating an order, I want to update the `order` table stating that a customer order has been created, and also put an entry into a table for the warehouse team so it knows where is an order that needs to be picked for dispatch. Within a single transaction in a monolithic schema, creating the order and inserting the record for the warehouse team takes place within a single transaction. But if we have pulled apart the schema into two separate schemas, one for customer-related data including our order table, and another for the warehouse, we have lost this transactional safety. **The order placing process now spans two separate transactional boundaries**.

**If our insert into the order table fails, we can clearly stop everything, leaving us in a consistent state. But what happens when the insert into the order table works, but the insert into the picking table fails?**

1. The fact that the order was captured and placed might be enough for us, and we may decide to retry the insertion into the warehouse's picking table at a later stage (retry). In many ways, this is another form of what is called **eventual consistency**. Rather than using a transactional boundary to ensure that the system is in a consistent state when the transaction completes, instead we accept that the system will get itself into a consistent state at some point in the future. **This approach is especially useful with business operations that might be long-lived (??)**.

2. Another option is to reject the entire operation. In this case, we have to put the system back into a consistent state. The picking table is easy, as that insert failed, but we have a committed transaction in the order table. We need to unwind this. What we have to do is issue a **compensating transaction**, kicking off a new transaction to wind back what just happened. That could be somthing as simple as issuing a **DELETE** statement to remove the order from the database. **However, in a distributed architecture, we don't know if the logic to handle the compensating transaction live in the `Customer` service, the `Order` service, or somewhere else? What happens if we have three, four, or five operations in a transaction? Handling compensating transactions for each failure mode becomes quite challenging to comprehend, let alone implement.** An alternative to manually orchestrating compensating transactions is to use **distributed transactions**.

## Splitting the Monolith

1. **Identify Service Boundaries**: Sort code into domain-oriented packages.

2. **Find seams in the Database**: Require splitting up the repository layer into several parts. To remove foreign key relationship between tables used by different services, expose data via API calls between services (foreign key relationship would need to be managed by resulting services rather than in the database level). This may mean that we need to implement our own consistency chek across services.

3. **Create Separate Service for Shared Mutable Data**: For example, `Warehouse` and `Finance` services need to work with Customer data. Both services would write to, and probably occasionally read from the Customer table. What we have here is something you'll see often - **a domain concept that isn't modeled in the code, and is infact implicitly modeled in the database.**. In such cases, we need to make the current abstract concept of the Customer concrete, i.e, create a new package called `Customer`. We can then use an API to expose `Customer` code to other packages, such as `Finance` and `Warehouse`. Rolling this all the way forward, we may end up with a distinct `Customer` service.

4. **Staging the Break**: It is actually recommended that you split out the schema but keep the service together before splitting the application code out into separate microservices. With a separate schema, we'll be potentially increasing the number of database calls to perform a single action. Where before we might have been able to have all the data we wanted in a single **SELECT** statement, now we may need to **pull the data back from two locations and join in memory**. Also, we end up breaking **transactional integrity** when we move to two schemas, which could have significant impact on our applications. By splitting the schema out but keeping the application code together, we give ourselves the ability to revert our changes or continue to tweak things without impacting any customers of our service. Once we are satisfied that the DB separation makes sense, we can think about splitting out the application code into two services.

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
