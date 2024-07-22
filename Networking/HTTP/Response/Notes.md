# Understanding an HTTP Response

## Key elements of an HTTP response stream:

1. A status code (for whether the request was successful)
2. Content-type (text, picture, HTML, etc)
3. The content (the actual HTML, image, etc)

> NOTE: When the browser gets to an image tag, it generates another HTTP request to go get the resource described.

## Anatomy of an HTTP response

An HTTP response has both the **header** and a **body**.

## Response Header

The header info tells the browser about the protocol being used, where the request was successful, and what kind of content is included in the body.

For example:

```
HTTP/1.1 200 OK
Set-Cookie: JSESSIONID=...
Content-Type: text/html
Content-Length: text/html
Date: Wed, 19 Nov 2003 03:25:40 GMT
Server: Apache-Coyote/1.1
Connection: close
```

Here,

- **HTTP** in Line 1 represents the protocol version that the web server is using.
- **200** in Line 1 represents the HTTP status code for the response.
- **OK** in Line 1 represents the text version of the status code.
- **Content-Type: text/html** in line 3 represents the `MIME` (Multipurpose Internet Mail Extension) type. The `MIME` type tells the browser what kind of data the browser is about to receive so that the browser will know how to render it.

> **_NOTE:_** The `MIME` type value relates to the values listed in the HTTP request's "Accept" parameter.

## Response Body

The body holds the `HTML`, or other content to be rendered.

**Verbal translation of the above HTTP response:** Here's my response to your request. Its type is text/html.

## Response Status

Different response statuses are used to indicate the outcome of an HTTP request. Few of the common HTTP response status codes are listed below:

- **200 OK:** The request was successful, and the server returned the requested resource.
- **400 Bad Request:** The server could not understand the request due to invalid syntax.
- **401 Unauthorized:** The client must authenticate itself to get the requested response.
- **403 Forbidden:** The client does not have access rights to the content.
- **404 Not Found:** The server cannot find the requested resource.
- **500 Internal Server Error:** The server encountered a situation it doesn't know how to handle.
- **502 Bad Gateway:** The server received an invalid response from the upstream server.
- **504 Gateway Timeout:** The server did not received a timely response from the upstream server.
