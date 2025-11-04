
The `useMemo()` is a **React Hook** that lets you **memoize** (or remember) the **result of an expensive computation** so that it doesn’t re-run unnecessarily on every render.

```
const memoizedValue = useMemo(() => computeValue(a, b), [a, b]);
```

> **In other words:** It caches the **result** of a calculation, not the function itself.

**Example 1: Without `useMemo`**

```
function RoomList({ rooms }) {
  const sortedRooms = rooms.sort((a, b) => a.price - b.price); // ❌ re-sorts on every render
  return sortedRooms.map(r => <div key={r.id}>{r.name}</div>);
}
```

Even if `rooms` doesn’t change, React re-runs `rooms.sort(...)` on every render — wasting CPU time for large lists.

**Example 2: With `useMemo`**

```
import { useMemo } from "react";

function RoomList({ rooms }) {
  const sortedRooms = useMemo(() => {
    console.log("Sorting rooms...");
    return [...rooms].sort((a, b) => a.price - b.price);
  }, [rooms]);

  return sortedRooms.map(r => <div key={r.id}>{r.name}</div>);
}
```

> **NOTE:** [React Compiler](https://react.dev/learn/react-compiler) automatically memoizes values and functions, reducing the need for manual `useMemo` calls. You can use the compiler to handle memoization automatically.

---
