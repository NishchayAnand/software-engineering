# How to connect to services in React?

React does not provide a standard way to get data from network services into your application.

One way to inflate the size of a component is by filling it with networking code. If you aim to create simple code, you should try to strip out networking code from your components.

When making an asynchronous network request, there are three things that we need to track:

1. **The data returned by the request**
2. **Whether the request is still loading the data from the server**
3. **Any errors that might have occurred when running the request**

> **NOTE:** It doesn’t matter whether we are making the requests with `fetch` or `axios` commands, via `Redux` middleware, or through an API query layer like `GraphQL`, our component will always care about data, loading state, and errors.
