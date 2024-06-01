# Understanding MVC (Model View Controller) Architecture

With MVC the business logic is not only separate from the presentation, it doesn't even know that there _IS_ a presentation.

The essence of MVC is that you separate the business logic from the presentation, but put something _between_ them so that the business logic can stand on its own as a reusable `Java` class, and doesn't have to know anything about the view.

If you mix your business logic into a servlet, you can't reuse the business logic for some other kind of view.

> NOTE: Your business logic shouldn't be stuck in a servlet. It should be in a standalone java class that can be easily reused.

MVC takes the business logic out of the `Servlet`, and puts it in a `Model`, i.e., a reusable plain old Java class.

This allows your business logic to be accessed by different clients, not just the web frontend.

> NOTE: The `Model` is a combination of the business data (like the state of a Shopping Cart) and the methods (rules) that operate on that data.

## Components of MVC:

### View

Responsible for the presentation.

### Controller

Takes user input from the request and figures out what it means to the model.

Tells the model to update itself, and makes the new model state available for the view.

> NOTE: The Servlet act as the Controller.

### Model

Holds the real business logic and the state. In other words, it knows the rules for getting and updating the state.

For example, the Shopping Cart's contents (and the rules for what to do with it) should be part of the Model in MVC.

It's the only part of the system that talks to the database (although it probably uses another object for the actual DB communication).

> MVC is not specific to `Servlets` and `JSPs`.
