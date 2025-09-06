# Understanding Reactive Programming Paradigm

- Reactive Programmming is a declarative programming paradigm. It is event-driven (react to events), and it focuses in the flow of data.

- The idea is that changes or updates are propagated in a stream to everyone listening for those changes.

- Involves 2 concepts:
  - **Non-Blocking**: the application doesn't wait until the request finishes to handle a new request.
  - **Asychronous**: the application can execute an operation in parallel or in the background, so it execute other things without waiting for the operation to finish.
  - **Declarative**: allow us to emphasize the flow of data by describing what we want to do instead of expicitly writing the boilerplate code that handles the operation to be performed.

  ## Traditional Use Cases

  1. User Events: For example, when user clicks a button. 
