
---
### Create Form Manually

1. We need to handle client side validations
2. We need to make sure the form is not submitted multiple times. 
3. We need to handle state when the value change. It can lead to re-renders of the component and all its child components on every keystroke.

```

```

---
### React Hook Form

`react-hook-form` is a **popular library for managing forms in React**. Its goal is to make working with forms simpler, faster, and more performant compared to traditional controlled components.

Instead of constantly syncing every keystroke with React state (`useState`), it relies on the native DOM input values and only updates state when needed.

React Hook Form takes a slightly different approach than other form libraries in the React ecosystem by using uncontrolled inputs with `ref` instead of depending on the state to control the inputs.

Since it doesn’t re-render the entire form on every change, it’s much faster for large/complex forms.

**Primary Use Case**: <span style="color:green;font-weight:bold;background:beige;">React Hook Form takes advantage of uncontrolled components, letting the browser manage the input state internally while still providing React access to those values when needed. This reduces the need for explicitly wiring up value and onChange, simplifies form code, and improves performance by minimizing unnecessary re-renders.</span>

References

1. https://www.youtube.com/watch?v=u6PQ5xZAv7Q&t=648s

---
### zod





---
### Should we add flex property directly to form or add another div to add formatting to form?

**Adding `display: flex` directly to `<form>`**

```
<form class="flex flex-col gap-4">
  <label>Email <input type="email"></label>
  <label>Password <input type="password"></label>
  <button type="submit">Login</button>
</form>
```

**When to use:**

- If your form itself **is the layout container** (e.g., stacking inputs vertically with `flex-col`, or aligning inputs in a row).
- Keeps markup cleaner (fewer `<div>` wrappers).
- Works best for **simple forms**.

**Wrapping inputs in a `<div>` and styling that**

```
<form>
  <div class="flex flex-col gap-4">
    <label>Email <input type="email"></label>
    <label>Password <input type="password"></label>
    <button type="submit">Login</button>
  </div>
</form>
```

**When to use:**

- If you want the **form** element itself to stay “semantic” (just handling submission), and keep layout separate.
- Useful if you’ll add **extra sections** (like a title, description, or footer) outside the flex container.
- Makes it easier to **nest multiple layouts** inside one form (e.g., horizontal row of inputs + vertical stack below).

---
