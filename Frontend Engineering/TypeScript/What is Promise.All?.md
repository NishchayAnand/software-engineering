
A very practical pattern in modern JavaScript / TypeScript for making **multiple API calls in parallel** using `Promise.all()`.

```
const [hotelRes, roomTypesRes] = await Promise.all([
  fetch(`${base}/${hotelId}`),
  fetch(`${base}/${hotelId}/room-types`)
]);
```

That means:

- Both `fetch()` calls start **at the same time**.
- You wait (`await`) until **both** of them finish.
- When both are done, you get their results as an array.

> **NOTE:** This saves time because the two network requests happen **concurrently** rather than **sequentially**.

---
