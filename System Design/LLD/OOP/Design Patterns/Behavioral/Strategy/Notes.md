# Understanding Strategy Pattern

- Encapsulate behavior in a object to delegate functionality.

- The idea of the Strategy Pattern is for a given interface to assign different variants of an algorithm to different implementations with the choice of which to choose being made at runtime.

- The DAO pattern is a special case of the Strategy design pattern (GoF), in which a specific implementation "strategy" is refactored into an interface to allow it to be changed independently of the coarser-grained object. The Strategy pattern plays a big part in well-designed OO applications, so there's much value in making it as easy as possible to use.

- JNDI Lookup is also based on the Strategy Design Pattern.

- Strategy patterns encapsulate interchangeable underlying algorithms and provide the same interface for accessing such algorithms. A strategy pattern is similar to an adapter pattern, but it is mainly used to provide pluggable policies and algorithmic processing modules in a design.

- "I encapsulated this behavior in an interface, implementing each variation in a class that I will inject in this other class to delegate the behavior".

- Remember as "From Inheritance to Composition with Strategy Pattern".

- Subclass Explosion: It happens when the number of classes needed to have a new functionality to a given class hierarchy grows exponentially.

- Strategy Pattern states that "Define a family of algorithms, encapsulates each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

- In simple words, it allows you to change a part of a system independently of all other parts.

- Based on Design Pattern: "We should separate the behavior that changes from the behavior that stays same."

- Creates a design that encapsulates a family of behaviors into their own set of classes and lets you changes them as runtime.

- It isn't just polymorphism: It uses polymorphism to make behaviors interchaneable, but it can be thought as a mix of the following design principles:
  - Encapsulating what changes
  - Favoring composition over Inheritance
  - Open-Close Principle
  - Programming to interfaces
