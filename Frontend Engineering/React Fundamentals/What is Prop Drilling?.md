
**Prop drilling** means passing data from a **parent component** down to deeply nested **child components** — even if the intermediate components **don’t need that data** — just so the final child can use it.

```
function App() {
  const user = { name: "Nish", role: "Developer" };
  return <Parent user={user} />;
}

function Parent({ user }: any) {
  return <Child user={user} />;
}

function Child({ user }: any) {
  return <GrandChild user={user} />;
}

function GrandChild({ user }: any) {
  return <p>Hello {user.name}</p>;
}
```

---
### Why Prop Drilling Is a Problem

1. **Messy & repetitive:** Every intermediate component must accept and forward props.
2. **Hard to maintain:** <span style="color:red;">If your app grows, refactoring component hierarchies becomes painful.</span>
3. **Performance impact:** <span style="color:red;">Re-renders can propagate through many components unnecessarily.</span>
4. **Loss of clarity:** It’s hard to see where data really comes from.

---



