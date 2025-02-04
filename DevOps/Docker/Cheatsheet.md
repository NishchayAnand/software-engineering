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
##### Create a Docker Volume

```
docker volume create app_logs
```

---
##### Inspect a Docker volume

```
docker volume inspect book_movie_service_logs
```

---
##### Run a Docker container with a named volume

```
docker run -d \
	--name book-movie-service-container \
	-v book-movie-service-logs:/var/log/book-movie-service \
	-p 8080:8080 \
	book-movie-service-image
```

Here:

- `-d`: Runs the container in detached mode (in the background). This mode is often preferred in production environments when you don't need to interact with the container’s output directly.

- `-v book_movie_service_logs:/var/log/book-movie-service`: Mounts a Docker volume called `book_movie_service_logs` to `/var/log/book-movie-service` inside the container.

---
##### Pull a Docker image from Docker Hub

```
docker pull mysql:9.1.0
```

---
##### Execute command inside a running Docker container

```
docker exec -it mysql-container mysql -u root -p
```

Here:

- **`docker exec`**: Allows you to interact with the container's filesystem and execute commands as if you were directly logged into the container.

- **`-i`**: This option stands for **interactive**. It keeps the input stream open, allowing you to interact with the container.

- **`-t`**: This option allocates a **pseudo-TTY** (terminal), so you get a terminal-like interface. It’s needed for interacting with the command line inside the container.

- **`mysql`**: Command-line client for MySQL, used to interact with a MySQL server directly from the command line.

- **`-u root`**: This flag specifies the **username** to log in with. In this case, `root` is the default MySQL administrator user. You can replace `root` with any valid MySQL user in your database.

- **`-p`**: This flag tells MySQL to prompt you for the password associated with the user (`root` in this case).

---
##### Create a Docker Bridge Network

```
docker network create book-movie-network
```

---
##### View logs of a running container

```
docker logs book-movie-container
```

---

