# Understanding MainServlet

Putting even marginally complex HTML into the argument to a println() is a compiler error waiting to happen.

You might have to do a ton of work to get the HTMl formatted properly in a way that works in the client's browser, while satisfying the Java rules for what's allowed in a `String` literal.

**For example:** A Lot of `HTML` tags use qoutes around attribute values that can create problem when wrapping the HTML in a String literal. We can replace each of the double qoutes with escape codes, but it all gets insanely error prone.

- `PrintWriter out = response.getWriter();` - The PrintWriter object allows us to write `HTML` text to the response object.
