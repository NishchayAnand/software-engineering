# Understanding Decorator Design Pattern

- Help avoids the the overuse of inheritance by decorating your classes at runtime using a form of object composition. This will allow you to give new responsibilities to an existing object without making any changes to the underlying class.

- open close principle.

- Decorators add value to one or more method calls before forwarding it (for example, verfying a payment before calling the execute() method).

- The Decorator pattern (GoF) allows the addition of custom behavior before and after (around, in AOP terminology) a method invocation.

- The Decorator is a useful pattern, but requires coding a custom decorator per target class.

- Key to decorator pattern is objects wrapping other objects in recursive method calls.
