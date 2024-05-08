# Understanding Aspect Oriented Programming

- One reason that AOP is a more attractive proposition to deliver such services than EJB is that it imposes fewer requirements on the objects to which it adds enterprise services. For example, they don't usually need to depend on a particular API such as the EJB API.

- EJB owes much of its success to the deserved popularity of declarative middleware services such as container-managed transactions. AOP provides a powerful alternative way of providing such declarative enterprise services without most of the baggage of EJB.

AOP is a programming paradigm that allows you to add functionality (aspects) to existing code without modifying it directly. This is useful for cross-cutting concerns like logging, security, or transaction management.

Traditional AOP often involves manual creation of proxies, which can be complex.

Spring's auto-proxying simplifies AOP by automatically creating proxies for beans based on configuration.

AOP decomposes systems into aspects or concerns, rather than objects.

OOP is a successful and expressive paradigm. Many domain concepts naturally can be expressed as objects, modularizing common code. However, there are areas where OOP doesn't shine.

OOP generally does an excellent job of eliminating code duplication. Concrete inheritance helps us leverage shared behavior; polymorphism enables us to treat objects of different classes consistently when we're interested in their common characteristics. However, there are some cases when we can't use OOP to eliminate code duplication, or where the OO solution is clumsy.

Take the example of custom security checks. Imagine that we want to check whether the user has permission to execute a particular method, and throw an exception if she doesn't. If we address this programmatically, OO can't really help us. We'll end up with code like this:

```
public class MyBusinessObject implements BusinessObject {
    public void businessMethod1() throws UnauthorizedException {
        doSecurityCheck();
        // Do the work of method1
     }

     public void businessMethod2() throws UnauthorizedException {
         doSecurityCheck();
        // Do the work of method2
     }

     // Other methods requiring a security check omitted

     public void requiresNoSecurityCheck() {
         // Do the work of method
     }

     protected void doSecurityCheck() throws UnauthorizedException {
         // Implement the security check
     }
}
```

Unfortunately, OO doesn't give us a good way of gathering together and modularizing such scattered code.

It provides us with the ability to interpose custom behavior before and/or after method invocations on any object.

AOP as a means of providing declarative enterprise services to POJOs.

In a proxy business object: "Every invocation goes through the transaction interceptor first, continuing with the actual business object, and going through the interceptor again on the way back. The business object implementation itself is defined as "target", which is simply a naming convention to identify its role."
