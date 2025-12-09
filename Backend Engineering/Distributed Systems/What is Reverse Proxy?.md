
An **Nginx reverse proxy** sits **in front of your backend services** and acts as a single entry point for all incoming requests. It receives the request first, then forwards it to the correct microservice.

Without Nginx, each microservice would need its own public port:

- `http://server:8081`
- `http://server:8082`
- `http://server:8083`
- …

With Nginx, you expose only **port 80 or 443**:

```
http://server/svc1/
http://server/svc2/
```

---
### Summary

A **reverse proxy** simply _forwards requests_ from clients to backend servers.

**Core functions:**

- Routes traffic to backend services
- Hides internal server details
- Load balancing
- SSL termination
- Basic request/response transformation
- Caching (optional)

**Used for:**

- Making multiple services accessible from a single public entry point
- Securing backend services
- Improving performance

Reverse proxy = **traffic router + load balancer**

---
