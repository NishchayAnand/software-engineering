
Q. What is **`Static-Site Generation`**?

Pre-render certain pages and components that have static data when the application is build. We just build them once and render them whenever needed. 

---

Q. What is a **`Client-Only Application`**?

---

Q. What is **`Client-Side Navigation`**?

---

Q. When to use **`Server-Side Components`**?

- Content doesn't need to change after page load.
- Heavy computation or logic that doesn't need to run in the browser.
- Sensitive data is involved (like tokens or DB queries).

---

Q. Explain the limitations of **`Server-Side Components`**.

- Cannot listen to browser events
- Cannot access browser APIs
- Cannot maintain State
- Cannot use Effects

---

Q. What are `Client-Side Components`?

- They run in the browser.
- Necessary for **interactivity**, **state management**, and **event handling**.

---

Two types of logic inside React components:

- **Rendering code** lives at the top level of your component. This is where you take the props and state, transform them, and return the JSX you want to see on the screen. [Rendering code must be pure.](https://react.dev/learn/keeping-components-pure) Like a math formula, it should only _calculate_ the result, but not do anything else.
    
- **Event handlers** are nested functions inside your components that _do_ things rather than just calculate them. An event handler might update an input field, submit an HTTP POST request to buy a product, or navigate the user to another screen. Event handlers contain [“side effects”](https://en.wikipedia.org/wiki/Side_effect_\(computer_science\)) (they change the program’s state) caused by a specific user action (for example, a button click or typing).


