# React Interview Questions

**Q. What is Hydration?**

In a server-rendered application, HTML for the current navigation is generated on the server and sent to the client. Since the server generated the markup, the client can quickly parse this and display it on the screen.

The JavaScript required to make the UI interactive is loaded after this. The event handlers that will make UI elements like buttons interactive get attached only once the JavaScript bundle is loaded and processed. This process is called hydration.

React checks the current DOM nodes and hydrates them with the corresponding JavaScript.

---
