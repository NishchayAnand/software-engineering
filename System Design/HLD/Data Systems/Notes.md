# Understanding Data Systems

Many applications today are data-intensive, as opposed to compute-intensive. Raw CPU power is rarely a limiting factor for these applications.

Data-intensive applications typically need to:

1. **Store data** so that they, or another application, can find it again later **(databases)**.
2. **Remember the result** of an expensive operation, to speed up reads **(caches)**.
3. Allow users to **search data by keyword** or filter it in various ways **(search indexes)**.
4. Send a messages to another process, to be handled asynchronously (stream processing).
5. **Periodically crunch a large amount of accumulated data (batch processing)**.

Many applications now have such demanding or wide-ranging requirements that a single tool can no longer meet all of its data processing and storage needs. Instead, the work is broken down into tasks that can be performed efficiently on a single tool, and those **tools are stitched together using application code.** For example, if you have an application-managed **caching layer (such as `Memcached`)**, or a **full-text search server (such as `Elasticsearch`)**, it is normally the application's code responsibility to keep those caches and indexes in sync with the main database.

> **NOTE:** Now a days, every Application Developer has to be a Data System Designer.

## Scalability

Scalability is the term we use to describe a system's ability to cope with increased load.

Good system design questions:

1. **If the system grows in a particular way, what are our options for coping with the growth?**
2. **How can we add computing resources to handle the additional load?**

Load can be described with a few numbers which we can _load parameters_.

### Load Parameters

1. Requests per second to a web server.
2. Ratio of reads to writes in a database.
3. Number of simultaneously active users.
4. Hit rate on a cache.

If you are working on a fast-growing service, it is therefore likely that you need to rethink your architecture on every order of magnitude load increase.

People often take about a dichotomy between _scaling up_ (vertical scaling, moving to a more powerful machine) and _scaling out_ (horizontal scaling, distributing the load across multiple small machines).

**Problems associated with scaling:** volume of reads, volume of writes, the volume of data to store, the complexity of the data, the response time requirements, or usually some mixture of all of these plus many more issues.

An architecture that scales well for a particular application is built around assumptions of which operations will be common and which will be rare - **the load parameters.**

> **NOTE:** In an early-stage startup, it's usually more important to be able to interate quickly on product features than it is to scale to some hypothetical future load.

Even though scalable architectures are specific to a particular application, they are nevertheless usually built from general-purpose building blocks, arranged in familier patterns.
