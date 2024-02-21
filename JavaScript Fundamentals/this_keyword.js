/* 
-------------------------------------------------------------------------------------------------------------------------------------------
Understanding the binding of "this" keyword in a function execution context:
-------------------------------------------------------------------------------------------------------------------------------------------

- The binding of "this" keyword in a function execution context depends on how the function is invoked (runtime binding). For example: 

	1. Inside a function declared in global context (a.k.a standalone function), "this" refers to:
		- the "Window" object (exposes the functionalities of the web browser to the webpage) in browser. 
		- the "Global" object (exposes the functionalities to work with server, for example, access file system or perform network requests) in 
		  Node.

*/

function Vehicle() {
  console.log(this);
}
// Vehicle(); // UNCOMMENT - will display window object in browser and global object in Node.

/*

	2. Inside a method of an object, "this" refers to the object.

*/

// Object Literals: Example 1
let car = {
  brand: "tata",
  belongsTo: function () {
    console.log(this);
  },
};
//car.belongsTo(); // UNCOMMENT -  will display { brand: 'tata', belongsTo: Function }

// Object Literals: Example 2
let bike = {
  name: "Honda",
};
bike.belongsTo = car.belongsTo;
// bike.belongsTo(); // UNCOMMENT - will display { brand: 'Honda', belongsTo: Function }

let truck = car.belongsTo;
// truck(); // UNCOMMENT - will display the window object in browser and global object in Node, since func is being called as a standalone
// 			   			   function from the global context, not as a method of the car object.

/*

	3. inside a method of a constructor function, "this" refers to the calling object.

*/

function Car(name) {
  this.name = name;
  this.getObj = function () {
    console.log(this);
  };
}
let carObj = new Car("santro");
carObj.getObj();

/*

	- inside an arrow function (doesn't provide their own "this" binding), "this" retains the "this" value of the enclosing lexical context.

*/

/* 

NOTE: Function.prototype.bind() can set the value a function's this regardless of how it's called. 

*/
