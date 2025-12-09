
**Build context = the set of files and folders that Docker sends to the Docker engine during a `docker build`.**

When you run:

```
docker build -t myapp .
```

The `.` means:

➡️ **“Send the entire current directory as the build context to Docker.”**

Docker then uses those files during the build.

---
### How does Docker use the build context?

When the build starts:

1. The Docker CLI **tar**s the entire context directory
2. Sends that tar to the Docker daemon
3. Docker daemon extracts it
4. The Dockerfile's `COPY` and `ADD` instructions only have access to **those** files

If a file is not in the context, Docker **cannot** copy it into the image.

**Example:**

```
project/
  Dockerfile
  src/
  package.json
  .env
  node_modules/
  another-folder/
```

**Command:**

```
docker build -t app .
```

**Context = entire `project/` directory.**

Everything in that folder goes to Docker daemon unless ignored.

---
