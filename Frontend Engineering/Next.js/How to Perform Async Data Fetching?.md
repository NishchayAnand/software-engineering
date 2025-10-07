
---
### Server Side Components

If your `page.tsx` is a Server Component (no `"use client"` at the top), you can make it `async` to fetch data on the server using `await`.

```
export default async function Page() {
  const data = await fetch('https://api.vercel.app/blog')
  const posts = await data.json()
  return (
    <ul>
      {posts.map((post) => (
        <li key={post.id}>{post.title}</li>
      ))}
    </ul>
  )
}
```

When using `async/await` in Server Components, Next.js will opt into **dynamic rendering**. This means the data will be fetched and rendered on the server for every user request. If there are any slow data requests, the whole route will be blocked from rendering.

To improve the initial load time and user experience, you can use **streaming** to break up the page's HTML into smaller chunks and progressively send those chunks from the server to the client.

---
### Client Side Components

If your `page.tsx` is a Client Component (has `"use client"` at the top), you cannot make it `async` to fetch server data directly. Client components must use hooks like `useEffect` to fetch data after render (on the client/browser).

> **NOTE:** We should have a loading state for the initial render to take place for the `useEffect` hook to execute. 

In React (and Next.js client components), **`useEffect` only runs after the initial render** — never before.

That means:

1. When the component first mounts → React renders **immediately**.
2. Then React runs your **`useEffect` callback** (after the first paint).
3. That’s when your **data fetching begins**.
4. Only after the fetch completes → you update state → React re-renders with real data.

So without a loading state, your component would:

- Initially render with **no data (e.g., an empty list or `undefined`)**.
- Then suddenly “pop” in the data after fetch completes.

That creates a **poor user experience** — blank screens, layout jumps, or confusing UI states.

---




