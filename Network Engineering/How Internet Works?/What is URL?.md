
Every resource on the web has its own unique address, in the URL format.

Sample URL: `http://www.wickedlysmart.com:80/beeradvice/select/beer1.html`. Here,

- **http** tells the server which communication protocol is being used.

- **www.wickedlysmart.com** represents the unique name of the physical server you're looking for. This name maps to a unique `IP` address.

- **80** represents the port for web server you are sending the request to. Specifying port number is optional. If you don't specify a port in your URL, then port 80 is the default, and as luck would have it, that's the default port for the requested web server.

- **/beeradvice/select/** represents the path to the location, on the server, of the resource being requested.

- **beer1.html** represents the name of the content being requested. This could be an `HTML` page, a servlet, an image, PDF, music, video, or anything on the server that feels like serving. **If this optional part of the URL is left out, most web servers will look for `index.html` by default.**

> **_NOTE:_** You can specify an IP address instead of a server name, but a server name is a lot easier to remember.

## Optional Query String

If the above URL represented a `GET` request, the extra info (parameters) would be appended to the end of this URL, starting with the question mark `?`, and with each parameter (name-value pair) separated by an ampersand `&`.
