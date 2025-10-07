
**CORS (Cross-Origin Resource Sharing)** is a **browser security mechanism** that controls how a web page from one origin can make requests to a different origin (domain, port, or protocol).

When your React app tries to call the API:

```
fetch("http://localhost:8080/api/hotels")
```

The browser blocks it **by default** because the domains differ (`3000` ≠ `8080`).

That’s where **CORS** comes in — it lets the backend tell the browser: “Yes, I trust this origin — let it access my data.”

---
