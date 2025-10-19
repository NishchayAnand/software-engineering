
the **“mounted flag” pattern** in `useEffect` is a common and practical React technique to prevent **state updates on unmounted components**, which can otherwise cause **memory leaks** or **React warnings** like:

> “⚠️ Warning: Can’t perform a React state update on an unmounted component.”

---
### The Problem

Imagine this:

```
useEffect(() => {
  const fetchData = async () => {
    const res = await fetch("/api/data");
    const data = await res.json();
    setState(data); // ❗ might run after component is unmounted
  };

  fetchData();
}, []);
```

Now suppose:

- The user **navigates away** before `fetch()` finishes.
- The component unmounts.
- When the request finally resolves, `setState(data)` tries to run.

But React says:

> “Hey, this component is gone — you can’t update its state!”

That’s where the **mounted flag pattern** comes in.

---
### The Mounted Flag Pattern

You use a **local variable (flag)** to track whether the component is still mounted.

```
useEffect(() => {
  let isMounted = true; // 👈 flag to track if component is still mounted

  const fetchData = async () => {
    try {
      const res = await fetch("/api/data");
      const data = await res.json();
      if (isMounted) {
        setState(data); // ✅ only update state if still mounted
      }
    } catch (err) {
      console.error(err);
    }
  };

  fetchData();

  return () => {
    isMounted = false; // 👈 cleanup: mark as unmounted
  };
}, []);
```

**What’s happening:**

- `isMounted` starts as `true` when the effect runs.
- The async function runs and starts fetching.
- If the component unmounts before the fetch resolves → React calls the **cleanup function**, setting `isMounted = false`.