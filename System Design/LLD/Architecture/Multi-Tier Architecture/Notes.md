# Understanding Multi-Tier Architecture

- **Client Tier:** This tier represents the end-users who interact with the application. The client tier can be a web browser, a mobile device, or a standalone application.

- **Web Tier:** This tier is responsible for handling HTTP requests and generating responses. The web tier includes components such as Servlets, JSPs, and web frameworks.

**Business (Service) Tier:** This tier contains the application’s business logic and performs the processing of business logic. The business tier includes components such as Enterprise JavaBeans (EJBs) and messaging.

**Persistence Tier:** This tier manages the application’s data and provides access to the data store. The persistence tier includes components such as Java Persistence API (JPA) and Java Database Connectivity (JDBC).

## Service (Business) Layer

Data access is a lower-level issue. Business objects (service layer) should not need to deal with data
access technologies such as JDBC directly or catch technology-specific exceptions.

### Handle Multiple Clients

Service objects will usually be "stateless". Stateless service layers are highly scalable: They pose no replication issues and there is no need to allocate additional resources for every client.

One of the key motivations of a middle tier is to share resources between multiple clients. It is also much easier for stateless service layers to support remote clients, if necessary. Although they cannot expose state to callers, they can hold internal state and they can fully participate in inheritance relationships. If they are local, rather than remote, they can use true objects as parameters and return values.

If possible, design applications to use a stateless service layer. Hold state in the web tier, rather than in the business logic tier, if possible.

Business objects demarcate abstract transactions without understanding involved resources, and data access objects fetch transactional resources without worrying about participation in transactions.

### Disadvantages of implementing Business Tier in the Web Tier

- Limited reuse of business objects.
- Confused responsibilities in the web tier. Each class should have a single, clear responsibility. In this approach, web tier classes have two quite different responsibilities.
- Business logic is hard to test, as web tier concerns tend to get in the way.

The web tier can be provided by an MVC framework.
