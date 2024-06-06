# Understanding Aspect Oriented Programming

An aspect is a common feature that's typically scattered across methods, classes, object hierarchies, or even entire object models. **It is behavior that looks and smells like it should have structure, but you can't find a way to express this structure in code with traditional object-oriented techniques.**

For example, metrics is one common aspect. To generate useful logs from your application, you have to (often liberally) sprinkle informative messages throughout your code. However, **metrics is something that your class or object model really shouldn't be concerned about. After all, metrics is irrelevant to your actual application: it doesn't represent a customer or an account, and it doesn't realize a business rule.** It's simply orthogonal.

> NOTE: Measuring the amount of time it would take to invoke a particular method is an example of metrics.

In AOP, a feature like metrics is called a **crosscutting concern**, as it's a behavior that "cuts" across multiple points in your object models, yet is distinctly different. As a development methodology, **AOP recommends that you abstract and encapsulate crosscutting concerns.**

Aspect-oriented programming allows you to add behavior such as metrics "around" your code. For example, it provides you with programmatic control to specify that you want calls to BankAccountDAO to go through a metrics **aspect** before executing the actual body of that code.

## Links:

1. https://docs.jboss.org/aop/1.0/aspect-framework/userguide/en/html/what.html
