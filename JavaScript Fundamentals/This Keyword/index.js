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
let carObj1 = new Car("santro");
// carObj1.getObj(); UNCOMMENT - will display Car { name: 'santro', getObj: Function }

let carObj2 = Car("maruti");
// carObj2.getObj(); UNCOMMENT - will throw "Cannot read properties of undefined" error, since carObj2 here will store the returned value of
// the Car function (undefined).

/*

- Arrow functions do not create their own execution context. Hence, inside an arrow function, "this" retains the "this" value of the enclosing 
  lexical context, i.e., inherits the "this" value from the outer context "where the arrow function is defined".

*/

let arrowFunc = () => {
  console.log(this);
};
arrowFunc(); // UNCOMMENT - will display window object in browser. In Node, it will display {} since the properties of the global object
//                          are shadowed by local variables, making it effectively undefined. ???

let arrowCarObj = {
  name: "scorpio",
  getName: () => {
    console.log(this);
  },
};
arrowCarObj.getName(); // UNCOMMENT - will display {} in Node. ???

// Example of constructor function using arrow function as property.

/* 

NOTE: 

    - Arrow functions should not be used as a method or a constructor function. ???  
    - call() and apply() methods of Function type can be used to set the "this" value when calling a function.  
    - Function.prototype.bind() can set a value to a function's "this" regardless of how the function is called. 

*/
