# Understanding API Gateway

An API Gateway is a server or software that acts as a single entry point for multiple backend services in an application. It is a critical component in a microservices architecture, simplifying communication between clients (such as web or mobile apps) and services by abstracting the complexities of the backend.

## Key Features

- **Routing**: Directs incoming API requests to the appropriate backend service.

- **Authentication and Authorization**: Ensures only authenticated and authorized requests are processed.

- **Rate Limiting and Throttling**: Controls the number of requests a client can make in a given time to prevent abuse.

- **Load Balancing**: Distributes incoming requests across multiple service instances to ensure high availability and performance.

## Advantages

- **Simplifies Client Interaction**: Clients interact with a single endpoint instead of multiple services.

- **Security**: Provides centralized authentication, authorization, and encryption.

- **Scalability**: Manages traffic efficiently, improving application scalability.

## EXTRA

We don't want to handle cross cutting concerns like authentication & security, load balancing / circuit breaking, observability (logging, monitoring, metrics), caching, in all backend services. API Gateway allows us to handle all these cross cutting conerns in a single place. 