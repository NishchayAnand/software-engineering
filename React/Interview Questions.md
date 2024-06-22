# React Interview Questions

**Q. What is Hydration?**

In a server-rendered application, HTML for the current navigation is generated on the server and sent to the client. Since the server generated the markup, the client can quickly parse this and display it on the screen.

The JavaScript required to make the UI interactive is loaded after this. The event handlers that will make UI elements like buttons interactive get attached only once the JavaScript bundle is loaded and processed. This process is called hydration.

React checks the current DOM nodes and hydrates them with the corresponding JavaScript.

---

**Q. Why jQuery has fallen out of favor?**

One of the significant criticisms of jQuery is its size. Integrating the full jQuery library into web projects adds extra weight, which can be especially taxing for websites aiming for fast load times.

As the web evolved, so did web browsers. Many features that made jQuery a must-have, such as consistent _DOM manipulation_ or _network-oriented functionality around data fetching_, are now natively and consistently supported across modern browsers. Using jQuery for these tasks in contemporary web development can be seen as redundant, adding an unnecessary layer of complexity.

---

**Q. When to use import React from "react"?**

In modern React applications (React 17 and above), you generally no longer need to explicitly `import React from "react"` in most component files.

When using functional components defined with arrow functions (e.g., const MyComponent = () => {...}), the JSX transformation process is handled automatically. You don't need to import React to use JSX syntax or access React functions like `useState` or `useEffect`.
