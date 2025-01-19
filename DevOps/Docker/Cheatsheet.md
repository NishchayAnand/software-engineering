# Docker Cheatsheet

##### Build a Docker image for an application using a Dockerfile

```
docker build -t book-movie-service:latest .
```

Here:
- `-t` stands for tag and it assigns a name and optional version tag to the image.
- `book-movie-service` is the name of the image.
- `latest` is the tag (a version of the image). In this case, it's often used as the default tag to indicate the latest stable build.
- `.` represents the context or directory where **Docker** should look for the `Dockerfile` and other files needed for the build. The `.` refers to the current directory where the command is being run.

---
##### Create and start a new container from an image

```
docker run --name movie-service-container book-movie-service:latest
```

---
##### Map a port on your host to a port on the container

```
docker run -p 8080:80 book-movie-service:latest
```

Here:
- `-p 8080:80`: This flag is used to map ports between the host machine and the Docker container.
    - `8080`: This is the **host port** (on your machine) that you want to map.
    - `80`: This is the **container port** (inside the Docker container) that will be exposed to the host. So, this mapping means any traffic sent to port `8080` on your machine will be forwarded to port `80` inside the container.

---
##### View running containers

```
docker ps -a
```

Here:
- `-a` adds all containers (not just running ones) to the output, including:
    - Running containers.
    - Stopped containers.
    - Containers that exited or failed.

---
##### Stop a running Docker container

```
docker stop book-movie-service-container
```

---
##### Start an existing (stopped) Docker container

```
docker start book-movie-service-container
```

---
##### Delete a Docker container

```
docker rm movie-container
```

---
##### Remove a Docker image

```
docker rmi book-movie-service:latest
```

Here:

- `rmi` stands for "remove image." 
- If no tag is specified, Docker uses `latest` by default.

---
