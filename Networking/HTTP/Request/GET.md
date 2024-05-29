# Understanding GET Request

## Anatomy of an HTTP GET request

### Request Line:

The path to the resource, and any parameters added to the URL are all included on the request line.

For example: `GET /select/selectBeerTaste.jsp?color=dark&taste=malty HTTP/1.1`. Here,

- **GET:** The HTTP method.
- **/select/selectBeerTaste.jsp?color=dark&taste=malty:** The path to the resource on the web server.
- **HTTP/1.1:** The protocol version that the web browser is requesting.

> **_NOTE:_** In a GET request, parametsr are appended to the first part of the requested URL, starting with a `?`. Parameters are separated with `&`.

### The Request Header

HTTP adds header information to the top of whatever content is in the response. An HTML browser uses that header info to help process the HTML page.

For example:

```
Host: www.wickedlysmart.com
User-Agent: Mozilla /5.0 (Macintosh ...) Gecko/... Netscape/7.1
Accept: text/xml,application/xml,image/png,image/jpeg...
Accept-Language: en-us,...
Accept-Encoding: gzip,...
Accept-Charset: ISO-8859,utf-8,...
Keep-Alive: 300
Connection: keep-alive
```

**Verbal translation of the above HTTP GET request:** GET me the page on host: `www.wickedlysmart.com` that's at `/select/selectBeerTaste.html` and, oh yeah here are the parameters: `color=dark` & `taste=malty`.
