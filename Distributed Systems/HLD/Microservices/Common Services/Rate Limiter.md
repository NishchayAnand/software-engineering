# Understanding Rate Limiter System Design

Used to control the rate of traffic sent by a client or a service. If the API request count exceeds the threshold defined by the rate limiter, all the excess calls are blocked.

For example, **Twitter limits the number of tweets to 300 per 3 hours**.

> **NOTE:** Rate limiting is extremely important for companies that use paid third party APIs. For example, you are charged on a per-call basis for services like **make a payment**.

The HTTP 429 response status code indicates a user has sent too many requests.

> **NOTE:** Rate limiting is usually implemented within a component called **API gateway**. If you already used microservice architecture and included an API gateway in the design to perform authentication, IP whitelisting, etc., you may add a rate limiter to the API gateway.

Building your own rate limiting service takes time. If you do not have enough engineering resources to implement a rate limiter, a commercial API gateway is a better option (e.g. Amazon API Gateway Service).
