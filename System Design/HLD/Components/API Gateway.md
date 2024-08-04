## API Gateway

- provides one interface to our back-end microservices for our client applications. Our client applications only need to remember the API Gateway for the data and functionalities they need, therefore, they only need to remember the location of one component instead of having to remember the location of every microservice in the background that they might eventually need.
- basically provides a number of endpoints to our client applications, takes incoming requests on those endpoints and then satisfy those requests by calling our downstream microservices for specific data and functionality.
- The mapping between the endpoints and the downstream microservices in done in the configuaration of API Gateway.
