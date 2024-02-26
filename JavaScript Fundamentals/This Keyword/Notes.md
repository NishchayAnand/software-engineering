# Understanding "this" Keyword

The binding of "this" keyword in a **function execution context** depends on how the function is invoked (i.e., the binding is decided at runtime).

## Inside a Standalone Function

Inside a function declared in global context, "this" refers to:

- the `Window` object in browser environment.
- the `Global` object in Node.js environment.

```
let Vehicle = function() {
  console.log(this);
}
Vehicle();
```

> Above code will display **window object in browser** and **global object in Node**.

## Inside a Method of an Object Literal

Inside a method of an object literal, "this" refers to the object itself.

```
let car = {
  brand: "tata",
  belongsTo: Vehicle,
};
car.belongsTo();
```

> Above code will display `{ brand: 'tata', belongsTo: [Function: Vehicle] }`.

## Inside a Constructor Function
