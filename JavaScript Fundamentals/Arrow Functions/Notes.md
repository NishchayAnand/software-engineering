# Understanding Arrow Functions

Arrow functions were introduced in ECMAScript 6 (ES6 or ES2015) as a concise way to write functions.

The basic structure of an arrow function is like:

```
const add = (a, b) => {
    return a + b;
};
```

If thes function body only consists of a return statement, we don't need to enclose the statement in curly braces and explicitly use the `return` keyword:

```
const sum = (a, b) => a + b;
```

If the function has only one parameter, the parentheses around the parameter list can be omitted:

```
const sum = a => a + 10;
```

If the function has no parameters, empty parentheses must be used:

```
const sum = () => return 10;
```

## Key Difference between Arrow Functions and Regular Functions

Arrow functions do not create a new execution context when called, instead they inherit the context from the surrounding code.
