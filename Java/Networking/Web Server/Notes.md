# Understanding Web Servers in Java

To write a server application in Java, we need 2 Sockets: A `ServerSocket` which waits for client requests (when a client makes a `new Socket()`) and a plain old `Socket` socket to use for communication with the client.

In the server-side socket setup, an instance of `ServerSocket` class is used to listen on a port known to the client. The client connects to this port as a means to negotiate **a private connection with the server**. Once the data connection has been negotiated, the server and client communicates through the private connection.

## How Single-Threaded Web Server works in Java?

1. Server application makes a `ServerSocket`, on a specific port: `ServerSocket serverSock = new ServerSocket(4242);`. This starts the server application listening for client requests coming in for port 4242.

2. Client makes a `Socket` connection to the server application: `Socket sock = new Socket("190.165.1.103", 4242);`

3. Server makes a new `Socket` to communicate with this client: `Socket sock = serverSock.accept();`. The `accept()` method blocks while it's waiting for a client `Socket` connection. When the client tries to connect, the method returns a plain old `Socket` that knows how to communicate with the client.

> **NOTE:** The `Socket` returned by the `accept()` method is on a different port than the `ServerSocket`, so that the `ServerSocket` can go back to waiting for other clients.

A single-threaded web server can only handle one client connection at a time. **If multiple clients connect concurrently**, they might experience delays or errors.

## How to handle multiple clients?

To handle multiple client, a web server can start a new thread for every client that attaches (connects) to the server.

**By having a thread associated with each client, we no longer need to worry about other clients within any single thread. We can code our classes as if we were handling a single client at a time.**
