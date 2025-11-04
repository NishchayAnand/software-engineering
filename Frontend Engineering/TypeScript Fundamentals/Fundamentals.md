
Static Typing

TypeScript = JavaScript with Type Checking

```
let age: number = 20;
```

---

Q. What is `type`?

`type` is a keyword used to define **custom type aliases**. A type alias lets you give a name to a type — which can be a primitive, union, object structure, or any valid type expression.


```
type ErrorCode = string | number;
type Answer = string | number;
```

The two type aliases above represent alternative names for the same union type: `string | number`. While the underlying type is the same, the different names express different intents, which makes the code more readable.

---

Q. What are function types?

---

Q. What are interfaces?

An interface defines a contract that an object must adhere to.

```
interface client {
	name: string;
	address: string;
}
```

---
