# Understanding Networking

Browser is the piece of software that knows how to communicate with the server. The browsers other big job is to interpret the HTML code and render the web page for the user.

Servers often send the browser a set of instructions written in HTML. The HTML tells the browser how to present the content to the user.

Most of the conversations held on the web between clients and servers are held using the HTTP protocol, which allows simple request and response conversations.

> NOTE: If you are a web server, you speak HTTP (HyperText Transfer Protocol).

TCP (Transmission Control Protocol) is responsible for making sure that a file sent from one network node to another ends up as a complete file at the destination, even though the file is split into chunks when it's sent.

IP (Internet Protocol) is the underlying protocol that moves/routes the chunks (packets) from one host to another on their way to the destination.

**HTTP runs on top of TCP/IP.** Basically, it depends on TCP/IP to get the complete request and response from one place to another.

Every resource on the web has its own unique address, in the URL format.

## Ports

The internet web (HTTP) server software usually runs on port 80 (it's `443` for `HTTPS`). Think of ports as unique identifiers. A port represents a **logical connection** to a particular piece of software running on the server hardware.

> **_NOTE:_** Ports do not represent a place to plug in physical devices. They're just numbers representing a server application.

Without port numbers, the server would have no way of knowing which application a client wanted to connect to.

If you're writin services (server programs) to run on a company network, you should check with the sys-admins to find out which ports are already taken.

---

## EXTRA:

Web Services are platform-independent and leverage industry standards like SOAP (Simple Object Access Protocol) or REST (Representational State Transfer) for communication. SOAP uses XML messages for data exchange, while REST uses HTTP verbs and lightweight data formats like JSON.
