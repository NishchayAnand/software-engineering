
| Aspect                  | **Dynamic Proxy (JDK)**                                                                                          | **Spring AOP Proxy (CGLIB or JDK)**                                                                  |
| :---------------------- | :--------------------------------------------------------------------------------------------------------------- | :--------------------------------------------------------------------------------------------------- |
| **Definition**          | A proxy object generated at runtime that implements a list of interfaces using Java’s `java.lang.reflect.Proxy`. | A proxy created by Spring’s AOP framework (can use either JDK dynamic proxy _or_ CGLIB subclassing). |
| **Source**              | Comes from the JDK — core reflection API.                                                                        | Built on top of JDK proxies and/or CGLIB library.                                                    |
| **Target requirement**  | Target must implement at least one interface.                                                                    | Can proxy interface-based beans (JDK) or concrete classes (CGLIB).                                   |
| **Method interception** | Intercepts method calls on interfaces only.                                                                      | Can intercept interface methods or concrete class methods (based on proxy type).                     |
| **Used by**             | Feign clients, MyBatis mappers, basic Java reflections, etc.                                                     | Spring AOP (`@Transactional`, `@Retry`, `@Cacheable`, `@Aspect`, etc.)                               |
| **Customization**       | You manually provide `InvocationHandler`.                                                                        | Handled automatically by Spring through `Advisor`s and `Interceptor`s configured via annotations.    |
| **Performance**         | Slightly faster for interfaces.                                                                                  | CGLIB a bit heavier (creates subclass bytecode), but supports more cases.                            |

---
### Spring AOP Proxy

When you mark a method with annotations like `@Transactional`, `@Retry`, `@Cacheable`, or `@CircuitBreaker`, Spring creates a **proxy bean** at startup that wraps the original bean.

That proxy contains **advisors/interceptors** that execute _before/after/around_ method calls.

**Under the hood:**

- If your bean implements an interface → Spring uses **JDK Dynamic Proxy**.
- If it does not implement any interface → Spring uses **CGLIB** (it subclasses your class at runtime and overrides methods to inject interceptors).

---
