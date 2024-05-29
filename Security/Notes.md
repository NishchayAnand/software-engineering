# Understanding Security Fundamentals

A common practice in the custom authentication approach is to retrieve user credentials from a form submission and check against the backend security realms such as **LDAP (lightweight directory access protocol)**.

If the supplied credential is valid, the login action saves some object in the `HttpSession` object. This object's presence in `HttpSession` indicates that the user has logged in to the Web application.

> **_NOTE:_** Applications usually save only the **username** string in the `HttpSession` to denote that the user is logged in.

The logout action simply involves **removing the username** string and calling the `invalidate()` method on the user's `HttpSession` object.
