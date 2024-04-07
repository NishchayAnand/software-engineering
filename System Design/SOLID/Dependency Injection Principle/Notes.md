# Understanding Dependency Injection Principle

Don't make classes like `Customers` depend on detail like the different payment methods. Make it depend on an abstraction like `PaymentMethod` instead which is much less likely to change.

States that "Depend upon Abstraction rather than upon concrete classes".
