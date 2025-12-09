
When you define:

```
WORKDIR /app
```

You are telling Docker:

- “From this line onward, run all commands in `/app`.”
- When the container starts, it will start **inside `/app`** unless overridden.
- Relative paths in subsequent instructions are resolved from `/app`.

---
### Why is it useful?

**Keeps your container organized:** Your application code stays in a predictable folder.

**Avoids hard-coding paths everywhere:** After you set `WORKDIR /app`, you can simply do:

```
COPY . .
RUN npm install
```

instead of:

```
COPY . /app
RUN cd /app && npm install
```

