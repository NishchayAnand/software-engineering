# Understanding High Level System Design

Designing a system that supports million of users is challenging, and it is a journey that requires continuous refinement and endless improvement.

The traffic to your web server comes form 2 sources: web application and mobile application.

Separating the web/mobile traffic **(web tier)** and database **(data tier)** servers allows them to be scaled independently.

Vertical scaling, referred to as **scale-up**, means the process of adding more power (e.g. CPU, RAM) to your servers. When traffic is low, vertical scaling is a great option. However, it comes with serious limitations.

1. Vertical scaling has a hard limit. It is impossible to add unlimited CPU and memory to a single server.
2. Vertical scaling does not have failover and redundancy. If one server goes down, the website/app goes down with it completely.

Horizontal scaling, referred to as **scale-out**, allows you to scale by adding more servers into your pool of resources. It is more desirable due to the limitations of vertical scaling.

The **load/response time** can be improved by adding a cache layer and shifting all static content (JavaScript/CSS/image/video files) to the **Content Delivery Network (CDN)**.
