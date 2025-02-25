# TinyURL System Design

Design a **URL shortening service** that converts a long URL into a shorter, more manageable link. 

---
## Functional Requirements

1. **URL Shortening:** Take a long URL and create an alias with shorter length.

2. **URL Redirecting:** Retrieve the original URL from the shortened version.

> **NOTE:** A URL shortening service can also **handle custom alias creation** or **provide insights on link clicks, location, and user engagement.**

---
## Non-Functional Requirements

1. **Availability:** The system should ensure that users can always access the shortened URLs.

2. **Low latency:** The system should fetch the long URL and redirect users instantly.

3. **Scalability:** A read heavy system capable of handling a traffic volume of 10 Million URL generation requests and 1 Billion redirection requests per day (assuming read / write ratio is 100:1).

4. **Security and Abuse Prevention:** Shortened URLs shouldn't be guessable / predictable.

---
## Workflow for Shortening a URL

- The user **inputs a long URL** on the web interface. A **POST request** is sent to the **shortening service**.

- The shortening service **validates the input URL** to ensure it follows a **valid structure**, is **safe to use** and **not already present in the database.** 

- If the URL passes all checks, the shortening service sends an **internal API request (synchronous POST request or gRPC request)** to the **encoding service** to encode the input URL and generate a unique short URL (e.g., `https://tinyURL/abc123`).

- Once the short URL is generated, the shortening service will store the `short_id → long URL` mapping in a database and return the shortened URL to the user.

---
## Workflow for Redirecting a URL

- The user enters a short URL in the browser. A **GET request** is sent to the **redirection service**.

- The redirection service extracts the **short URL ID** (e.g., `abc123`) and use it to query the database to retrieve the corresponding long URL.

- Once retrieved, the redirection service sends an **HTTP 301 (Permanent) or 302 (Temporary) redirect** response to the browser.

- The browser automatically redirects the user to the **original long URL**.

---
## Schema Design and Storage Estimation

The system requires an efficient schema design to store `short_id → long URL` mappings, ensure fast lookups, and scale to handle billions of requests.

NOTE: There is no semantic relationship between `short_id` and `long URL` .

| Field Name     | Data Type | Description                      |
| -------------- | --------- | -------------------------------- |
| `short_id`     | String    | Unique short code                |
| `long_url`     | String    | Original long URL                |
| `created_at`   | Timestamp | Timestamp of when it was created |
| `expiry_date`  | Timestamp | Expiry date                      |
| `access_count` | Integer   | Number of times accessed         |

- 100 Million URL generation requests per day = 100 Million `shortURL -> longURL` mappings would be added to database daily.
- Considering the system would operate for the next 10 years, total URLs generated in lifetime = 10 Million x 365 days x 10 years = 10^7  x 10 x 400 = 4 x 10^10 = 40 Billion URLs
- Average size of each long URL = 100 characters and short URL = 20 characters. Each character consume 1 byte. Therefore 1 long URL will consume 100 bytes and each short URL will consume 20 bytes.
- Total memory consumption by longURL in lifetime = 100 bytes x 40 Billion = 4 x 10^12 = 4 TB
- Total memory consumption by short URLs in lifetime = 20 bytes x 40 Billion = 800 GB



---
## API Design and Load Estimation

Will use microservices architecture. 

 A URL shortener primarily needs 2 APIs:

Use **Base62 encoding** (0-9, a-z, A-Z) or **hash the URL (SHA-256, MD5)** and take the first **6-8 characters**.

e.g., `https://www.somewebsite.com/articles/how-to-design-a-url-shortener`)

> **NOTE:** We will design the APIs using REST architecture.

---



