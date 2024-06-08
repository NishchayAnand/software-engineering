# Understanding how to write Web Server in Java

To write a server application in Java, we need 2 Sockets: A `ServerSocket` which waits for client requests (when a client makes a `new Socket()`) and a plain old `Socket` socket to use for communication with the client.

## How it works?

1. Server application makes a `ServerSocket`, on a specific port: `ServerSocket serverSock = new ServerSocket(4242);`. This starts the server application listening for client requests coming in for port 4242.

2. Client makes a `Socket` connection to the server application: `Socket sock = new Socket("190.165.1.103", 4242);`

3. Server makes a new `Socket` to communicate with this client: `Socket sock = serverSock.accept();`. The `accept()` method blocks while it's waiting for a client `Socket` connection. When the client tries to connect, the method returns a plain old `Socket` that knows how to communicate with the client.

> **NOTE:** The `Socket` returned by the `accept()` method is on a different port than the `ServerSocket`, so that the `ServerSocket` can go back to waiting for other clients.
