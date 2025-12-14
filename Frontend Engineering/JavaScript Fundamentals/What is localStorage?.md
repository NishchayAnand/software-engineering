
The **`localStorage`** is a **browser-provided storage mechanism** that lets web applications **store key–value data on the user’s device** and **persist it even after the browser is closed**.

Think of it as a **small, permanent storage box** inside the browser for your website.

---
### Storing objects (important)

Since `localStorage` only stores **strings**, objects must be serialized:

```
const note = { id: "123", title: "My Note" };

// Save
localStorage.setItem("note", JSON.stringify(note));

// Read
const savedNote = JSON.parse(localStorage.getItem("note")!);
```

---
