# Understanding Form State Management in React

The key thing that makes a form element different from all the other HTML elements is that it has to maintain the user input as an internal state until the form is submitted. This internal state can be of multiple types like `String` for the email and a `Boolean` for the remember me checkbox.

The main purpose of a form on a page is to collect user input. This could be for something like signing the user into the app or something like submitting a support query.

Usually, a form will have a `submit` button which when pressed collects user-provided data from all the form elements and sends it to a back-end server for processing.

In plain HTML forms, the `DOM` handles the state data, and that is where the user input is stored.

In React application, we want the React component to maintain the form state rather than plain HTML elements. Since, the form elements themselves will be controlled by the React component, forms in React application are called **controlled forms**. Here, **the user input is pushed to the component as and when it updates.**

In a controlled form, the React component maintains the user input in its state property. **Whenever the component is rendered, the value for the form elements is extracted from the component state and set on the form element's JSX tags. This is the key step which makes the form a controlled form, as the value set on the form element is being controlled by the component.**

When the user interacts with the form, the user input changes are sent back to the component using the `onChange` callbacks on the form elements. On receiving these callbacks, the component updates its state for the element being updated using the `setState` method, which in turn triggers a re-rendering of the form. During this re-render, the form element's value is set using the component's now-updated state (using the `value` attribute).

## Form Validations
