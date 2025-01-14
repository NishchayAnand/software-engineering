# Understanding Dockerfile 

## KEY COMMANDS

1. **FROM**: Specify the base image to use for the new image

2. **WORKDIR**: Sets the working directory for the following instructions. 

3. **COPY**: Copies the files or directories from the build context to the image. 

4. **RUN**: Executes commands in the shell during image build.

5. **EXPOSE**: Informs Docker that the container listens on specified network ports at runtime. 

6. **ENV**: Set the environment variables during the build process. 

7. **ARG**: Define build time variables. 

8. **VOLUME**: Creates a mount point for externally mounted volumes. 

9. **CMD**: Provides default command to execute when the container starts. 

10. **ENTRYPOINT**: Defines the default executable to run when the container starts. 