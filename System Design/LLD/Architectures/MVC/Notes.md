# Understanding Model-View-Controller Pattern (Compound Pattern)

MVC is one of the most powerful compound pattern that combines two or more patterns to solve a recurring or general problem.

The MVC pattern is a design philosophy that divides software applications into three interconnected components to separate internal representations of information from how that information is presented to or accepted from the user. Here’s a breakdown:

## Model

The Model is responsible for the data and the business rules of the application. The Model is unaware of the View and Controller, ensuring that the business logic is isolated from the user interface.

A common practice is to have a **repository layer**, backed by some sort of framework like Hibernate, to bind your code to the database, making it easy to map objects or data structures to and from the database.

- `DAO`: Each DAO is responsible for performing CRUD (Create, Read, Update, Delete) operations and managing data for a specific entity.

## View

The View represents the user interface of the application. It displays data from the Model to the user and sends user commands to the Controller. The View is passive, meaning it waits for the Model to provide data to display and does not fetch or save data directly. The View also does not handle user interaction on its own, but delegates this responsibility to the next component: the Controller.

## Controller

The Controller acts as an interface between the Model and the View. It takes the user input from the View, processes it (with potential updates to the Model), and returns the output display to the View. The Controller decouples the Model from the View, making the system architecture more flexible.
