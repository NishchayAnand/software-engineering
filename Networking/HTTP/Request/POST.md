# Understanding HTTP POST Request

The data to be sent back to the server is known as the **"message body"** or **"payload".**

## Anatomy of an HTTP POST request

### Request Line

For Example:

```
`POST /advisor/selectBeerTaste.do HTTP/1.1`.
```

Here,

- **POST** represents the HTTP Method.
- **/advisor/selectBeerTaste.do** represents the path to the resource on the web server.
- **HTTP/1.1** represents the protocol version that the web browser is requesting.

### Request Header

Usually same as GET request.

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

### Message Body

For Example:

```
color=dark&taste=malty
```

**Verbal translation of the above HTTP POST request:** Please `POST` this to the resource at: at `/advisor/selectBeerTaste.do` and, oh yeah, don't forget to look inside the body for the important data I'm sending.
