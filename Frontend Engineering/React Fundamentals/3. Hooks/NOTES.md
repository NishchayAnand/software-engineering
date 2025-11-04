
**Q. What will be the output of the following code?**

```
function App() {
	const [count, setCount] = useState(0);
	
	const increment = () => setCount(count + 1);
	increment();
	
	return <h1>{count}</h1>;
}

export default App;
```

**Error:** `Too many re-renders. React limits the number of renders to prevent an infinite loop.`

---

