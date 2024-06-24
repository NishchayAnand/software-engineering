# Understanding React

React is a JavaScript library for building user interfaces (UIs) for web applications. It was built by Facebook to address the challenges of building complex and interactive user interfaces on the client-side.

React’s value proposition is centered around several key features that make it a powerful and popular library for building user interfaces.

## Component-Based Architecture

While traditional frontend architectures like **MVC (Model-View-Controller)** allowed for logical separation of concerns, the separation often led to intricate dependencies and hard-to-follow logic scattered across `models`, `views`, and `controllers`.

`React`, with its **component-based architecture**, focused on a more general approach of separating concerns into smaller, reusable, and self-contained components, each dedicated to a specific part of the UI and its corresponding behavior.

Integrating state and markup within components simplified the mental model for developers, allowing them to handle changes to a component's state or markup in a single location.

The localized state management reduced the cognitive load on developers by eliminating the need to debug state changes across multiple MVC layers, allowing them to focus their energy on building the core functionalities of their components.

## Unidirectional Data Flow

`AngularJS`, with its **two-way data binding** greatly simplified the interaction between the UI and the underlying data. If the `model` changes, the `view` gets updated automatically to reflect the change, and vice versa. This was a stark contrast to libraries like `jQuery`, where developers had to manually manipulate the DOM to reflect any changes in the data and capture user inputs to update the data.

While advantageous in many contexts, two-way data binding can lead to unintended side effects. In complex applications with many interconnected components, **it becomes quite challenging to identify the origin of a change and how it might have cascaded through the application.** Additionally, it blurs the lines of data ownership between the `view` and the `model`.

React leverages the **one-way binding** concept to prioritize a **unidirectional data flow**, ensuring that data flows from top-level components down to lower-level components, but not vice-versa. This means that changes to the state of a component only affect its children and not its parents or siblings.

Unidirectional data flow maintains a clear and predictable data flow, making the application easier to debug and reason about.

## Declarative UI

React adopts a **declarative approach** to UI manipulation. This means you describe the different states your UI component can have and design the component's rendering logic to handle these states. React automatically takes care of re-rendering the affected parts of the UI whenever the state of your component changes, typically using event handlers.

This declarative approach simplifies reasoning about how your UI will behave at any given moment, making it easier to maintain and understand.

## Virtual DOM

When using imperative DOM manipulation APIs, you typically need to make multiple DOM manipulation calls to achieve the desired state changes. Multiple DOM manipulation calls made in quick succession can lead to increased overhead and slower performance.

React optimizes the UI update process by employing the concept of the **Virtual DOM**. The Virtual DOM is a lightweight, in-memory representation of the actual DOM. When the state of a component changes, React updates the Virtual DOM first. It then efficiently determines the minimal set of changes needed to update the real DOM, applying these changes in a batch. This approach significantly reduces the overhead and improves performance, ensuring smoother and faster UI updates.

## JSX

JSX is a **syntax extension for JavaScript** that allows us to write HTML-like code within our JavaScript code.

> **NOTE:** JSX is not a separate language, but rather a syntax extension that is transformed into regular JavaScript code by a compiler or transpiler.

---

## EXTRA

One of the great features of React is that it has, in many ways, gotten simpler over time. React hooks and the move away from class-based components have removed boilerplate and reduced the amount of code.
