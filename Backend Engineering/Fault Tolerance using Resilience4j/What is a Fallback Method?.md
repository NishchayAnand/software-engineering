
The fallback method mechanism works like a try/catch block. If a fallback method is configured, every exception is forwarded to a fallback method executor. The fallback method executor is searching for the best matching fallback method which can handle the exception. Similar to a catch block.

It's important to remember that a fallback method should be placed in the same class and must have the same method signature with just ONE extra target exception parameter.

