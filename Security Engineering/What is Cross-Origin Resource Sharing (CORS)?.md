
**CORS (Cross-Origin Resource Sharing)** is a **browser security mechanism** that controls how a web page from one origin can make requests to a different origin (domain, port, or protocol).

When your React app tries to call the API:

```
fetch("http://localhost:8080/api/hotels")
```

The browser blocks it **by default** because the domains differ (`3000` ≠ `8080`).

That’s where **CORS** comes in — it lets the backend tell the browser: “Yes, I trust this origin — let it access my data.”

---

It’s a **browser security rule** that says:

> ❝ A website is **NOT allowed to call another website’s API** unless that API explicitly says “I allow this website.” ❞

---
### Why is CORS Essential?

Imagine a scenario where you log into a site, say, `example.com`. This site, after successful authentication, saves a cookie in your browser. Now, let's say you visit a malicious site. Without CORS, this malicious site could make a request to `example.com` and access your data using the saved cookie. This is precisely what CORS intends to prevent.

CORS is a browser mechanism that allows access to resources outside a specific domain. To ensure security, many browsers prohibit cross-origin HTTP requests. 

When the token is sent in the Authorization header, cross-origin resource sharing (CORS) is no longer a problem since it doesn't use user credentials, such as cookies, on requests.

---
### Why CORS Exists (Real-World Reason)

Without CORS, **any website could secretly call your bank APIs** using your logged-in browser session.

Example attack if CORS didn’t exist:

- You’re logged into your bank
- You visit a random website
- That website silently calls:

```
https://yourbank.com/transfer?amount=100000
```

- 💥 Your money is gone

👉 CORS **prevents this** by requiring **explicit permission from the API**.

---
### Access-Control-Allow-Headers

When your browser sends a request like:

```
GET /payment-service/api/pay   HTTP/1.1
Content-Type: application/json
Authorization: Bearer abc123
X-Custom-Header: hotel-client
```

The browser will ONLY send these headers if the server says:

```
Access-Control-Allow-Headers: Content-Type, Authorization, X-Custom-Header
```

Otherwise, the browser blocks the request **before it even reaches your backend**.

---
### Access-Control-Expose-Headers

By default, browsers **hide most response headers** from JavaScript for security.

Example:  
Backend response:

```
HTTP/1.1 200 OK
X-Transaction-Id: 553a9
Set-Cookie: session=abc
X-Ratelimit-Remaining: 97
```

Your JS **cannot read these**:

```
res.headers.get("X-Transaction-Id")  // null
```

Unless the server config includes:

```
Access-Control-Expose-Headers: X-Transaction-Id, X-Ratelimit-Remaining
```

Then your JavaScript CAN read them:

```
const id = response.headers.get("X-Transaction-Id");
```

Use `Access-Control-Expose-Headers` when you want the frontend to read values such as:

- Rate limits
- Pagination headers
- File download tokens
- Trace IDs / Correlation IDs
- Authentication expiry
- Custom metadata

---
