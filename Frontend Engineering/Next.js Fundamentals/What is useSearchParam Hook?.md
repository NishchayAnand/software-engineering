
`useSearchParams()` is a **Client Component hook** from:

```
import { useSearchParams } from "next/navigation";
```

It lets you read query params like:

```
const searchParams = useSearchParams();
const orderId = searchParams.get("order_id");
```

But:  
It **depends on browser-only data (the URL)** → which means it **can’t be resolved during server rendering immediately**.

---
### `useSearchParams()` should be wrapped in a suspense boundary

Because Next.js **cannot guarantee that search params exist at render time**.

In **Next.js App Router**, pages are:

- ✅ Server Components by default
- ✅ Streamed to the browser in chunks
- ✅ Hydrated later on the client

But `useSearchParams()`:

| Feature                  | Server       | Client   |
| ------------------------ | ------------ | -------- |
| URL available?           | ❌ Not always | ✅ Always |
| Reads live query string? | ❌            | ✅        |
| Can block rendering?     | ✅ Yes        | ❌        |
So Next.js says:

> “This component might **pause while waiting for client-side navigation data** — therefore, it MUST be wrapped in `<Suspense>`.”

This prevents:

- ❌ Hydration mismatches
- ❌ Build-time crashes
- ❌ UI tearing during streaming

---
### ✅ Why do you need to wrap `useSearchParams()` in `<Suspense>`?

Because:

> **Next.js builds part of your page on the server first, but `useSearchParams()` only works properly in the browser.**

So sometimes, when the page is loading:

- The **server does NOT yet know the URL query values**
- But your component is already trying to **read them**

This can cause crashes or wrong UI.

---

### ✅ What `<Suspense>` does (in simple words)

`<Suspense>` means:

> “Wait a moment before showing this part of the page until the browser is ready.”

So Next.js can safely wait until:

- The page is running in the browser
- The query params are available
- Then your component shows correctly

---
### What happens if you don’t use `<Suspense>`?

You’ll see an error like:

`useSearchParams() should be wrapped in a Suspense boundary`

Because Next.js is protecting you from:

- Broken pages
- Mismatched UI
- Build-time crashes

---
### The real-life analogy

Think of it like this:

- **Server** = kitchen preparing food
- **Browser** = table where food is served
- **useSearchParams()** = asking the customer their name
- **Suspense** = waiter waiting until the customer sits down

You **can’t ask the customer’s name before they arrive** — so you wait.

---
### One-line takeaway

> You wrap `useSearchParams()` in `<Suspense>` because the query parameters only exist in the browser, not immediately on the server.

---
