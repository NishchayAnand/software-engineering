# Networking Interview Questions

Q. What is **LAN**?

**Local Area Network (LAN)**, is a network that connects computers, devices, and servers within a limited geographic area, such as a home, office, school, or data centre.

---

Q. What is **DNS**?

The **Domain Name System (DNS)** is often referred to as the **"phonebook of the internet."** 

It translates **human-readable domain names** (like `www.example.com`) into **IP addresses** (like `192.0.2.1` or `2001:0db8::1`) that computers use to identify each other on a network. 

> **NOTE:** DNS allows users to access websites or services without needing to remember complex numerical IP addresses.

---

Q. How **DNS** works?

1. **User Requests a Domain**: A user types a URL (e.g., `www.example.com`) in their browser. The browser doesn't know the IP address, so it asks a DNS server to resolve it.

2. **DNS Resolution Process**: DNS works through a process called **name resolution**, which involves querying different types of DNS servers in a hierarchy:

	- **Recursive Resolver**: A server (often operated by ISPs or public DNS services like Google DNS or Cloudflare) that handles the user's initial DNS query.

    - **Root Server**: The first stop in the DNS lookup. It directs the resolver to the appropriate **Top-Level Domain (TLD) server** (e.g., `.com`, `.org`).

	- **TLD Server**: Points the resolver to the authoritative DNS server for the domain (e.g., `example.com`).

    - **Authoritative DNS Server**: Holds the actual IP address for the domain and sends it back to the resolver.

    - **Result Returned**: The resolver sends the IP address to the user's device, which can now connect to the target server.

3. **Accessing the Target**: Once the IP address is returned, the user's device establishes a connection to the web server using the IP address.

---

Q. What is **HTTP**?

HTTP (Hypertext Transfer Protocol) is a transport protocol used for transmitting hypertext (such as HTML) over the internet. It is the foundation of communication on the World Wide Web. 

**Key features**

1. **Request-Response Model**: HTTP operates on a request-response model. A client (usually a web browser) sends an HTTP request to a server, and the server responds with an HTTP response. This interaction forms the basis of web communication. 

2. **Stateless**: HTTP is stateless, meaning each request from a client to a server is independent and contains all the necessary information for the server to fulfill the request. The server does not retain any session information between requests. 

---

Q. What is **SSH**?

**SSH (Secure Shell)** is a **cryptographic network protocol** used to securely connect to remote servers.

---

Q. What is **RDP**?

**RDP (Remote Desktop Protocol)** is a proprietary protocol developed by **Microsoft** that allows users to **remotely access and control** another computer over a network. 

It provides a **graphical interface** to interact with a remote Windows machine as if you were sitting in front of it.

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
