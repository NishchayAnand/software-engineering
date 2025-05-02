# Understanding Props in React

Props are a short form for properties, and they refer to the internal data of a component in React.

Two things worth remembering about props are:

1. **We determine the value of a prop and use it as part of the blueprint before the component is built.**
2. The value of a prop will never change, i.e., props are read-only once passed into components. You access a prop by referencing it via the `this.props` property that every component can access.
