
In React, form inputs are usually controlled like this:

```
const [name, setName] = useState("");

<input 
  type="text"
  value={name}
  onChange={(e) => setName(e.target.value)}
/>
```

Here, you need to manage the state yourself with value and onChange. This way React collects the data for you. We don't need to use `document.querySelector` to get the input from the browser. 

---
### Limitations of Controlled Components

Controlled Components makes it easier to perform real-time validation, and allows React to fully control how and when the UI updates. However, this pattern comes with extra boilerplate code and can hurt performance in large forms, since <span style="color:green;font-weight:bold;background:beige;">every keystroke re-renders the component</span>.

---