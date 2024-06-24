# Understanding Asynchronous Programming in JavaScript

## Async-Await

The `await` keyword in JavaScript is used to pause the execution of an asynchronous function until a `Promise` (known as `Future` in Java) is resolved or rejected. It can only be used inside an `async` function.

The `await` keyword pauses the execution of the async function in which it appears, but it does not block the main thread. This is one of the key advantages of using `async/await` for handling asynchronous operations in JavaScript.
