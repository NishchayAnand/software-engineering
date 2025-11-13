
---
### HTTP 4xx Errors

**`HTTP 400 Bad Request`**: This means the request sent to the server was malformed, invalid, or contained incorrect syntax, preventing the server from understanding and fulfilling it.

**`HTTP 401 Unauthorized`**: Represents the request sent by the client to the server that lacks valid authentication.

**`HTTP 401 Forbidden`**: Indicates that the server understood the request but refused to process it.

**`HTTP 404 Not Found`**: This happens when a user tries to access a URL that has been mistyped, moved, or deleted, but the server is still accessible. <span style="color:red;">The browser can successfully connect to the server, but the server reports that the specific resource is missing.</span>

**`HTTP 422 Unprocessable Content`**: The server cannot fulfill the request because the data provided is semantically incorrect or <span style="color:red;">violates certain business rules or constraints</span>. The client should not repeat the exact same request without modification, as the problem lies with the data itself.

**`HTTP 429 Too Many Requests`**: A client error status code indicating that the user has sent too many requests to the server within a specified time frame. This mechanism, known as "rate limiting," is implemented by servers to prevent overload, abuse, and potential <span style="color:red;">denial-of-service (DDoS)</span> attacks.

---
### Difference Between 401 and 403

In short, 401 is about **authentication** (who are you?), and 403 is about **authorization** (what are you allowed to do?). 

A 401 error is a request to log in, while a 403 error is a denial of access despite being logged in.

---
### HTTP 5xx Errors

**`HTTP 500 Internal Server Error`**: A generic error message that the server encountered an unexpected condition.

**`HTTP 502 Bad Gateway`**: The server, acting as a gateway or proxy, received an invalid response from an upstream server.

**`HTTP 503 Service Unavailable`**: The server is temporarily unable to handle the request, often due to being overloaded or down for maintenance.

**`HTTP 504 Gateway Timeout`**: The server, acting as a gateway or proxy, did not receive a timely response from an upstream server.

> **NOTE**: Retrying `500 Internal Server Error` could lead to unwanted side effects, like resending an email multiple times.

---


