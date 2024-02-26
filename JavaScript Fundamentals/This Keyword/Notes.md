# Understanding "this" Keyword

The binding of "this" keyword in a **function execution context** depends on how the function is invoked (i.e., the binding is decided at runtime).

## Inside a Standalone Function

Inside a function declared in global context, "this" refers to:

- the `Window` object in browser.
- the `Global` object in Node.
