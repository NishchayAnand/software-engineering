# Understanding Networking

Three things we have to learn to get the client working are:

1. How to establish the initial connection between the client and server.
2. How to send messages to the server.
3. How to receive messages from the server.

Establishing a connection is a one-time operation (that either works or fails). But after that, the client wants to _send outgoing messages_ and **simultaneously** _receive incoming messages_ from the server.

---

Browser is the piece of software that knows how to communicate with the server. The browsers other big job is to interpret the HTML code and render the web page for the user.

Servers often send the browser a set of instructions written in HTML. The HTML tells the browser how to present the content to the user.

Most of the conversations held on the web between clients and servers are held using the HTTP protocol, which allows simple request and response conversations.

> NOTE: If you are a web server, you speak HTTP (HyperText Transfer Protocol).

TCP (Transmission Control Protocol) is responsible for making sure that a file sent from one network node to another ends up as a complete file at the destination, even though the file is split into chunks when it's sent.

IP (Internet Protocol) is the underlying protocol that moves/routes the chunks (packets) from one host to another on their way to the destination.

**HTTP runs on top of TCP/IP.** Basically, it depends on TCP/IP to get the complete request and response from one place to another.

Every resource on the web has its own unique address, in the URL format.

> **NOTE:** If you try to bind a program to a port that is already in use, you'll get a `BindException`.

## Ports

The internet web (HTTP) server software usually runs on port 80 (it's `443` for `HTTPS`). Think of ports as unique identifiers. A port represents a **logical connection** to a particular piece of software running on the server hardware.

> **_NOTE:_** Ports do not represent a place to plug in physical devices. They're just numbers representing a server application.

Without port numbers, the server would have no way of knowing which application a client wanted to connect to.

If you're writin services (server programs) to run on a company network, you should check with the sys-admins to find out which ports are already taken.

**To establish a secure SSL/TLS connection:**

- **Client Hello:** The client (e.g., web browser) initiates the SSL/TLS handshake by sending a "Client Hello" message to the server.

- **Server Hello:** The server responds with a "Server Hello" message and its SSL/TLS certificate.

- **Certificate Validation:** The client verifies the authenticity and integrity of the server's SSL/TLS certificate, i.e., checks if the certificate is signed by a trusted Certificate Authority (CA), if it is not expired or revoked, and if the domain name matches the server's identity.

- **Public Key Exchange:** Once the client validates the certificate, it extracts the server's public key from the certificate. The client generates a random session key, encrypts it using the server's public key, and sends it back to the server.

- **Session Key Establishment:** The server receives the encrypted session key from the client and uses its private key (kept secret on the server) to decrypt the session key. Both the client and the server now possess the same session key, which can be used for symmetric encryption during the session.

- **Secure Communication:** With the session key established, the client and server can encrypt and decrypt data using symmetric encryption algorithms. This ensures that data exchanged between them is encrypted, making it unreadable to anyone intercepting the communication.

- **Handshake Completion:** The SSL/TLS handshake is complete, and the client and server can proceed with secure communication. They can exchange encrypted data, such as web pages, form submissions, or other application data, using the established secure channel.

> NOTE: Secure Sockets Layer (SSL) and Transport Layer Security (TLS) certificates are used to establish a secure and encrypted connection between a client (such as a web browser) and a server (such as a website or application). - SSL/TLS certificates are issued by trusted Certificate Authorities (CAs).

---

## EXTRA:

Web Services are platform-independent and leverage industry standards like SOAP (Simple Object Access Protocol) or REST (Representational State Transfer) for communication. SOAP uses XML messages for data exchange, while REST uses HTTP verbs and lightweight data formats like JSON.
