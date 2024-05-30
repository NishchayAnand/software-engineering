# Understanding Web Servers

Web servers love serving static web pages. However, if you need just-in-time pages (dynamically-created pages that don't exist before the request) or the ability to write/save data on the server (which means writing to a file or database), you can't rely on web server alone.

The web server application serves only static pages, but a separate "helper" application that the web server can communicate with can build non-static, just-in-time pages.

> NOTE: The request comes in, the helper app "writes" the HTML, and the web server gets it back to the client.

The non-Java term for a web server helper app is `CGI` (Common Interface Gateway) program. `Servlets` and `CGI` both play the role of a helper app in the web server.

## Difference between Servlets and CGI

- **Performance:** CGI scripts are written in `Perl`. With `Perl`, the server has to launch a heavy-weight process for each and every request. With `Java`, the server again needs to launch the heavy-weight `JVM`, however, `Servlets` stay loaded and client requests for a separate `Servlet` resource are handled as **separate threads of a single running `Servlet`. There's no overhead of starting the JVM again and again.**
