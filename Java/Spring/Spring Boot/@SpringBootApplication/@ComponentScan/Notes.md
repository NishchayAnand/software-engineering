# Understanding @ComponentScan Annotation

Enables component scanning, allowing Spring to discover and register beans annotated with `@Component`, `@Service`, `@Repository`, `@Controller`, etc.

By default, it scans the package of the class with the `@SpringBootApplication` annotation. However, you can explicitly specify the base packages to scan if they are not in the same package as the main application class.

```
@ComponentScan(basePackages = {"com.example.service", "com.example.repository"})
```
