# HTTP Interview Questions

Q. Explain different categories of HTTP status codes.

1. **1xx Informational**: Request received, continuing process.
2. **2xx Success**: The request was successfully received, understood, and accepted.
3. **3xx Redirection**: Further action needs to be taken to complete the request.
4. **4xx Client Error**: The request contains bad syntax or cannot be fulfilled.
5. **5xx Server Error**: The server failed to fulfill a valid request.

---

Q. Explain common 2xx - Success Responses.

These indicate that the request was successfully processed.

1. **200 OK**: The request was successful, and the server returned the requested data.
2. **201 Created**: A resource has been successfully created as a result of the request.
3. **202 Accepted**: The request has been accepted for processing, but processing is not complete.
4. **204 No Content**: The request was successful, but there is no content to send in the response.

---

Q. Explain common 4xx - Client Error Responses.

These indicate that the client made an error in the request.

1. **400 Bad Request**: The server cannot process the request due to invalid syntax.
2. **401 Unauthorized**: Authentication is required and has failed or not been provided.
3. **403 Forbidden**: The server understood the request but refuses to authorize it.
4. **404 Not Found**: The requested resource could not be found.
5. **405 Method Not Allowed**: The HTTP method used is not supported for the requested resource.
6. **429 Too Many Requests**: The client has sent too many requests in a given amount of time (rate limiting).

---

Q. Explain common 5xx - Server Error Responses.

These indicate that the server encountered an issue while processing the request.

1. **500 Internal Server Error**: A generic error occurred on the server.
2. **501 Not Implemented**: The server does not support the functionality required to fulfill the request.
3. **502 Bad Gateway**: The server, while acting as a gateway or proxy, received an invalid response from the upstream server.
4. **503 Service Unavailable**: The server is not ready to handle the request (e.g., maintenance or overload).
5. **504 Gateway Timeout**: The server, while acting as a gateway or proxy, did not receive a response in time from the upstream server.

---



