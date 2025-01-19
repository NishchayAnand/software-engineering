# Networking Interview Questions

Q. What is HTTP?

HTTP (Hypertext Transfer Protocol) is a transport protocol used for transmitting hypertext (such as HTML) over the internet. It is the foundation of communication on the World Wide Web. 

**Key features**

1. **Request-Response Model**: HTTP operates on a request-response model. A client (usually a web browser) sends an HTTP request to a server, and the server responds with an HTTP response. This interaction forms the basis of web communication. 

2. **Stateless**: HTTP is stateless, meaning each request from a client to a server is independent and contains all the necessary information for the server to fulfill the request. The server does not retain any session information between requests. 

---

Q. What is SOAP?

SOAP (Simple Object Access Protocol) is a messaging protocol that allows services running on different operating systems to exchange structured information with each other.

**Key Features**

1. **XML-Based**: Messages in SOAP are formatted in XML, which ensures a platform-agnostic and extensible communication format.

2. **Transport Neutrality**: SOAP can work over various protocols, such as HTTP, HTTPS, SMTP, and more, though HTTP is most commonly used.

3. **Extensibility**: SOAP allows developers to include custom-defined headers and other extensions to meet specific requirements.

4. **Strict Standards**: SOAP follows strict (in-built) standards for security, transactions and other enterprise features, making it a robust choice for secure and reliable communication.

> NOTE: SOAP is heavily used in financial services and payment gateways where security and reliability are key. 

---

Q. What is REST?

REST (Representational State Transfer) is an architectural style (not a protocol) for designing networked applications. 

**Key Features**

1. **Statelessness**: Each request from the client to the server must contain all the information needed to process it. The server does not store client session data between requests.

2. **Uniform Interface**: Leverages HTTP as its transport protocol to define a uniform way to interact with resources (using HTTP methods like GET, POST, PUT, DELETE, etc).

3. **Representation Neutrality**: Resources are represented in standard formats like JSON, XML, HTML or plain text, but JSON is most commonly used.

4. **Resource Identification**: Resources are identified by URIs (Uniform Resource Identifiers), making them addressable over the web.

> NOTE: While REST is simpler and more flexible than SOAP, it does not include built-in security and transaction handling, which might require additional layers or protocols for complex enterprise scenarios.

---

Q. What is GraphQL?

GraphQL is a query language for APIs that provides a more flexible and efficient alternative to traditional REST APIs. 

A REST API has multiple endpoints for different resources. Clients often need to make multiple requests to different endppoints to gather all the necessary data.

In contrast, a GraphQL API typically exposes a single endpoint that can handle a wide variety of queries. This allows clients to requests only the data they need, reducing over-fetching and under-fetching issues (common in REST APIs).

---

Q. What is gRPC?

Used for inter-service communication. gRPC may pose some challenges when dealing with browser clients due to limited browser support. 

---

Q. What is WebSocket?

Real-time, bi-directional and persistent communications. Perfect for live chat applications and real-time gaming, where low latency data exchange is crucial. 

---

Q. What is Webhook?

It's all about event-driven. 

> NOTE: If we need synchronous communication or immediate response, webhook may not be the best choice. 

---

## EXTRA

---

Q. Can we run more than one app on the same serverport?

You can run more than one app on the same server port if the apps use **different procotols**.

---
