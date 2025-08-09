# Understanding Fanout Service

A fanout service is a system that efficiently distributes messages from a single source **(service)** to multiple recipients **(subscribers or consumers)**.

Two types of fanout models are: `fanout on write (a.k.a push model)` and `fanout on read (a.k.a pull model)`.

## Fanout on Write (Push Model)

With this approach, news feed is pre-computed during write time. A new post is delivered to friends immediately after it is published.

**Disadvantages:**

1. If a user has many friends/follwers (e.g. celebrities), fetching the friend list and generating news feed for all of them are slow and time consuming. It is called hotkey problem.
2. For inactive users or those rarely log in, pre-computing news feed waste computing resources.

## Fanout on read (Pull Model)

With this approach, the news feed is generated during read time. This is an on-demand model. Recent posts are pulled when a user loads her home page.

**Disadvantages:**

1. Fetching the news feed is slow.

## Common Use Cases

- **Load Balancing**: Distributing incoming requests across multiple servers.
