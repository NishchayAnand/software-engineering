# Understanding Builder Pattern

- Using (multiple) constructors to create instances of classes with a large number of optional attributes is not a good idea.

- For every new optional attribute, we add an additional version of constructor. This can get out of control easily to the point of having a big constructor.

- We can use setter methods to initialize all attributes of an object, but, the problem with constructing an object with setter methods is that the construction is split across multiple method calls and there's no way to enforce setting all the required attributes. This may leave the object in inconsistent state.

- The Builder Pattern offers a solution to the problem of constructing classes with many attributes, especially if they are optional.

- The objective of this pattern is to separate the construction of an object from each representation so that the same constructor process can create different representations.

- Allows declarative programming like method chaining.

- **NOTE: This Pattern is not so popular.**
