# Understanding Load Balancer

A load balancer evenly distributes the incoming traffic among web servers that are defined in the load-balancer set.

For better security, private IPs are used for communication between servers.

> NOTE: A private IP is an IP address reachable only between servers in the same network, however, it is unreachable over the Internet.

## EXTRA

- help support multiple stateless instances of our microservices and by routing incoming traffic to these instances using some kind of load sharing algorithm.
- not only help us scale out but also help us create a software architecture that's self healing.
- Another key component required by the load balancer is the service registry. It can either be built into the load balancer or it can be separate system itself.
- A service registry is basically a database that lists all your microservices and each one of their instances by location, for example, IP address and ports.
