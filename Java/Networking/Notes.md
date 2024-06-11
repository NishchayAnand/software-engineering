# Understanding Networking in Java

One of Java's big benefit is that sending and receiving data over a network is just `I/O` with a slightly different connection stream at the end of the chain.

- `java.net`: Java API Networking Package

## Create Connection

Client connects to the server by establishing a **Socket** connection. A `Socket` **(java.net.Socket class)** is an object that represents a network connection two machines.

To make a **Socket** connection, you need to know 2 things about the server:

1. who it is, i.e., IP Address.
2. which port it's running on, i.e., TCP port number.

Sample Code:

```
Socket socket = new Socket("196.164.1.103", 5000);
```

> **NOTE:** A **Socket** connection means the two machines have information about each other, including location (IP address) and TCP port.

## Read Data

To communicate over a **Socket** connection, you use **streams.**

Java regular I/O stream doesn't care what your high-level chain stream is connected to (doesn't care if it's connected to a **Socket** or a **File**). You can simply use a `BufferedReader` to read data from a `Socket`.

Sample Code:

```
InputStreamReader stream = new InputStreamReader(socket.getInputStream());
BufferedReader reader = new BufferedReader(stream);
Spring message = reader.readLine();
```

Here, **InputStreamReader** is a **"bridge"** between the low-level byte stream (like the one coming from the socket) and a high-level character stream (like the `BufferedReader` we're after as our top of the chain stream).

## Write Data

Use `PrintWriter` to write data to a `Socket`.

Sample Code:

```
PrintWriter writer = new PrintWriter(socket.getOutputStream());
writer.println("message to send");
```

Here, `PrintWriter` acts as its own bridge between character data and bytes it gets from the Socket's low-level output stream. By chaining `PrintWriter` to the **Socket's** output stream, we can write **Strings** to the **Socket** connection.

## Threads and I/O

The are where you're most likely to encounter threads in Java is dealing with I/O, and particularly in dealing with network I/O.

In early versions of Java, all I/O was blocking. If your program attempted to read data from a socket and no data was present, the `read()` method would block until at least some data was available.

**Because early versions of Java did not have a way to handle nonblocking I/O, Java servers would typically start a new thread for every client that connected to them.** Java clients would typically start a new thread to send requests to the server so that the rest of the program would remain active while the client was waiting for the response.

In JDK 1.4, this situation changed. Java introduced the NIO (Non-Blocking I/O) package, which allowed developers to utilize nonblocking I/O in their programs.

## Traditional I/O Server

A network server would start a new thread for every client that attaches to the server. **By having a thread associated with each client, we no longer need to worry about other clients within any single thread. We can code our classes as if we were handling a single client at a time.**

The issue with creating a new thread for every new client is that this **can handle only a finite number of clients.**

Two factors limit the number of clients a multithreaded server can handle:

1. The server can start only a certain number of threads.
2. With too many active threads, the total **throughput** of the program suffers (all requests take a very long time).

This approach works only for applications in which the client connections are **short-lived**. It depends on the fact that the threads in the server do not block because they do not read from the client.

This approach could also work if you don't care whether new clients are not always able to connect.

## NIO (Non-Blocking I/O) Server

The traditional I/O server cannot scale up to thousands of clients. Because of this, Java introduced a new I/O package (`java.nio`) in JDK 1.4. The I/O classes in this package allow you to use **nonblocking I/O**.

This removed the need for a new thread for every I/O Socket. Instead, you can have a **single thread that processes all client sockets**. That thread can check to see which sockets have data available, process that data, and then check again for data on all sockets.

Depending on the operations the server has to perform, it may need (or want) to spawn some additional threads to assist with this processing, but the new I/O classes allow you to handle thousands of clients in a single thread.

However, dealing with nonblocking I/O is much harder than dealing with blocking I/O. For example, when you use nonblocking I/O, it's your responsibility to be prepared for a situation in which **all the data you requested may not be immediately available. It's this programming that makes nonblocking I/O more difficult to use**.
