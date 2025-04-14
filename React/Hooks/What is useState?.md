
`useState` is a React Hook that lets you add a **state variable** to your component.

```
const [state, setState] = useState(initialState)
```

The `setState` function returned by `useState` lets you update the state to a different value and trigger a re-render.

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

**Error:** Too many re-renders. React limits the number of renders to prevent an infinite loop.

**What's happening:** React renders the component → `setCount` is called → state updates → re-render → `setCount` is called again... and so on.

**Fix:** Avoid calling `setCount` directly inside the body of the component. Instead, trigger the state update inside an event handler or a side effect (e.g., `useEffect`).

---

When you call a `setState` function, React doesn't immediately update the state and trigger a re-render of the component.


---

React state updates are **asynchronous**. This means that w

block the current process 


> NOTE: If every `setState` call triggered an immediate re-render, your app would re-render too many times, which can degrade performance, especially in large applications.

Instead, React schedules the update to be applied later. Multiple state updates that happen in quick succession (e.g., within the same event handler) are **batched** together. 

> NOTE: The **commit phase** is when React actually commits all the changes to the DOM.

---

**Q. What will be the output when the `Increment` button is clicked?**

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
### Internal Working of useState Hook




