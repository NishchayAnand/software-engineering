# Understanding Concurrency Control

Locks are managed at the database level, leading to contention as the number of concurrent transactions increases. Requires vertical scaling (e.g., more powerful DB servers), which has limits and costs.

Message Queue handles large volumes of requests by distributing messages across multiple consumers. Enables horizontal scaling by adding more consumer instances without overloading a central resource.