# Understanding Callbacks in JavaScript

A callback is a function that is passed as an argument to another function and is executed after some operation has been completed.

Sample Code:

```
function greet(name, callback) {
    console.log(`Hello, ${name}`);
    callback();
}
```

Callbacks are just the name of a convention for using JavaScript functions. Instead of immediately returning some result like most functions, functions that use callbacks take some time to produce a result. 

> NOTE: Callbacks are widely used in asynchronous programming. 

## Callback Hell

```
function getData(notifySuccess, notifyFailure) {
    Data data = fetchData()
}
```