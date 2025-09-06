# Understanding High Level System Design

The frontend deals with the user interface and experience, while the backend handles data processing, business logic, and database interactions.

Designing a system that supports million of users is challenging, and it is a journey that requires continuous refinement and endless improvement.

The traffic to your web server comes form 2 sources: web application and mobile application.

Separating the web/mobile traffic **(web tier)** and database **(data tier)** servers allows them to be scaled independently.

Vertical scaling, referred to as **scale-up**, means the process of adding more power (e.g. CPU, RAM) to your servers. When traffic is low, vertical scaling is a great option. However, it comes with serious limitations.

1. Vertical scaling has a hard limit. It is impossible to add unlimited CPU and memory to a single server.
2. Vertical scaling does not have failover and redundancy. If one server goes down, the website/app goes down with it completely.

Horizontal scaling, referred to as **scale-out**, allows you to scale by adding more servers into your pool of resources. It is more desirable due to the limitations of vertical scaling.

The **load/response time** can be improved by adding a cache layer and shifting all static content (JavaScript/CSS/image/video files) to the **Content Delivery Network (CDN)**.

A stateful server remembers client data (state) from one request to the next. One of the issue with stateful architecture is that every request from the same client must be routed to the same server.

In a stateless architecture, HTTP requests from users can be sent to any web servers, which **fetch state data from a shared data store.** State data is stored in a shared data store and kept out of web servers.

## How to Scale Your System to Support Millions of Users

1. Keep Web Tier stateless.
2. Cache data as much as possible.
3. Support multiple data centers.
4. Host static assets in CDN.
5. Scale your data tier by sharding.
6. **Split tiers into individual services (microservices).**
7. Monitor your system and use automation tools.

## Eventual Consistency

## Throughput

It is defined as the amount of work done by a machine in a given particular time. We measure the throughput of the server by how many API Calls it serves in a unit of time.

Generally, we measure throughput in **GBps**, **MBps**, **KBps**.

## BandWidth

Maximum data that can be transferred over different Networks is known as Bandwidth.

## Response Time

When we say our system serves 100 requests per second, it means response time is 0.01 sec for a request.
