
An **OPTIONS request** is an HTTP method used by clients (like browsers) to ask a server: `“What can you do?”`

It **does not request actual data** — instead, it asks the server which HTTP methods, headers, and features are allowed for a particular resource.

---
### Why does the browser send OPTIONS requests?

Common reasons:

**1. CORS Preflight Request (most common)**

When your frontend (JS running in browser) wants to call a backend hosted on a _different domain_, and it uses:

- Custom headers (`Authorization`, `X-My-Header`, etc.)
- Methods other than GET/POST (`PUT`, `PATCH`, `DELETE`)
- Content-Types other than simple ones (`application/json`, etc.)

➡️ The browser first sends an **OPTIONS** request automatically.

It asks the server:

- **Access-Control-Allow-Origin** ?
- **Access-Control-Allow-Methods** ?
- **Access-Control-Allow-Headers** ?
- **Access-Control-Max-Age** ?

If the server responds correctly, THEN the browser sends the actual GET/POST/PUT request.

---
### What is a Pre-Flight Request?

A **pre-flight request** is a **browser check** that happens **before the actual API request** to ask:

> ❓“Hey server, am I allowed to send this request from this domain with these headers & method?”

It uses this HTTP call:

```
OPTIONS
```

So:

> ✅ **Pre-flight = automatic OPTIONS request sent by the browser before certain API calls**

**Why Does the Browser Send It?**

The browser sends a pre-flight request when your actual API call is considered **“unsafe”** under CORS rules.

This happens if your request uses:

✅ `POST`, `PUT`, `DELETE`  
✅ Custom headers like:

- `Authorization`
- `X-API-KEY`  
    ✅ Content-Type other than:
- `application/x-www-form-urlencoded`
- `multipart/form-data`
- `text/plain`

---

