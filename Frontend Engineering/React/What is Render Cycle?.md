
A **render cycle** is the full process React follows whenever something (like a state update) causes a component to change.

Think of it like a **two-step pipeline** that happens every time React needs to update the UI:

---
### The Two Main Phases of a Render Cycle

1. **Render Phase** (aka "Preparation")
    - React _calls your component functions_ to generate the updated Virtual DOM.
    - It does **not** touch the actual screen (DOM) yet.
    - It calculates what changed.
 
2. **Commit Phase** (aka "Execution")
    - React **compares** the new Virtual DOM with the previous one (this is called “diffing”).
    - It applies only the **necessary changes** to the real DOM.
    - It also runs effects like `useEffect`, `ref` updates, etc.

---
