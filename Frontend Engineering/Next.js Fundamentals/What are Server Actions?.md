
Server Actions let you write asynchronous server-side functions directly inside your React components, and then call them as if they were just normal functions from the client.

They’re designed to simplify mutations (like form submissions, database updates, or API calls) without needing a separate API route.

> **NOTE:** Traditionally, you’d build `/api/todo` and call it with `fetch`. With **Server Actions**, you skip that step.

---
### When to use Server Actions?

Use Server Actions for **mutations** (form submits, writes, anything that changes state). For fetching (GET-like reads), prefer server components + fetch (or use/suspense) or client-side fetching when needed.

- Server Actions — best for mutations: POST/PUT/DELETE flows or any user-triggered operation that must run on the server (e.g., create a record, send email, call an API using a secret). They are executed only on the server and are easy to call from forms or client components.
    
- Server components + fetch — best for data fetching (GET). They integrate with Next’s rendering model, caching, streaming, and revalidation. They avoid extra round trips and keep the data fetching logic colocated with the component that renders it.
    
- Client-side fetch / SWR / React Query — best when you need realtime UI updates, optimistic updates, or polling on the client.

---
