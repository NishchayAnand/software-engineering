# Understanding Spring Security

When you add the Spring Security framework to your application, it automatically registers a filters chain that intercepts all incoming requests.

 After adding `spring-boot-starter-security`, if we rebuild and run the project and then try to access one of the aforementioned URLs instead of viewing the result, we will be redirected to http://localhost:8080/login. This is default behavior because the Spring Security framework requires authentication out of the box for all URLs.

 This out-of-the-box behavior may be useful for classic MVC web applications where we have session-based authentication, but in the case of single-page applications, it’s usually not useful because in most use cases, we have client-side rendering and JWT-based stateless authentication.


