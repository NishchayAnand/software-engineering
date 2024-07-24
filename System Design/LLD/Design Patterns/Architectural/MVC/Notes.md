# Understanding MVC (Model-View-Controller) Architecture

MVC is one of the most powerful **compound pattern**.

> **NOTE:** A Compound Pattern combines two or more patterns into a solution that solves a recurring or general problem.

MVC takes the business logic out of the `Servlet`, and puts it in a `Model`, i.e., a reusable plain old Java class.

This allows your business logic to be accessed by different clients, not just the web frontend.

> **NOTE:** The `Model` is a combination of the business data (like the state of a Shopping Cart) and the methods (rules) that operate on that data.
