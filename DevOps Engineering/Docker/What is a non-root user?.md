
A **non-root user** in Docker is simply a user inside the container that is _not_ the Linux **root** (superuser).  

By default, **containers run as root**, which is risky. So we often create and run our app using a **non-root user** inside the image.

> NOTE: A **non-root user** is any user that does **not** have admin access.

