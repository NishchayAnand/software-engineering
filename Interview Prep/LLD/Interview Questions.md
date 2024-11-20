# Low Level Design Interview Questions

Q. What is DAO layer?

A DAO layer, or Data Access Object layer, is an architectural pattern that **separates the database access logic from the business logic** in an application.

The DAO allows data access mechanisms to change independently of the code that uses the data.

---

Q. Difference between DAO and DTO.

**DAO** is a design pattern used to abstract and encapsulate all access to a data source (like a database). 

**DTO** is an object used to transfer data between layers. It allows us to control and limit the information that is exposed or transferred between different layers or components of an application.

---

Q. Difference betwen DAO and Repository.

The DAO (Data Access Object) and Repository are both design patterns used in software development to manage data access and interaction with the database. However, they serve slightly different purposes:

- `DAO`: Low-level abstraction, close to the database. Exposes operations like **save()**, **update()**, **delete()**, and **find()**.

- `Repository`: High-level abstraction, closer to the domain logic. Exposes operations like **findUsersByAge()**, **getActiveAccounts()**, etc., which are meaningful in the context of business logic.



