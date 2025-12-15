
`useCallback` is a React Hook that **memoizes a function** so that **the same function reference is reused between renders**—unless its dependencies change.

In simple words:

> **It prevents your function from being recreated on every render.**

---
### Basic Syntax

```
const memoizedFn = useCallback(() => {
  // logic
}, [dependencies]);
```

---
### Very important rule

`useCallback` does **NOT** make code faster by default

It only helps when:

- Function is passed to a memoized child
- Function is used in `useEffect` dependencies
- Function is expensive to recreate
- Stable references are required

---
