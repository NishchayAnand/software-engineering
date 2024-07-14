# Understanding Dependency Inversion Principle

**DEFINITION:** Depend upon abstractions. Do not depend upon concrete classes.

At first, this priciple sounds a lot like **Program to an interface, not an implementation.** It is similar, however, the **Dependency Inversion Principle** makes an even stronger statement about abstraction. It suggests that our high-level components should not depend on our low-level components, rather, they should both depend on the abstractions.

---

The Dependency Inversion Principle (DIP) states that **"High-level modules should not depend on low-level modules."** This means that high-level classes should interact with low-level classes through `interfaces`, rather than concrete implementations.

> **High-level modules:** These are classes that are typically more abstract and concern themselves with the core business logic of the application. Examples: order processing service, payment processing service, user authentication service.

> **Low-level modules:** These are classes that handle more specific, detailed tasks. They tend to be more concrete and deal with implementation details. Examples: Database access layer, Utility functions (string manipulation, date/time formatting), Algorithm implementations (sorting algorithm, searching algorithm).

DIP promotes loose `coupling` between classes, allowing you to change implementations of low-level classes without impacting the high-level ones _(as long as the new implementations adhere to the same interface)_. This makes the application more flexible in accommodating changes.

> **Coupling:** Measures how closely different classes are dependent on each other. Remember Coupling as"degree of interdependence between classes".

## How To Achieve Dependency Inversion Principle?

DIP can be achieved using the Dependency Injection (DI) technique.

> **NOTE:** Dependency injection (DI) is a design pattern where an object receives its dependencies instead of creating them.

With DI, the high-level classes (consumers) don't create and manage their own dependency objects. They only declare the interface they rely on. A separate entity, often called an injector, takes on the responsibility of creating and providing the actual implementation of the dependencies.

The injector injects the dependency objects into the consumer class at runtime. This means the consumer gets the exact dependency it needs when it needs it.

Here are some ways to implement DI:

- **Constructor injection:** The dependencies are passed as arguments to the constructor of the consumer class.

- **Setter injection:** Dependencies are injected using setter methods in the consumer class. This approach is less common than the constructor injection.

**Here's a simple example in Java demonstrating Dependency Inversion Principle:**

```
// Abstraction (Interface)
interface PaymentGateway {
    void processPayment(double amount);
}

// Concrete implementation of PaymentGateway for PayPal
class PayPalGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        // Code to process payment via PayPal
        System.out.println("Processing payment of $" + amount + " via PayPal");
    }
}

// High-level class that depends on PaymentGateway abstraction
class PaymentProcessor {
    private PaymentGateway paymentGateway;

    // Constructor injection of PaymentGateway
    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPayment(double amount) {
        // Delegate payment processing to the injected PaymentGateway
        paymentGateway.processPayment(amount);
    }
}
```

In the above example:

- `PaymentGateway` is the interface representing the abstraction for payment processing.
- `PayPalGateway` is a concrete implementation of `PaymentGateway`.
- `PaymentProcessor` is a high-level class that depends on `PaymentGateway` abstraction.

The `PaymentProcessor` accepts an instance of `PaymentGateway` via constructor injection. It is unaware of the specific implementation details of the payment processing (e.g., PayPal) and only depends on the abstraction `PaymentGateway`.

You can easily swap out the concrete implementation of `PaymentGateway` (e.g., replace PayPal with Stripe) without modifying the `PaymentProcessor` class, thus adhering to the Dependency Inversion Principle.
