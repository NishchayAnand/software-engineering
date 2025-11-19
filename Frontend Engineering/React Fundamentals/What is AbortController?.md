
It’s a built-in browser API that lets you **abort/cancel** asynchronous operations like:

- `fetch()`
- some custom async tasks
- timeouts (with wrappers)
- streams

React devs usually use it to **stop a fetch when a component unmounts** — so you avoid:

- Memory leaks
- “Can’t update state on unmounted component” warnings
- Extra useless network calls

---
### Why React cares about it

**Scenario:** You call an API → user navigates away → response comes back → React tries to set state → boom 💥 warning.

`AbortController` prevents that by **killing the request** when the component goes away.

---
### What is `signal`?

`signal` is a property you pass into `fetch()` that comes from an **AbortController**.

```
const abort = new AbortController();

fetch(url, { signal: abort.signal });
```

The `signal` is like a wire connecting the fetch request to the controller.

---
