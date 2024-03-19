# Understanding Polymorphism

Polymorphism literally translates to "having many forms." It reflects the ability of an entity to behave in more than one form.

Polymorphism in object-oriented programming exists in 2 main forms:

1. Dynamic Polymorphism (Runtime Polymorphism)
2. Static Polymorphism (Compile-Time Polymorphism)

## Static Polymorphism (Compile-Time Polymorphism)

`Method overloading` is the primary mechanism for static polymorphism. It allows us to define multiple methods with the **same name but different parameter lists** within the same class. thereby

The method to be called is determined by the compiler at compile time, based on the arguments you provide. This allows for a single method name to represent different functionalities depending on the arguments, offering a kind of flexibility in how the method responds.

> Method Overloading promotes the **"One Name, Different Behaviors"** philosophy behind polymorphism.

## Dynamic Polymorphism (Runtime Polymorphism)

- Achieved through inheritance and method overriding.
- Involves objects of different classes responding differently to the same method call.

Inheritance is a foundation for polymorphism, allowing objects of different subclasses to respond differently to the same method call.

It allows objects of different classes to be treated as objects of a common superclass.

Duck typing is a concept in object-oriented programming that emphasizes the importance of an object's capabilities over its specific class.

The phrase "duck typing" comes from the proverb "If it walks like a duck and quacks like a duck, then it must be a duck." In the context of programming, it translates to:

If an object has the attributes and methods required for a particular task, it can be used for that task, regardless of the object's actual class. This allows objects from different classes to be used interchangeably as long as they provide the required functionality.

Variables of the base type can hold objects of derived type (runtime polymorphism).

- When an object receives a method call, it checks for a corresponding method in its class. If one is found, it is executed. Otherwise the search for a matching method travels up the tree to the
  superclass of the object's class.
- The first method found in the hierarchy takes precedence.

A reference variable of type T can point to an object of itself or to an object of any subclass of T. For example, SuperClass ref = new SubClassObject() -> this is valid statement.

- Overriding is implemented based on the run-time class of objects, i.e., the search will begin from the the class of object created at runtime.
