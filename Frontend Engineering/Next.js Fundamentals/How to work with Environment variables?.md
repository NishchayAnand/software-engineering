
In Next.js, **`process.env` is _not automatically available_ on all pages** because of how Next.js handles **server vs client environments**, **bundling**, and **environment variable exposure**.

---
### Root Cause: Next.js does NOT expose env vars to the browser automatically

In Next.js:

- **Server-side code** (API routes, `getServerSideProps`, server components)  
    → has full access to `process.env`

- **Client-side code** (React components, browser JS)  
    → **cannot access `process.env` unless the env var starts with `NEXT_PUBLIC_`**

This is the most important rule.

---
### Why? (The Real Reason)

### ✔ Environment variables are server-only by default

Next.js _does not send_ your `.env` variables to the browser **for security reasons**.

Example:

```
process.env.DB_PASSWORD
process.env.AWS_SECRET_KEY
```

These should **never** end up inside the browser bundle.

---
### Only env vars prefixed with `NEXT_PUBLIC_` get bundled for the client

If your component runs in the browser, it needs:

```
NEXT_PUBLIC_API_URL
NEXT_PUBLIC_ANALYTICS_ID
```

Without this prefix → Next.js **won’t include them** in the client-side bundle.

---
### Client components run in the browser, and the browser has NO `process` object

If you do this **inside** your component:

```
export default function SearchPage() {
  const url = process.env.NEXT_PUBLIC_SEARCH_API_BASE_URL; // ❌
}
```

The browser throws:

```
ReferenceError: process is not defined
```

---
### NEXT_PUBLIC env variables are replaced at _build time_, not runtime

```
const searchAPIUrl = process.env.NEXT_PUBLIC_SEARCH_API_BASE_URL;

export default function SearchPage() { ... }

```

This is the MOST important concept:
### ✔ Next.js replaces:

`process.env.NEXT_PUBLIC_SEARCH_API_BASE_URL`

with the actual value **during the build**, not while the app is running.

So this:

`const searchAPIUrl = process.env.NEXT_PUBLIC_SEARCH_API_BASE_URL;`

gets transformed into:

`const searchAPIUrl = "https://example.com/api/search";`

That happens _before_ the code ever reaches the browser.

---
