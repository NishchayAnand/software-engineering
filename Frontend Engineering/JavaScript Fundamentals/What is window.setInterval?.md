
---
### What does `window.setInterval(tick, 1000)` do?

It runs the function **`tick()` every 1000 milliseconds** — which is **every 1 second**.

That’s it. It’s like telling the browser:

> “Hey, call the `tick` function again and again every second.”

---
### Why use it?

Usually for:

- countdown timers
- updating clocks
- refreshing UI every X seconds
- polling APIs
- animation loops (basic ones)

> In your case (reservation hold timer?), you're probably using it to update the remaining time every second.

---
### Under the hood

`setInterval()`:

- schedules a repeating callback
- doesn't wait for previous execution to finish
- returns an interval ID (important for clearing it)

So:

```
const id = window.setInterval(tick, 1000);
```

You can stop it with:

```
window.clearInterval(id);
```

---
### React Tip (important!)

If you're using this in a React component, you should **always clear the interval** on unmount to avoid memory leaks:

```
useEffect(() => {
  const id = setInterval(tick, 1000);

  return () => clearInterval(id); // cleanup
}, []);
```

---
