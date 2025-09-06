
Cookies are a way to store small bits of arbitrary data in your browser. 

While they can be set in the browser, they are more commonly sent to the client from a server for an HTTP request. In the context of session-based authentication, the server will create a cookie to store the session identifier and send it back to the client upon successful sign-in. 

When a request is made, the server checks the session ID associated with the request and looks up which user the session belongs to so it can properly identify who is making the request and apply the appropriate authorization rules.

