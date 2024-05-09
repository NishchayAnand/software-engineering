# Understanding MVC Pattern

The main idea behind MVC is the "Separation of Concerns".

- The main relationship are given by the `composite`, `strategy` and `observer` pattern.
  - The view implements the composite pattern by integrating different UI components together.
  - The relationship between the view and controller can be represented using strategy pattern, where the view delegates the task of getting the result to controller.
  - The model implements the observer pattern by keeping view and controller updated when there is some change in the state.
