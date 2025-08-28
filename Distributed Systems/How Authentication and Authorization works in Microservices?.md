
---
### Authentication in a microservice architecture

Just like in the monolithic application, a user logs in with a username and password. However, in a microservice architecture, the Backend for Frontend (BFF) - rather than the services - participates in the login process. 

<span style="color:green;font-weight:bold;background:beige;">The BFF maintains the user session, which includes the user’s identity, and issues a session token to the UI.</span>

Another important difference from the monolith is that the business logic that needs the user’s identity cannot simply access the user session via an in-memory mechanism, such as a `ThreadLocal` variable. In a microservice architecture, that business logic is implemented in services that run as separate processes. Consequently, the BFF, which knows the user’s identity (and perhaps their roles), must pass that information to these services.

---
### Disadvantages

But there’s one characteristic of the microservice architecture that can make it challenging for a service to implement authorization: the necessary data might be scattered across multiple services and accessible only via their APIs.

Implementing authentication in a microservice architecture presents two challenges. The first challenge is the decentralized nature of the application. It consists of multiple services, each exposing its own set of REST endpoints. This raises the question: does each service need to implement authentication independently?

> **NOTE:** Each service has an architecture that is similar to that of the monolithic application.

The second challenge is that authentication is inherently complex and error-prone. It requires secure password storage, protection against common attacks such as CSRF, and ongoing compliance with evolving security best practices.

What’s more, applications must sometimes support multiple login mechanisms, including social login providers, which adds further complexity to the authentication logic.

---
### The API Gateway: a central location in a decentralized architecture

In a monolithic architecture, communication between a client, such as a React UI, and the application is relatively straightforward. A client makes requests to one of the monolith’s REST endpoints, such as `GET /securitysystems`, which query and update business entities. 

But in a microservice architecture client-application communication is less straightforward because there isn’t a single set of endpoints. In theory, a client could directly call each service, but a better solution is to implement the **API Gateway pattern**.

**An API Gateway is a service that acts as a single entry point into the application for all client requests.** 

![api-gateway](api-gateway.png)

> **NOTE:** **A variation of the API Gateway pattern is the Backend for Frontend (BFF) pattern**. A BFF is an API Gateway that supports a single frontend (a.k.a. client), such as a React-based UI. Among other things, it provides an API that’s tailored to the needs of the client.

---
### Authenticating an API Client

Let’s imagine the client is an application that makes requests to the API Gateway. In order to access a secured endpoint such as `GET /securitysystems`, **the application can require the client to provide credentials**. The credentials, which identify a client, typically consist of an API Key and possibly a secret, that are passed in the request’s `Authorization` header.

The API Gateway could simply forward the `GET /securitysystems` request to the `Security System Service`, which then authenticates the credentials against a database. The problem with this approach is that every service would need to implement authentication. There’s also the issue of how each service knows the user’s credentials, since services don’t share databases.

A better option is to make the API Gateway responsible for authenticating each request before forwarding it to the appropriate service. This frees the individual services from needing to handle authentication themselves.

---
### Propagating user identity to the services - Authorization

Centralizing authentication in the API gateway simplifies the services. This, however, creates a new problem: if they no longer authenticate the credentials, how do they know the identity of the user? 

For example, the `Security System Service` may need to know which user made the request in order to enforce permissions or record audit information.

The solution is for the API Gateway to propagate the user identity to the `Security System Service` by including it in a request’s header. The `Security System Service` can then use the user identity to, for example, retrieve the user’s security systems from the database or record who changed the state of a security system.

A common way to convey user identity is by passing a JSON Web Token (JWT). A JWT is a signed JSON document containing claims about the user, including their identity and permissions.

The API gateway can pass the JWT in a request header (usually the `Authorization` header), allowing backend services to securely identify the user and enforce authorization - without performing authentication themselves.

---
### Login-based authentication requires session state

The API Gateway authenticates every request from an API Client. If, however, the client is a UI, authentication only happens once - when the user logs into the application. The application typically displays a login page; the user enters their credentials, which are then authenticated by the application. After that, subsequent requests from the UI to the API Gateway must somehow be associated with the client.

The solution is for the login mechanism to create a session that is associated with the user’s identity. The API Gateway returns a session token - typically as a cookie - to the UI. The UI includes this session token in every subsequent request. The API Gateway then maps the session token to the user’s information, which is then propagated to the backend services as before.

> **NOTE:** There are two common ways to implement sessions. The first option is for the session token to act as a session identifier, which the API Gateway uses to retrieve the session state from a database. The second option is for the session token to contain the session state itself. It could, for example, be an encrypted JWT. Each approach has trade-offs in terms of performance, scalability, and revocation capabilities.

---
### Delegating authentication to an identity and access management service

The API Gateway/BFF could implement authentication itself. For an API client, it could authenticate the client’s credentials by verifying that they match what’s stored in a user database and then generating a JWT. Similarly, for a UI, the API Gateway/BFF would display the login page and then authenticate the submitted credentials. 

On the surface, this seems quite straightforward. However, implementing authentication securely is complex and error-prone. It requires secure password storage, protection against common attacks, such as CSRF, and compliance with evolving security best practices. Moreover, applications often need to support multiple login mechanisms, including social logins.

For these reasons, many teams choose to delegate authentication to an identity and access management (IAM) service, which may either run on your infrastructure or be offered as a SaaS solution. **These products typically implement login using a combination of two standards: OAuth 2.0, which is an authorization protocol, and OpenID Connect (OIDC), which is an authentication protocol built on OAuth 2.0.**

Once a user has been authenticated, an OAuth 2/OIDC-based IAM service issues a JWT-based access token that contains the user’s identity and permissions. The `API Gateway/BFF` stores the access token in the session and includes it in requests forwarded to the backend services.

---
### Deploying an IAM service

There are two options for deploying an IAM service. 

1. One option is to host your own IAM service. There are various open-source services to choose from, including Spring Authorization Server and Keycloak. 
2. The other option is to use a cloud-based SaaS solution, such as Okta, AWS Cognito, or Google Identity Platform.

---
### How a backend service obtains the authorization data?

When a backend service, such as the `Security System Service`, receives a request it must perform an authorization check. An authorization check can be modeled by the `isAllowed(user, operation, resource)` function, which verifies that a user can perform a specific operation on a given resource.

For some operations, a `isAllowed()` can make the authorization decision using just the service’s own data and the user identity and roles provided by the access token. A common example is RBAC. The service simply needs the user’s identity and roles from the access token to authorize the request.

However, not all authorization decisions can rely solely on built-in or local data. For many operations, the isAllowed() function also requires remote authorization data—information that is owned by other services. Accessing this remote data introduces additional complexity and service collaboration challenges.

The challenge is that in a microservice architecture, each service’s data is accessible only through its API. To preserve [loose design-time coupling](https://microservices.io/post/architecture/2023/03/28/microservice-architecture-essentials-loose-coupling.html#design-time-coupling-and-development-velocity), which is a defining characteristic of the microservice architecture, the `Security System Service` cannot directly access the `Customer Service’s database.

---
### Strategies for obtaining remote authorization data

There are three different strategies that a backend service’s `isAllowed()` function can use to obtain remote data. In addition, there’s a fourth strategy that uses an entirely different approach to authorization: delegating the authorization decision to a centralized authorization service.

The following diagram summarizes the four strategies:

![backend-service-authorization-server-strategies](backend-service-authorization-server-strategies.png)

There are four strategies:

| Strategy  | Description                                                                         |
| --------- | ----------------------------------------------------------------------------------- |
| Provide   | JWT-based access token provides the remote authorization data                       |
| Fetch     | Backend service fetches the remote authorization                                    |
| Replicate | Backend service maintains a replica of the remote authorization data                |
| Delegate  | Backend service delegates authorization decision-making to an authorization service |

In practice, a backend service’s endpoint will either:

- Use a combination of the first three strategies to obtain the authorization data it needs.
- Delegate to an authorization service

Let’s look at each strategy in more detail.
#### Provide remote authorization data in the access token

One convenient way for a backend service is to obtain the authorization data from other services is to provide it in the access token. When the `IAM Service` issues an access token, it can include the authorization data in the JWT’s claims in addition to the user’s identity and roles. It uses some combination of the `fetch` or `replicate` strategies to obtain the authorization data from the services that own it.

This strategy has some important benefits:
- It simplifies the service
- It can improve runtime behavior by avoid additional inter-service requests

However, this strategy works best with authorization data is:
- small - coarse-grained authorization rather than fine-grained
- stable - unlikely to change frequently

> **NOTE:** It’s also important to remember that the contents of the access token is an application-level design decision. It might not be possible to satisfy the needs of all services using the `provide` strategy. As a result, while convenient in some scenarios, the `provide` strategy is often not the best choice for handling complex authorization requirements in a microservice architecture.
#### Fetch remote authorization data dynamically

If the remote authorization data cannot be passed in the access token, then the backend service can fetch the information from the service that owns it. For example, when handling a `disarm()` request, the `Security System Service` can make an HTTP request to the `Customer Service` to retrieve the user’s organization and their roles in that organization. Not only does this keep the access token lean, but also avoids the risk of stale information in the access token.

However, since this is service collaboration, there are several critical issues that you must carefully consider:

- [Simplicity of communication](https://microservices.io/articles/dark-energy-dark-matter/dark-matter/simple-interactions.html) - the interactions between the two services should be simple and easy to understand
    
- [Efficiency of communication](https://microservices.io/articles/dark-energy-dark-matter/dark-matter/efficient-interactions.html) - the interactions between the two services should be efficient
    
- [Increased runtime coupling](https://microservices.io/articles/dark-energy-dark-matter/dark-matter/minimize-runtime-coupling.html) - the backend service depends on the other service at runtime, which increases its latency and reduces its availability
    
- [Increased design-time coupling](https://microservices.io/articles/dark-energy-dark-matter/dark-matter/minimize-design-time-coupling.html) - the backend service uses the other service’s API, and so there’s a risk that both services need to change in lockstep

As a result, while the `fetch` strategy can work well in some scenarios, it is not always the best solution. For example, in cases where runtime coupling is unacceptable, you may need to consider the `replicate` strategy instead.
#### Replicate remote authorization data from other services

An alternative to a service fetching the information each time, is for it to use the [CQRS pattern](https://microservices.io/patterns/data/cqrs.html) and maintain a local replica of the data within the service’s database. For example, the `Security System Service` can maintain a replica of a customer’s employees, roles and security systems by subscribing to domain events published by the `Customer Service` whenever its data changes.

This strategy has the benefits of keeping the access token lean without the inherent runtime coupling of the `fetch` strategy. Yet at the same, the `replica` strategy is also a form of service collaboration and so has its own drawbacks and limitations:

- Increased complexity and storage requirements - the backend service needs to maintain the replica
    
- [Increased risk of inconsistent data](https://microservices.io/articles/dark-energy-dark-matter/dark-matter/prefer-acid-over-base.html) - the replica may lag behind the source data, leading to authorization decisions based on stale information.
    
- [Increased design-time coupling](https://microservices.io/articles/dark-energy-dark-matter/dark-matter/minimize-design-time-coupling.html) - the backend service uses the other service’s event publishing API, and so there’s a risk that both services need to change in lockstep

#### Delegate to an authorization service

The fourth strategy is for a backend service to delegate the authorization decision to an authorization service, such as [Oso](https://www.osohq.com/cloud/authorization-service) or [AWS Verified Permissions](https://aws.amazon.com/verified-permissions/). Instead of the backend service implementing `isAllowed()`, it simply calls the authorization service to make the decision. The authorization service responds with either `PERMIT` or `DENY`.

A key benefit of this approach is that it simplifies the backend service. It’s no longer responsible for implementing the authorization logic, including obtaining the necessary authorization data. This strategy can significantly reduce application complexity, especially when multiple backend services have complex authorization requirements. Moreover, a centralized authorization service can provide a consistent and correct authorization model across the application, making it easier to manage and maintain.

However, this approach has a few potential drawbacks:

- increased runtime coupling - The backend service is dependent on the availability and performance of the authorization service.
    
- coupling through data dependencies - The authorization service typically needs authorization data from the backend services, which must be obtained using either the `provide`, `fetch` or `replicate`strategies. This creates either design-time or runtime coupling between the authorization service and the backend services.

---
### Using JWT-based access tokens for authorization

---
### EXTRA

Users sit in a single logical cluster with read replicas because read pressure is modest.

**How to implement authorization in a microservice architecture when the necessary data is scattered across multiple services?**

The application has multiple clients. There are human users who use browser-based UI and mobile applications. There are also 3rd party applications that use the application’s REST API.

The **Authentication Service** acts as the **source of truth for identity** and exposes a set of **stable, well-defined auth / identity APIs** to the rest of the platform. These APIs cover **login** (verifying credentials and issuing tokens), **signup** (creating user accounts and storing credentials securely), **token refresh** (rotating refresh tokens and re-issuing JWTs), and **profile CRUD** (managing user attributes such as name, email, phone, preferences, and roles).

When a user logs in, the **User Service** issues two tokens:

1. **Access Token (JWT)** → short-lived (e.g., 5–15 minutes). Used in API requests.
2. **Refresh Token** → long-lived (e.g., days/weeks). Used only to get a new access token.

Because access tokens expire quickly (for security), the client must **“refresh”** them by calling the User Service with its refresh token. The service verifies the refresh token, issues a **new JWT**, and (optionally) rotates the refresh token.

--- 
### References

1. https://microservices.io/post/architecture/2025/05/28/microservices-authn-authz-part-2-authentication.html
