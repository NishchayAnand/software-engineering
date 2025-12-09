
---
### Working with path variables

You can use path variables in HTTP API routes.

For example, the `GET /pets/{petID}` route catches a `GET` request that a client submits to ``https://`api-id`.execute-api.`us-east-2`.amazonaws.com/pets/6``.

A _greedy path variable_ catches all child resources of a route. To create a greedy path variable, add `+` to the variable name—for example, `{proxy+}`. The greedy path variable must be at the end of the resource path.

---
### Working with query string parameters

By default, API Gateway sends query string parameters to your backend integration if they are included in a request to an HTTP API.

For example, when a client sends a request to `` https://`api-id`.execute-api.`us-east-2`.amazonaws.com/pets`?id=4&type=dog` ``, the query string parameters `?id=4&type=dog` are sent to your integration.

---
### What is HTTP Proxy Integration?

https://docs.aws.amazon.com/apigateway/latest/developerguide/api-gateway-create-api-as-simple-proxy-for-http.html

---
### Create HTTP proxy integrations for HTTP APIs

An HTTP proxy integration enables you to connect an API route to a publicly routable HTTP endpoint. With this integration type, API Gateway passes the entire request and response between the frontend and the backend.

To set up a route with an HTTP proxy integration that catches all requests, create an API route with a greedy path variable (for example, `/parent/{proxy+}`). Integrate the route with an HTTP endpoint (for example, `https://petstore-demo-endpoint.execute-api.com/petstore/{proxy}`) on the `ANY` method. The greedy path variable must be at the end of the resource path.

**Why `http://13.234.56.78:8084/{proxy}` worked**

When you define a route like:

```
/hotel-service/{proxy+}
```

API Gateway captures the portion after `/hotel-service/` into the route variable `proxy`. If your **integration URI** contains that same token (`{proxy}`), API Gateway substitutes the captured value into the integration URI before calling your backend. So a request to:

```
/hotel-service/api/hotels/health
```

becomes a backend call to:

```
http://13.234.56.78:8084/api/hotels/health
```

— which is exactly what you want. That’s why adding `/{proxy}` in the integration made the proxy-style forwarding work in your setup.