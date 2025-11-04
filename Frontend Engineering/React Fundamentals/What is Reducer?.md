
Components with many state updates spread across many event handlers can get overwhelming. For these cases, you can consolidate all the state update logic outside your component in a single function, called a **reducer**.

<span style="color:red;">Reducers are a different way to handle state.</span>  Managing state with reducers is slightly different from directly setting state. Instead of telling React “what to do” by setting state, you specify “what the user just did” by dispatching “actions” from your event handlers.

You can migrate from `useState` to `useReducer` in three steps:

1. **Move** <span style="color:green;">from setting state to dispatching actions</span>.
2. **Write** a reducer function.
3. **Use** the reducer from your component.

---
### Dispatch Method


The object you pass to `dispatch` is called an “action”:

```
function handleDeleteTask(taskId) {  
	dispatch(   
		{  
			type: 'deleted',  
			id: taskId,  
		}  
	);  
}
```

It is a regular **JavaScript** object. You decide what to put in it, but generally it should contain the minimal information about what happened.

> **NOTE:** An action object can have any shape. By convention, it is common to give it a string `type` that describes what happened, and pass any additional information in other fields.

---
### Reducer Function

A reducer function is where you will put your state logic. It takes two arguments, the current state and the action object, and it returns the next state:

```
function yourReducer(state, action) {  
	// return next state for React to set
}
```

> **NOTE:** Because the reducer function takes state as an argument, you can **declare it outside of your component.** This decreases the indentation level and can make your code easier to read.

---
