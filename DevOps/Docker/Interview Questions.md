# Docker Interview Questions

Q. What is Containerization?

Containerization is a process of bundling an application’s code with all its dependencies and runtime information it needs to run on any infrastructure. 

---

Q. What is a Container Image?

A container image is a lightweight, standalone, and portable packaging format that contains everything needed to run a specific application. This includes the application code, dependencies, runtime, and any configuration files. 

It is essentially a blueprint used to create a running container.

**Real-Life Analogy**: Think about your mobile phone: when you download an app, it’s self-contained and ready to run.

---

Q. What is a Container?

A container is a runnable instance of a container image. 

---

Q. What is a Container Runtime?

A container runtime is software that executes and manages the lifecycle of containers. It takes a container image and runs it as an isolated process on the host operating system.

> Note: A container runtime is usually built into most major operating systems, including Linux and Windows. However, it's not always straightforward to use directly. 

---

Q. What us a Container Engine?

A container engine (e.g. Docker) is a high-level software tool that provides an easy-to-use API to manage containers efficiently. 

It acts as a bridge between the user and the low-level container runtime, simplifying the process of creating, distributing, and running container images on your servers.

---

Q. What are the key advantages of using Docker?

1. **Consistency Across Environments**: Everyone uses the same commands to run the application, no matter what operating system they are using. 

2. **Isolation**: Maintains a clear boundary between the application and its dependencies. Hence, no clashes between applications. 

3. **Portability**: Docker lets us easily move our application different stages. 

4. **Version Control**: Helps us track versions of the application. 

5. **Scalability**: Makes it easier to handle more users by creating copies of the application when needed. 

---

Q. Explain the Docker Workflow.

1. **Docker Client**: User-interface for interacting with Docker. We can issue commands to the Docker client via command line or a graphical user interface instructing it to build, run or manages images and containers.

2. **Docker Host**: The background process responsible for managing containers on the host system. It listens for Docker client commands, creates and manages containers, builds images and handles other Docker related tasks.

3. **Docker Registry (Docker Hub)**: A centralized repository of Docker images. It hosts both public and privates repositories (or packages). When you run a container, Docker may pull the requires images from the registry if it's unavailable locally. 

---

Q. Explain the difference between `CMD` and `ENTRYPOINT` Dockerfile command.

---

Q. What is Docker Compose?

An orchestation tool that allows us to define and manage multi-container docker applications. It uses a YML file to configure services, networks, volumes for your application enable us to run and scale entire application with a single command. 

> NOTE: Docker Compose is installed automatically when you install Docker. 

---

Q. Explain the key disadvantages of Docker Compose?

Can only manage services running on a single server. 

---

