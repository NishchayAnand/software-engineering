
A **platform** consists of:

**Operating System (OS)**

- `linux`
- `windows`
- `darwin` (macOS)

**CPU Architecture**

Defines the chip instruction set:

| Architecture        | Used by                                |
| ------------------- | -------------------------------------- |
| **amd64 / x86_64**  | Intel/AMD CPUs → many EC2 instances    |
| **arm64 / aarch64** | Apple Silicon (M1/M2/M3), AWS Graviton |
| **arm/v7**          | Raspberry Pis                          |
| **386**             | very old CPUs                          |

A container image **must match** both OS and architecture of the system where it runs.

---
### What is the difference between macOS and AWS EC2?

**On mac:**

- If you use **Intel Mac** → CPU architecture = `amd64`
- If you use **Apple Silicon (M1/M2/M3)** → CPU architecture = `arm64`

**On AWS EC2:**

- Most standard instances (t2, t3, m5, c5, etc.) → `amd64`
- Graviton instances (t4g, m6g, c6g) → `arm64`

---
### Problem: Architecture mismatch

If you build on **Mac M1/M2 → image = linux/arm64** and run on **EC2 Intel → expects linux/amd64**, you will get errors like:

```
exec user process caused: exec format error
```

Or the container won't start at all.

---
### Why Docker images embed architecture?

Because the binaries inside the image (JARs, native dependencies, Node modules, Python wheels) are compiled for a specific CPU.

**Example:**

- A binary compiled for ARM **cannot** run on Intel
- A binary compiled for Intel **cannot** run on ARM
- The kernel won’t even load it

---



