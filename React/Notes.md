# Understanding React

React is a library for building composable user interfaces. It encourages the creation of reusable UI components which present data that changes over time.

Traditionally, web application UIs were built using templates or HTML directives. These templates dictate the full set of abstractions that you are allowed to use to build your UI.

React approaches building user interfaces differently by breaking them into **components**.

---

React is a JavaScript library for building user interfaces (UIs) for web applications. It was built by Facebook to address the challenges of building complex and interactive user interfaces on the client-side.

In a typical React application, the initial page load involves serving a static HTML template from the server. Once the static HTML is loaded in the browser, React takes over the control of rendering and updating the UI dynamically without requiring frequent page reloads.

React is relatively unopinionated about how you build and structure your applications.

By library, we mean `React` provides helpful functions to build UI, but leaves it up to the developer where to use those functions in their application.

## Virtual DOM

In a traditional JavaScript application, you need to look at what data chnaged and imperatively make changes to the DOM to keep it up-to-date. Even `AngularJS`, which provides a declarative interface via **directives** and data binding requires a linking function to manually update DOM nodes.

When using imperative DOM manipulation APIs, you typically need to make multiple DOM manipulation calls to achieve the desired changes (state). Multiple DOM manipulation calls made in quick succession can add up to increased overhead and slower performance.

React employs a concept of Virtual DOM, i.e., a lightweight in-memory representation of the actual DOM, to optimize the process of updating the UI.

Virtual DOM abstracts:

1. the manual DOM manipulations away from the developer, allowing them to focus on creating UI (components) rather than worrying about managing user interactions.
2. differences between different browsers and provides a consistent API for interacting with the DOM, making it easier to write cross-browser compatible code.

During the initial website load using client side rendering (used by angular.js), JavaScript used to modify the DOM multiple times to get the page up and running. Manipulating dom multiple times lead to multiple rendering (painting) job. Hence, React came up with an idea that rather than manipulating the dom multiple times, we should create a virtual dom, and when the virtual dom is build, peform a diff between virtual dom and actual dom and only perform the task of rendering and painting once.

**Before React**

During the initial load, JavaScript often modifies the DOM multiple times to set up the entire page, making it ready for user interaction. Multiple DOM manipulations induced using JavaScript lead to multiple re-renders, i.e., each time the DOM is modified, the browser must perform a rendering or painting job, which can be an expensive process in terms of performance.

**After React**

During the initial load, React builds the Virtual DOM by constructing a tree structure that mirrors the structure of the actual DOM. This process is typically fast because it's done in memory, not on the screen.

After the Virtual DOM is constructed, React performs a comparison (diffing) between the Virtual DOM and the actual DOM to identify the differences. Only the differences between the two are updated in the real DOM.

When a component's state or props change, React doesn't immediately update the real DOM. Instead, it reconciles the changes in the Virtual DOM first. React employs a "diffing" algorithm to compare the previous Virtual DOM tree with the updated one.

Because React controls the entire update process, it can optimize the changes to minimize the number of DOM manipulations.

React often batches multiple updates and applies them in a single batch, further reducing the number of actual DOM updates. This batching, combined with the Virtual DOM and the one-way data flow, leads to efficient rendering.

**Fast re-rendering:** When a component's state is changed, React:

1. Updates the Virtual DOM with the new representation of the UI
2. Compares it to the previous version of the Virtual DOM (snapshot taken just before the update) to identify the differences, a.k.a "diffs", between the two representations.
3. Batches "diffs" into a single update and applies it to the actual DOM to reflect the updated UI.

The above process, a.k.a "reconciliation", efficiently updates only the parts that need to be changed, i.e., avoids unnecessary DOM manipulations, resulting in optimal performance and improved user experience.

> **NOTE:** Directly (imperatively) manipulating the DOM typically triggers an immediate update in the actual DOM.

## Component Based Architecture

Each component encapsulates its view, state (model) and its rendering logic.

**Better Modularity:** React focuses on a more general approach of separating concerns into smaller, reusable and independent components, where each component only focuses on a specific piece of UI and its associated behavior (encapsulates its own state, markup and functionality).

By keeping the state and markup together, developers can more easily manage the application's complexity and make changes to both the state and the markup of a UI component in a single location.

The component-based architecture results in a more modular codebase, with clear separation of concerns and improved development productivity.

## One Way Rendering / Data Binding

Only Parent components can pass data to their children.

Props (a set of read-only properties) are a way to pass data from a parent component to its child components.

Easier to debug.

React introduced a one-way data flow, which made it easier to optimize the rendering process by minimizing DOM updates.

**Easy debugging:** Data flows down from the top-level component to the ones at the bottom of the tree and not vice-versa. This ensures that the changes made to the state of a component only affects its children and not the parents or siblings. The one-way data flow architecture makes it easier to reason about the behavior of React components, as the flow of data is predictable and easily traceable.

**Declarative UI:** React follows a declarative approach to manipulate the UI, where you can describe the different states that your UI component can be in (design component's rendering logic to handle different states), and React takes care of automatically re-rendering the affected parts of the UI when the state of your component changes (using event handlers). Makes it easier to reason about how your UI will behave at any given moment.
