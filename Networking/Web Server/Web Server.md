# Understanding Web Servers

A web server is a software program that can deliver the contents of a web application to its clients over the internet.

## How Does a Web Server Work?

A web server works by **listening** for incoming requests from clients (typically web browsers), **processing** those requests, and **sending back** the appropriate responses.

Here's a detailed overview of how a web server operates:

- **Listen for Incoming Connections:** The web server continuously listens for incoming TCP connection requests from clients. It typically does this by creating a `listening socket` and binding it to a specific port on the server.

- **Accept Incoming Connection:** When a client sends a TCP connection request to the server, the server accepts the connection. This involves the server's `listening socket` accepting the incoming connection request and establishing a `connected socket` (communication channel) with the client.

- **Receive HTTP Request:** Once the TCP connection is established, the server receives an HTTP request from the client. This request includes information such as the requested resource (e.g., a URL), HTTP headers, and any additional data (e.g., form submissions).

- **Process Request:** The server processes the received HTTP request to determine how to handle it. This may involve parsing the request to extract relevant information, mapping the request to the appropriate resource or handler (e.g., a file on the server or a dynamic script), and executing any necessary server-side logic.

- **Generate HTTP Response:** After processing the request, the server generates an appropriate HTTP response. This response includes an HTTP status code indicating the outcome of the request (e.g., 200 OK for a successful request), HTTP headers providing additional metadata about the response, and the actual content of the response (e.g., HTML for a webpage).

- **Send Response to Client:** The server sends the generated HTTP response back to the client over the established TCP connection. This involves writing the response data to the `connected socket`, which is then transmitted to the client.

- **Close Connection (Optional):** Depending on the server's configuration and HTTP version (e.g., HTTP/1.0 vs. HTTP/1.1), the server may choose to keep the TCP connection open for future requests from the same client (HTTP keep-alive) or close the connection after sending the response. Closing the connection releases resources on both the server and client sides.

- **Repeat:** The server returns to listening for incoming connections and repeats the process to handle subsequent client requests. This loop continues indefinitely as long as the server is running and accepting connections.

## How Web Servers handle multiple requests?
