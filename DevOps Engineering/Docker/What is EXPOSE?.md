
`EXPOSE` in a Dockerfile is an **informational instruction** that declares which port(s) the containerized application _intends_ to listen on.

Example:

```
EXPOSE 8080
```

When someone reads the Dockerfile, they immediately see:

> “Ah, this app uses port 8080.”

