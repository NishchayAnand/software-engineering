# Interview Questions on HTTP Request

Q1. Which HTTP method would you choose for implementing the 'logout' button on a secure banking site?

A logout request is generally recommended to be a `POST` request. Here's a breakdown of why:

### **Security:**

The logout action usually **involves changing the state of the session on the server** (e.g., invalidating the session token or removing the session from the server).

`GET` requests are considered less secure for modifying server state because the data is sent encoded in the URL. This data can be easily logged in browser history or seen by anyone sniffing network traffic.

> **_NOTE:_** GET makes you vulnerable to CSRF (Cross-Site Request Forgery).

`POST` requests send data in the HTTP message body, which is generally considered more secure as it's not exposed in the URL.

> **_NOTE:_** HTTP basic and form-based authentication approaches do not provide a mechanism for handling logout.

---
