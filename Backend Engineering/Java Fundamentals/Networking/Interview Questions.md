# Networking in Java Interview Questions

**Q1. What is Socket?**

A `Socket` represents a connection between 2 applications which may (or may not) be runnin on 2 different physical machines.

---

Q. Explain common response status?

1. 200 OK: The request succeeded; the requested resource is returned in the response.

2. 201 Created: The request succeeded, and a new resource was created (commonly used with POST requests).

3. 202 Accepted: The request has been accepted for processing, but the processing is not complete.

4. 204 No Content: The request succeeded, but there’s no content in the response body.

5. 400 Bad Request: The server cannot understand the request due to invalid syntax.

6. 401 Unauthorized: Authentication is required to access the requested resource.

7. 404 Not Found: The requested resource could not be found on the server.

8. 429 Too Many Requests: The client has sent too many requests in a given time frame (rate-limiting).
