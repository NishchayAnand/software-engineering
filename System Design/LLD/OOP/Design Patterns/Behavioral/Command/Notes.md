# Understanding Command Design Pattern

- Encapsulate method invocation.

- To encapsulate commands or method invocations, you define a super type (Command), which can be an interface or abstract class exposing one method (usually called execute). For each particular command you want to support, you define a subclass that overrides the execute method in a particular way.

- Provides a way where subject and observers are loosly coupled.
