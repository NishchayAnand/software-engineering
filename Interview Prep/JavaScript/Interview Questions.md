# JavaScript Interview Questions

Q. Explain the phrase "JavaScript is single-threaded".

JavaScript itself does not provide the capability to directly create or manage additional threads. Instead, the browser or Node.js runtime handles the heavy lifting by running background tasks in separate threads.

> NOTE: The threads used by the browser or Node.js runtime do not run JavaScript code but instead handle tasks like network requests or file I/O. 

---

Q. How does browsers handle network requests?

Browsers handle network requests using low-level programming languages that interact closely with system-level networking APIs. 

> NOTE: Commonly, C++, C, or sometimes Rust are used to implement the networking layer in modern browsers. 

---
Q. What are Web APIs in browser?

Web APIs provided of the browser act as auxiliary systems for handling time-consuming tasks asynchronously.

The browser offloads Web API calls to different threads or subsystems, allowing JavaScript to remain non-blocking and single-threaded while handling asynchronous tasks efficiently.

---

Q. What is a `Callback`?

A callback is a function that is passed as an argument to another function and is executed after some operation has been completed. 

---

Q. What is Callback Hell?



---

Q. What is a `Promise`?

Promises help in managing asynchronous operations, such as server requests in JavaScript. Earlier, **callbacks** were used for the same purpose. However, callbacks have limited functionality and, thus, can make the code unmanageable. 

A promise constructor uses a callback with two parameters - resolve and reject - to create a promise. 

---

Q. Difference between `Promise` and `Callback`.

---

Q. What is `Async/Await`?