# Security Interview Questions

Q. What is Authentication?

Authentication is the process of **verifying a user's identity (e.g., username and password)**.

> NOTE: In most use cases, the authentication providers extract user identity information based on credentials from a database and then perform validation. 

---

Q. What is Authorization?

Authorization is the process of **granting or denying access to specific resources or actions** based on the authenticated user's roles and permissions. 

---

Q. How Session-Based Authentication works?

1. **User Login**: The user submits their credentials (e.g., username and password) to the server.

2. **Server Validation**: The server verifies the provided credentials against a database or other authentication mechanism.

3. **Session Creation**: If the credentials are valid, the server creates a session for the user. This session is a record stored on the server, typically in a database or in-memory cache like `Redis`, and contains information about the user, such as: user ID, permissions or roles, session expiration time.

4. **Session ID Generation**: A unique Session ID is generated to identify the session. This ID is a random, long, and secure string that maps to the session data stored on the server.

5. **Session ID Sent to the Client**: The server sends the session ID to the client, typically stored in a browser cookie.

6. **Subsequent Requests**: For each subsequent request, the client includes the session ID (via cookies or headers). The server uses this session ID to retrieve the user’s session data and authenticate the request.

7. **Session Expiry or Logout**: Sessions can expire after a specified period of inactivity or when the user explicitly logs out. The session entry is then removed from the server.

---

Q. Explain the disadvantages of Session-Based Authenication.

- **Scalability Issues**: Maintaining a session store can be resource-intensive, especially for applications with a large number of users.

- **Server Dependency**: Sessions are tied to the server, making it challenging to implement in distributed or cloud-native architectures without additional effort (e.g., shared session storage).

- **Cross-Origin Limitations**: Sessions rely on cookies, which may require special handling for cross-origin requests.

---

Q. What is JWT?

JSON Web Token (JWT) is an open standard that defines a **compact** and **self-contained** way for **securely exchanging information** between parties as a JSON object.

A JWT consists of:

- **Header**: Metadata about the token, including the signing algorithm (e.g., HS256, RS256).

- **Payload**: The claims, which are statements about the user, such as: user ID, token's issued time, token's expiry time.

- **Signature**: A cryptographic signature that ensures the token’s integrity and authenticity.

---

Q. How JWT-Based Authentication works?

1. **User Login**: The user submits their credentials (e.g., username and password) to the server.

2. **Server Validation**: The server validates the credentials against a database or other authentication mechanism.

3. **JWT Generation**: If the credentials are valid, the server generates a JWT. 

4. **Token Sent to Client**: The JWT is sent to the client, typically in the response body, a cookie, or a query parameter. The client stores the token (e.g., in localStorage, sessionStorage, or a cookie).

5. **Subsequent Requests**: For every subsequent request, the client includes the JWT in the Authorization header as a Bearer token: Authorization: Bearer <JWT>. Alternatively, the token can be sent in cookies.

6. **Server Verification**: The server verifies the token by checking the signature using the secret key (HMAC) or public key (RSA/ECDSA).

7. **Validating the claims (e.g., expiration, issuer, audience)**: If valid, the server processes the request.

---

Q. Explain the advantages of JWT-Based Authentication.

- **Compact**: Because of its size, it can be sent through an URL, POST parameter, or inside an HTTP header. Additionally, due to its size its transmission is fast.

- **Self-Contained**: The payload contains all the required information about the user, to avoid querying the database more than once.

- **Information Exchange**: JWTs are a good way of securely transmitting information between parties, because as they can be signed, for example using a public/private key pair, you can be sure that the sender is who they say they are.

- **Stateless Authentication**: The server does not store user sessions. It relies entirely on the JWT for user information.

---

Q.  What is a Resource Server?

A sesource server is responsible for validating access tokens to ensure the requesting client has the necessary permissions to access specific resources.

---

Q. What is an Authorization Server?

An Authorization Server is responsible for authenticating users and issuing tokens to clients (applications) that want to access protected resources on behalf of the user. 

---

Q. Explain Cookie

