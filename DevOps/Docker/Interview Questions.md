# Docker Interview Questions

Q. What is Containerisation?

Containerisation is a process of bundling an application’s code with all its dependencies and runtime information it needs to run on any infrastructure. 

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

3. **Docker Registry (Docker Hub)**: A centralised repository of Docker images. It hosts both public and privates repositories (or packages). When you run a container, Docker may pull the requires images from the registry if it's unavailable locally. 

---

Q. What is a **Dockerfile**?

A **Dockerfile** is a text file containing instructions for building a Docker image. It defines the environment, configurations, dependencies, and commands necessary to create and run a containerised application.

---

Q. Explain key commands in **Dockerfile**.

1. **FROM**: Specifies the base image to use for building a new image. Every Dockerfile must begin with a `FROM` instruction. Sample: `FROM amazoncorretto:17`.

2. **WORKDIR**: Sets the working directory inside the container for subsequent instructions (COPY, RUN, etc.). Sample: `WORKDIR /app` (creates (if it doesn't exist) and switches to the /app directory in the container).

3. **COPY**: Copies the files or directories from the build context to the image. Sample: `COPY target/project.jar app.jar`.

4. **RUN**: Executes a command in the shell during the image build process, typically for installing dependencies or configuring the environment.

5. **EXPOSE**: Declares the port the container listens on at runtime. It's informational and doesn't publish the port. Sample: `EXPOSE 8080`.

6. **ENV**: Set the environment variables during the build process. 

7. **ARG**: Define build time variables. 

8. **VOLUME**: Creates a mount point for externally mounted volumes. 

9. **CMD**: Provides default command to execute when the container starts. 

10. **ENTRYPOINT**: Defines the default executable to run when the container starts. 

---

Q. What do we need to map container's port to a port on your host machine?

A Docker container has its own isolated network, meaning that the services running inside the container (such as a web server) cannot directly communicate with your host machine or the outside world unless you explicitly expose and map the ports.

By mapping a port, you essentially create a tunnel from a specific port on your host machine to the corresponding port inside the container.

**Port Mapping Syntax**

```
docker run -p <host_port>:<container_port> <image_name>
```

---

Q. What is the purpose of `host.docker.internal`?

When you use **`host.docker.internal`** in your container's configuration, it allows the container to refer to the **host machine** and access services running on it (e.g., a local MySQL server, web server).

> NOTE: By default, Docker containers are isolated from the host machine and other containers. The loopback address `127.0.0.1`or `localhost` inside a container refers to the container itself, not the host machine.

---

Q. What is a Docker volume?

A Docker volume is a directory on the host that you can mount into a container, allowing data to persist beyond the lifecycle of the container.

They are completely managed by Docker and are isolated from the core functionality of the host machine.

> NOTE: Volumes are often a better choice than writing data directly to a container, because a volume doesn't increase the size of the containers using it.

---

Q. Explain "mounting a volume into a container".

When a volume is mounted, Docker takes a directory from the host where the volume is stored (e.g., `/var/lib/docker/volumes/` on Linux) and makes it accessible inside the container at the specified mount point. 

The container can then read and write data to this volume, allowing data to persist even if the container is stopped or removed.

---

Q. What is Docker Compose?

An orchestration tool that allows us to define and manage multi-container docker applications. It uses a YML file to configure services, networks, volumes for your application enable us to run and scale entire application with a single command. 

> NOTE: Docker Compose is installed automatically when you install Docker. 

---

Q. Explain the key disadvantages of Docker Compose?

Can only manage services running on a single server. 

---

