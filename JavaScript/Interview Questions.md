# JavaScript Interview Questions

Q. What is a `Callback`?

A callback is a function that is passed as an argument to another function and is executed after some operation has been completed. 

Sample Code:

```
function greet(name, callback) {
    console.log(`Hello, ${name}`);
    callback();
}
```

> NOTE: Callbacks are widely used in asynchronous programming. 

---

Q. What is Callback Hell?



---

Q. What is a `Promise`?

Promises help in managing asynchronous operations, such as server requests in JavaScript. Earlier, **callbacks** were used for the same purpose. However, callbacks have limited functionality and, thus, can make the code unmanageable. 

A promise constructor uses a callback with two parameters - resolve and reject - to create a promise. 

---

Q. Difference between `Promise` and `Callback`.