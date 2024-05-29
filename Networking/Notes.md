# Understanding Networking

Browser is the piece of software that knows how to communicate with the server. The browsers other big job is to interpret the HTML code and render the web page for the user.

Servers often send the browser a set of instructions written in HTML. The HTML tells the browser how to present the content to the user.

Most of the conversations held on the web between clients and servers are held using the HTTP protocol, which allows simple request and response conversations.

> NOTE: If you are a web server, you speak HTTP (HyperText Transfer Protocol).

TCP (Transmission Control Protocol) is responsible for making sure that a file sent from one network node to another ends up as a complete file at the destination, even though the file is split into chunks when it's sent.

IP (Internet Protocol) is the underlying protocol that moves/routes the chunks (packets) from one host to another on their way to the destination.

**HTTP runs on top of TCP/IP.** Basically, it depends on TCP/IP to get the complete request and response from one place to another.

---

## EXTRA:

Web Services are platform-independent and leverage industry standards like SOAP (Simple Object Access Protocol) or REST (Representational State Transfer) for communication. SOAP uses XML messages for data exchange, while REST uses HTTP verbs and lightweight data formats like JSON.
