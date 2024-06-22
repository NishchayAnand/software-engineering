# Understanding Routing in React

The React Router library: `react-router-dom` is a powerful tool for managing routing in React applications. It allows you to synchronize the browser’s current location (URL) with the state of your application. This synchronization ensures that the application can render different components based on the URL, **facilitating navigation within a single-page application (SPA) without requiring a full page reload (client-side routing).**

Here are some key features and concepts of React Router:

## BrowserRouter

`<BrowserRouter>` is one of the routers provided by React Router. It is typically used at the top-level of the application, wrapping the entire application and providing functionality (context) for managing client-side routing.

It uses the **HTML5 history API** to keep the UI in sync with the URL (listening to URL changes in the address bar and triggering component re-renders accordingly).

## Route

`<Route>` is the fundamental building block in React Router for **mapping URLs to specific components** in a React application.

It follows a **declarative routing approach**. This means that each `<Route>` specifies a _path_ and the _component_ that should be rendered when the path matches the current URL. This approach eliminates the need to define **imperative navigation logic**, making the routing logic more intuitive and maintainable.

> **NOTE:** Routes live in the virtual DOM tree of components. However, unlike buttons, text fields, and blocks of text, React routes have no visual appearance.

When the URL changes, React Router compares the current URL pathname with the path prop of each Route component. The first Route with a matching path has its corresponding component rendered.

## Routes

`<Routes>` component serves as a container for defining multiple **Route components** within your React application. It acts as a central location to manage the routing configuration and establish the overall route hierarchy.

## Link

## Redirect
