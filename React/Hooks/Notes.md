# Understanding Hooks in React

Introduced in React 16.8, Hooks allow you to **manage component lifecycle and state** without writing class components.

Hooks can contain reusable code logic that is separate from the component tree. They allow us to _hook_ up functionality to our components.

## Rules for Using Hooks

Do not call Hooks inside loops, conditions, or nested functions. Always call Hooks at the top level of your React function to ensure that they run in the same order every time a component renders.
