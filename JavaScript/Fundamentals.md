
**Q. Explain `setInterval()` method.**

The **`setInterval()`** method in JavaScript is used to repeatedly execute a **callback function** with a fixed time delay between each call.

```
function sayHello() {
  console.log('Hello!');
}

let delay = 1000;

let intervalId = setInterval(sayHello, delay); // Logs "Hello!" every 1 second
```

> NOTE:  The first execution happens after `delay`milliseconds.

---

**Q. Explain `clearInterval()` method.**

The `setInterval()` method returns a positive integer (typically within the range of `1` to `2,147,483,647`), often referred to as an **interval ID**, that uniquely identifies the interval timer created by the call. 

This **interval ID** can be passed to `clearInterval()` method to stop the repeated execution of the specified function.

```
clearInterval(intervalID)
```

---





