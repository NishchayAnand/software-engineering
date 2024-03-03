# Understanding "this" Keyword in Browser Environment

The `this` keyword is a reference variable pointing to the object that is currently executing the code. (wrong -> consider arrow function as method of an object)

In JavaScript, it is usually determined by how a function referencing the "this" keyword is invoked.

## In Standalone Regular Functions

For a function in the global context, "this" keyword refers to the **global** object.

> In a browser environment, the global object is `window`.

```
// Regular Function declared using function expression in the global context.

const Vehicle = function() {
  console.log(this);
}
Vehicle();

// Above code will display window object in browser environment and global object in Node.js environment.
```

## In Standalone Arrow Functions

## In Constructor Function

Inside a method of a constructor function, "this" refers to the object instance.

## In Methods of an Object Literal

Inside a method of an object literal, "this" refers to the object itself.

```
let car = {
  brand: "tata",
  belongsTo: Vehicle,
};
car.belongsTo();
```

> Above code will display `{ brand: 'tata', belongsTo: [Function: Vehicle] }`.
