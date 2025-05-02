# Understanding State in React

The _state_ of a React application represents data that has the ability to change over the component’s lifetime.

State and properties have a relationship with each other. When the state of a componnt tree changes, so do the properties. The new data flows through the tree, causing specific leaves and branches to render to reflect the new content.

We incorporate state into a function component using a React feature called **Hooks**. Hooks can contain reusable code logic that is separate from the component tree. They allow us to _hook_ up functionality to our components.

> **NOTE:** A component tree represents a hierarchy of components through which data can flow through as properties.

React ships with several built-in hooks we can use out of the box.

## useState

The `useState` hook is a function that we can invoke to return an array.

- The first value of that array is the state variable we want to use.
- The second value of that array is a state setter function that we can be used to update the state variable.

We can take advantage of array destructuring, which allows us to name our state variable whatever we like.

The value we send to the `useState` function is the default value for the state variable.

When state is updated using the state setter function, React schedules a re-render for that component and any child components that depend on the updated state.

> **NOTE:** Directly mutating the state variable will not trigger a re-render.

### How useState works?

1. Maintains a globalState storing array which will store the states defined in the component.

2. The setState function always update the value of the state in the globalState array and trigger the re-render of the component holding useState functionality which in turns re-render all the child components.

3. Every time the component holding the useState functionality is re-render, the globalState is re-initailized, hence, it is important make sure that the order in which the states defined in the child component remains the same (there shouldn't be a conditional definition of states).
