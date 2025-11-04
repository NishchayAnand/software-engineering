
**Reducers** let you consolidate a component’s state update logic. **Context** lets you pass information deep down to other components. You can combine reducers and context together to manage state of a complex screen.

```

```

A reducer helps keep the event handlers short and concise. However, as your app grows, you might run into another difficulty. **Currently, the `tasks` state and the `dispatch` function are only available in the top-level `TaskApp` component.** To let other components read the list of tasks or change it, you have to explicitly [pass down](https://react.dev/learn/passing-props-to-a-component) the current state and the event handlers that change it as props.

As an alternative to passing them through props, you might want to put both the `tasks` state and the `dispatch` function [into context.](https://react.dev/learn/passing-data-deeply-with-context) **This way, any component below `TaskApp` in the tree can read the tasks and dispatch actions without the repetitive “prop drilling”.**
