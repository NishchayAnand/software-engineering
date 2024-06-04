# Understanding Spring Security

- `DelegatingFilterProxy` - **springSecurityFilterChain**

```
<filter>
    <filter-name>springSecurityFilterChain</filter-name>
    <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
</filter>

<filter-mapping>
    <filter-name>springSecurityFilterChain</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

## Spring Security provides annotations for method-level security, allowing you to restrict access to specific service layer methods based on user roles.

Here's how you can achieve this:

1. **Annotating the Service Method:**

Use the `@PreAuthorize` annotation on the service method you want to restrict. This annotation allows you to define a `SpEL` (Spring Expression Language) expression that evaluates to true if the user has the required role.

```
@PreAuthorize("hasRole('ADMIN')")
public MyObject doAdminStuff() {
  // Method logic
}
```
