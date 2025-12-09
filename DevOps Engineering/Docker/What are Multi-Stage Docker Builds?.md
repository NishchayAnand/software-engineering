
A multi-stage Dockerfile uses multiple `FROM` lines. Each `FROM` starts a new stage, with its own OS + tools.

**Example:**

```
FROM maven:3.9-eclipse-temurin-17 AS builder
# build the jar

FROM eclipse-temurin:17-jre-jammy
# run the jar
```

Here:

- Stage 1 = “builder” → heavy image, contains Maven + JDK
- Stage 2 = runtime → lightweight image, contains only JRE + your final JAR

**Only the last stage becomes your container image**. Everything else is discarded — perfect for production.

---
### Why multi-stage builds exist?

Because different tasks need different tools:

|Task|Needs|Should it be in final image?|
|---|---|---|
|Build Java code|Maven + JDK|❌ No|
|Run Java app|JRE only|✔ Yes|
If you build inside only one image, you would ship Maven + JDK to production — a huge image (700–800 MB), security risk, and unnecessary.

Multi-stage builds solve this cleanly.

---


