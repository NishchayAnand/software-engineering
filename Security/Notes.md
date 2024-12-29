# Understanding Security Fundamentals

---

A common practice in the custom authentication approach is to retrieve user credentials from a form submission and check against the backend security realms such as **LDAP (lightweight directory access protocol)**.

If the supplied credential is valid, the login action saves some object in the `HttpSession` object. This object's presence in `HttpSession` indicates that the user has logged in to the Web application.

> **_NOTE:_** Applications usually save only the **username** string in the `HttpSession` to denote that the user is logged in.

The logout action simply involves **removing the username** string and calling the `invalidate()` method on the user's `HttpSession` object.

---

Whenever the user wants to access a protected route, it should send the JWT, typically in the Authorization header using the Bearer schema. Therefore the content of the header should look like the following.

Authorization: Bearer <token>

This is a stateless authentication mechanism as the user state is never saved in the server memory. The server’s protected routes will check for a valid JWT in the Authorization header, and if there is, the user will be allowed. As JWTs are self-contained, all the necessary information is there, reducing the need of going back and forward to the database.

---

Cross-Origin Resource Sharing (CORS) won’t be an issue with JWT as it doesn’t use cookies.

---

How JSON Web Tokens work?

1. Browser POST /users/login with username and password.
2. Server creates a JWT with a secret and returns it to the browser.
3. Browser sends the JWT on the Authorization Header.
4. Server checks JWT signature. Get user information from the JWT and sends response to the client. 

> Link: https://www.youtube.com/watch?v=K6pwjJ5h0Gg (Udacity)

---
