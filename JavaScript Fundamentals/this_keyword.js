/* 
-------------------------------------------------------------------------------------------------------------------------------------------
Understanding the binding of "this" keyword in a function execution context:
-------------------------------------------------------------------------------------------------------------------------------------------

- The binding of "this" keyword in a function execution context depends on how the function is invoked (runtime binding). 

- For a standalone function in global context, "this" refers to:
    - the "Window" object in browser. 
    - the "Global" object in Node.

*/

function Func() {
  console.log(this); // will display window object in browser and global object in Node.
}
Func(); // this is same as window.Func() or Global.Func()

/*

    NOTE: Function.prototype.bind() can set the value a function's this regardless of how it's called. 


    - arrow functions don't provide their own "this" binding (rather retains rthe "this value of the enclosing lexical context").  

	- if a function is a method of an object, "this" refers to the object on which the method was invoked. For example, 
		const obj = {
  			method: function() {
    			console.log(this); // Refers to the 'obj' object
			}
		};
		obj.method();

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
