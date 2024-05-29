# Understanding an HTTP Request

## Key elements of an HTTP request stream:

1. HTTP method (the action to be performed).
2. The page to access (a URL).
3. Form parameters (like arguments to a method).

## HTTP Request Methods:

- **GET:** The simplest HTTP method whose main job is to ask the server to get a resource and send it back. The resource might be an HTML page, a JPEG, a PDF, etc. Doesn't matter. The point of GET is to get something back from the server.

- **POST:** POST is a more powerful request. It is **like a GET plus plus**. With POST, you can request something and at the same time send form data to the server.

- Other rarely used methods include `HEAD`, `TRACE`, `PUT`, `DELETE`, `OPTIONS`, and `CONNECT`.

> **_NOTE:_** You can send a little data with HTTP GET. However, the amount of data you can send with the GET is limited. The data you send with a GET is appended to the URL up in the browser bar, so whatever you send is exposed.
