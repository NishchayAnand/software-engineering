

---
### Early days of web development, i.e., early 2000s

Websites were designed as a collection of individual web pages built using static HTML and CSS. `JavaScript` was primarily used for basic tasks like form validation and simple `DOM` manipulations. It lacked the capabilities to perform asynchronous requests to the server.

Due to the blocking behaviour (web pages becoming unresponsive while awaiting server responses) associated with synchronous server requests and the absence of a standardised data interchange format for cross-system communication, **Server-Side Rendering (SSR)** became the predominant method for generating web content. Every user interaction, such as submitting a form or clicking a link, resulted in a new server request and a full-page reload.

---
### Rise of Asynchronous JavaScript and XML (AJAX), i.e., mid 2000s

The emergence of **Asynchronous JavaScript** and **XML** (`AJAX`) provided a solution for non-blocking server requests and established a standardised data exchange format for cross-system communication. It empowered JavaScript to dynamically update web content without full-page reloads.

While AJAX was a significant step toward creating more interactive and responsive web applications, it still had some limitations:

- Each AJAX request required manual management of the DOM, leading to complex JavaScript code and potential issues with maintainability.

- Navigating to a new page still required a full-page reload.

---
### Introduction of Single-Page Applications (SPAs), i.e., late 2000s and early 2010s

To resolve the issue of full page reloads, developers started shifting the responsibility of generating web pages from the server to the client's browser. This lead to the evolution of **Client-Side Rendering (CSR)**.

CSR begins with the browser retrieving a minimal `HTML` page from the web server, containing the core structure and references to `JavaScript`, `CSS` and other resource files.

Once the initial payload is downloaded, `JavaScript` take over the updating and rendering of the first page.

For subsequent updates, such as navigating to other pages, only the data needed for the new page's content is fetched from the server as all the necessary `JavaScript` and resources have already been downloaded.

`JavaScript` can then selectively re-render specific sections of the page as required, without the need of full-page reloads.

Web applications employing CSR usually have a single `HTML` page serving as the application's container, which is why they are often termed **Single Page Applications (SPAs)**.

The development of SPAs has indeed seen the emergence of multiple libraries and frameworks (for example, `Angular`, `React`), each with its own set of ideologies and approaches.

---
## EXTRA:

In client-side rendering (CSR), the server renders only the bare bones HTML container for a page. The logic, data fetching, templating, and routing required to display content on the page are handled by JavaScript code that executes on the client. CSR became popular as a method of building SPAs.

---

- **Server-side rendering (SSR)**: Rendering the HTML on the server side, which is the most traditional way. Best for static content that require SEO and does not require heavy user interaction. Websites like blogs, documentation sites, e-commerce websites are built using SSR.
- **Client-side rendering (CSR)**: Rendering in the browser, by dynamically adding DOM elements into the page using JavaScript. Best for interactive content. Applications like dashboards, chat apps are built using CSR.

The benefits of having a normalized store are:

- **Reduced duplicated data**: Single source of truth for the same piece of data that could be presented in multiple instances on the UI. E.g. if many posts are by the same author, we're storing duplicated data for the `author` field in the client store.
- **Easily update all data for the same entity**: In the scenario that the feed post contains many posts authored by the user and that user changes their name, it'd be good to be able to immediately reflect the updated author name in the UI. This will be easier to do with a normalized store than a store that just stores the server response verbatim.
