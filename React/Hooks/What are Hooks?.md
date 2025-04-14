
Introduced in React 16.8, Hooks allow you to **manage component lifecycle and state** without writing class components.

---
### Rules for Using Hooks

1. Do not call Hooks inside loops, conditions, or nested functions. 
2. Always call Hooks at the top level of your React function to ensure that they run in the same order every time a component renders.

---

**Q. What will be the output of the following code?**

```
import { useState } from 'react';

function App() {
	const [count, setCount] = useState(0);
	
	setCount(count + 1);
	
	return <h1>{count}</h1>;
}

export default App;
```

**Error:** `Too many re-renders. React limits the number of renders to prevent an infinite loop.`

**What's happening:** React re-renders the component → `setCount` is called → state updates → re-render → `setCount` is called again... and so on.

**Fix:** Use an effect like `useEffect` to trigger updates **after the component mounts**, not directly during rendering.

```
import { useState, useEffect } from 'react';

function App() {
	const [count, setCount] = useState(0);

	useEffect(() => {
		setCount(count + 1);
	}, []); // Only runs once after the initial render

	return <h1>{count}</h1>;
}

export default App;
```

---

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

**Q. How will the count variable increment in each click?**

```
function App() {
	const [count, setCount] = useState(0);

	const increment = () => {
		setCount(count + 1);
		setCount(count + 1); // Double update in one event
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
