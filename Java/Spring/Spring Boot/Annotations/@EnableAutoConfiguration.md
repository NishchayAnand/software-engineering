## Understanding @EnableAutoConfiguration Annotation

**Automatically configures Spring application context** based on the dependencies and settings on the classpath.

If you need to exclude certain auto-configuration classes, you can use the exclude attribute of `@EnableAutoConfiguration` or `@SpringBootApplication` annotation.

```
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
```

If the class you want to exclude is not on the classpath, you can use the `excludeName` attribute of the `@EnableAutoConfiguration` annotation (or `@SpringBootApplication`) to specify the fully qualified name of the class to be excluded.

```
@EnableAutoConfiguration(excludeName = { "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration" })
```
