
The `useEffect` hook in React is a powerful tool that allows you to perform side effects in function components. Side effects can include **data fetching** or **manually changing the DOM**.

Here's a basic syntax for using `useEffect`:

```
import React, { useEffect } from 'react';

useEffect(() => {
  // Your side effect code here

  return () => {
    // Cleanup code here
  };
}, [dependencies]);
```

The first argument to `useEffect` is a function where you **perform your side effect**. This function can **return another function**, which will be **used for cleanup.**

The second argument is an optional array of dependencies. **The effect runs whenever one of these dependencies changes. If you omit the array, the effect runs after every render. If you provide an empty array, the effect runs only once.**

The useEffect hook executes inside a browser (a client) only.
