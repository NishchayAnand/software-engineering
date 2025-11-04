
Introduced in React 16.8, Hooks allow you to **manage component lifecycle and state** without writing class components.

---
### Rules for Using Hooks

1. Do not call Hooks inside loops, conditions, or nested functions. 
2. Always call Hooks at the top level of your React function to ensure that they run in the same order every time a component renders.

---

**Q. How will the count variable increment in each click?**

```
function App() {
	const [count, setCount] = useState(0);
	
	const increment = () => {
		setCount((prevCount) => prevCount + 1);
		setCount((prevCount) => prevCount + 1);
	};

	return (
		<div>
			<h1>{count}</h1>
			<button onClick={increment}>Increment</button>
		</div>
	);
}

export default App;
```

---
