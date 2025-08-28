
Design a **URL shortening service** that converts a long URL into a shorter, more manageable link.

---
### Functional Requirements

1. **URL Shortening:** Take a long URL and create an alias with shorter length.

2. **URL Redirecting:** Redirect a short URL to the corresponding long URL.

> **NOTE:** A URL shortening service can also **handle custom alias creation** or **provide insights on link clicks, location, and user engagement.**

---
### Non-Functional Requirements

1. **Availability:** The system should ensure that users can always access the shortened URLs. 

2. **Low latency:** The system should fetch the long URL and redirect users instantly.

3. **Scalability:** The system should be capable of handling a traffic volume of **10 Million URL generation requests** and **1 Billion redirection requests per day** (assuming **read / write ratio** is **100:1**).

---
### Workflow for Shortening a Long URL

1. The `user` inputs a URL on the web interface. A **POST request** (e.g., `POST https://api.tinyurl.com/v1/shorten`), containing the input URL (e.g., `long_url: https://www.example.com/some/very/long/url`), is sent to the **`shortening service`**.

2. The **`shortening service`** validates the provided URL to ensure it follows a valid structure, is safe to use and is not already present in the database.

3. If the URL passes all checks, the `shortening service` calls the **`encoding service`** to encode the long URL into a unique ID (e.g., `abc123`) which can can be used to generate a unique short URL (e.g., `https://tinyURL/abc123`).

4. Once the short URL is generated, the **`shortening service`** stores the (`short_url → long_url`) mapping in the `database` and returns the shortened URL to the `user`.

![shortening-service-workflow](url-shortening-sequence.png)

---
### Workflow for Redirecting a URL

1. The **`user`** enters a short URL (e.g., `https://tinyURL/abc123`) in the browser. A **GET request** (e.g., `GET /abc123`) is sent to the **`redirection service`**.

2. The **`redirection service`** extracts the **short URL ID** (e.g., `abc123`) and use it to query the `database` to retrieve the corresponding long URL.

3. Once retrieved, the **`redirection service`** sends an **HTTP 301 (Permanent) or 302 (Temporary) redirect** response to the browser.

4. The browser automatically redirects the user to the **original long URL**.

![redirection-service-workflow](redirection-service-workflow.png)

---
### Load Estimation for Shortening Service

Considering the **shortening service** is a **write-heavy service**, its load estimation must involve analysing the following **key load parameters**:

**1. Requests Per Second (RPS):**
- <span style="color : red"><strong>Assumption:</strong> Daily Average URL Generation Requests = 10 Million</span>
- <span style="color : green">Requests Per Second = 10 Million / (24 hours × 3600 seconds ) ~ <strong>100 RPS</strong></span>

**2. Write Throughput Capacity:**
- <span style="color : red"><strong>Assumption:</strong> Average Processing Time = 10 milliseconds / request</span>
- <span style="color : green">Throughput Capacity = 1 / 0.01 = <strong>100 RPS</strong></span>

<span style="color : red"><strong>Assumption:</strong> The peak traffic can be <strong>5 times the average</strong>. Hence, the system must be designed to handle <strong>500 RPS</strong> during peak hours.</span>

<span style="color : green">Considering a single application server can handle <strong>100 RPS</strong>, we can deploy <strong>5 application servers</strong> behind a <strong>load balancer</strong> to efficiently handle all incoming URL shortening requests.</span>

> NOTE: Since every URL shortening request involves generating a unique short ID, the **encoding service** must be handle the same load as the **shortening service**.

---
### Load Estimation for Redirection Service

Considering the **redirection service** is a **read-heavy service**, its load estimation must involve analysing the following **key load parameters**:

**1. Requests Per Second (RPS):**
- <span style="color : red"><strong>Assumption:</strong> Daily Average Redirection Requests = 10 Million x 100 = 1 Billion</span>
- <span style="color : green">Requests Per Second = 1 Billion / (24 hours × 3600 seconds ) ~ <strong>10,000 RPS</strong></span>

**2. Read Throughput Capacity:**
- <span style="color : red"><strong>Assumption:</strong> Average Processing Time = 10 milliseconds / request</span>
- <span style="color : green">Throughput Capacity = 1 / 0.01 = <strong>100 RPS</strong></span>

<span style="color : red"><strong>Assumption:</strong> The peak traffic can be <strong>5 times the average</strong>. Hence, the system must be designed to handle <strong>50,000 RPS</strong> during peak hours.</span>

<span style="color : green">Considering a single application server can handle <strong>100 RPS</strong>, we can deploy <strong>500 application servers</strong> behind a <strong>load balancer</strong> to efficiently handle all URL redirection requests.</span>

> NOTE: Since the system is a read-heavy system, i.e., there will be more reads than writes, we can store the (`short_url → long_url`) mapping in a **cache** (e.g., `Redis`) to improve performance.

---
### Storage Capacity Estimation

The system needs to persist the **user details** and their **shortened URL mappings**. 

Considering the **`url_mapping`** dataset will grow at a much faster rate than the **`user`** dataset, analysing its **storage requirement** is crucial for designing an efficient data model and choosing the right database.

**Storage Requirement:**
- <span style="color : red"><strong>Assumption:</strong> Daily Average URL Generation Requests = 10 Million</span>
- <span style="color : red"><strong>Assumption:</strong> URLs Generated in 10 Years = 10 Million × 365 days × 10 years = 36.5 × 10<sup>9</sup> ≈ 40 Billion URLs</span>
- <span style="color : red"><strong>Assumption:</strong> Total Storage per Mapping = 100 bytes (long URL) + 20 bytes (short ID) + 30 bytes (metadata) = 150 bytes</span>
- <span style="color : green">Required Storage in 10 years = 40 Billion URLs × 150 bytes = 6 × 10<sup>12</sup> = <strong>6 TB</strong></span>

To handle **`massive read traffic`** and **`high availability`** requirements, we may need to add **read replicas** and perform **data partitioning** on the **`url_mapping`** dataset.

**Data Replication Strategy:**
- **`Single-Leader Replication`** is ideal because it offers **high read throughput** by allowing reads from both the **leader** and **follower replicas**. All **writes** are routed through the **leader**, ensuring **data consistency**. Even if the leader fails, the system remains **highly available for reads**.

**Data Partitioning Strategy:** 
- **`Hash-Based Partitioning`** is ideal because the primary access pattern involves exact lookups using the `short_id`, and there’s no need for range queries. This strategy distributes data uniformly across partitions, preventing hot spots and ensuring balanced load.

<span style="color:Green"><strong>MongoDB</strong> seems to be an ideal choice. Its <strong>leader-follower replication model</strong> aligns well with your <strong>Single-Leader Replication</strong> strategy, ensuring <strong>strong consistency for writes</strong> and <strong>high read throughput</strong> from followers. It also supports <strong>hash-based partitioning</strong>, making it capable of horizontally scaling to billions of records.</span>

> **NOTE:** **Cassandra** follows an **eventual consistency** model by default, which might not be ideal for a shortening service that **requires strong consistency for mapping uniqueness**.

---
### System Architecture

Design the system following a **microservices architecture** to account for **scalability**, **fault tolerance**, and **high availability**. It should consist of the following major components:

1. **Load Balancer:** Deploy a minimum of **2 load balancers** to distribute incoming traffic across **`shortening service`** and **`redirection service`** to ensure even load distribution and minimise response time.

 2. **Shortening Service:** Deploy **5+ instances** to efficiently handle the peak load of **~500 RPS**.

2. **Encoding Service:** Deploy **10+ instances** with dedicated ID ranges (`40 Billion / 10 = 4 Billion IDs per instance`) to avoid collisions and central bottlenecks. <span style="color : LightSkyBlue">No read replicas needed considering each instance generates its own IDs from allocated space. If an instance fails, its range can be re-assigned to another new instance.</span>

3. **Redirection Service:** Deploy **500+ instances** to efficiently handle the peak load of **~50,000 RPS**. Can add **Redis** or **CDN caching** in front of database for hot URLs.

4. **Database Cluster:** Deploy **3 replicas per shard (1 primary for writes, 2 secondaries for reads and failover)**. For a setup with **10 shards**, this results in **30+ MongoDB nodes** (3 replicas × 10 shards), ensuring **high availability**, **fault tolerance**, and **horizontal scalability** for handling massive traffic and data volume.

![system-architecture](system-architecture.svg)

> **NOTE:** Deploy centralised **monitoring tools** (e.g., Prometheus, Grafana) and **logging pipelines** (e.g., ELK stack) for observability, latency tracking, error reporting, and alerting. Use **circuit breakers**, **rate limiting**, and **retry logic** in services to maintain reliability under failure scenarios.

---
### Other Documentations

1. Schema Design: [[Distributed Systems/Case Studies/Case Study 1. Tiny URL Generation System/Schema Design]]
2. API Design (LLD): [[Distributed Systems/Case Studies/Case Study 1. Tiny URL Generation System/API Design]]
3. UI Design: [[Distributed Systems/Case Studies/Case Study 1. Tiny URL Generation System/UI Design]]

---



