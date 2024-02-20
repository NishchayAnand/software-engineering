/* 
-------------------------------------------------------------------------------------------------------------------------------------------
Understanding the binding of "this" keyword in a function execution context:
-------------------------------------------------------------------------------------------------------------------------------------------

- The binding of "this" keyword in a function execution context depends on how the function is invoked (runtime binding). For example: 

	1. Inside a function declared in global context (standalone function), "this" refers to:
		- the "Window" object (exposes the functionalities of the web browser to the webpage) in browser. 
		- the "Global" object (exposes the functionalities to work with server, for example, access file system or perform network requests) in 
		  Node.

*/

function Func() {
  console.log(this); // will display window object in browser and global object in Node.
}
// UNCOMMENT THIS - Func();

/*

	2. Inside a method of an object, "this" refers to the object.

*/

// object creattion methods ????
let car = {
  brand: "tata",
  belongsTo: function () {
    console.log(this);
  },
};
// UNCOMMENT THIS - car.belongsTo(); // will display { brand: 'tata', belongsTo: Function }

let bike = {
  name: "Honda",
};
bike.belongsTo = car.belongsTo;
// UNCOMMENT THIS - bike.belongsTo(); // will display { brand: 'Honda', belongsTo: Function }

let func1 = car.belongsTo; // 'func1' variable would refer the same function as 'belongsTo' property of 'car' object.
// UNCOMMENT THIS - func1(); // will display the window object in browser and global object in Node, since func is being called as a standalone
// 		 					   function from the global context, not as a method of the car object.

/*

	3. 

*/

/* ---------------------------------------------------------------------------------------------------------------------------------------

    NOTE: Function.prototype.bind() can set the value a function's this regardless of how it's called. 

    - arrow functions don't provide their own "this" binding (rather retains rthe "this value of the enclosing lexical context").  

	- when a function is used as a constructor (using the new keyword), a new object is created, and "this" refers to that newly created object. For example,
		function Constructor() {
  			this.property = 'Value';
  			console.log(this); // Refers to the newly created object
		}
		const instance = new Constructor();

	- arrow functions do not have their own "this" binding. Instead, they inherit the "this" value from the enclosing scope. This behavior is sometimes referred to as "lexical scoping" or 
	  "lexical this". For example, 
		const obj = {
		    arrowMethod: () => {
    			console.log(this); // Refers to the global object.
		};
		obj.arrowMethod();

*/
