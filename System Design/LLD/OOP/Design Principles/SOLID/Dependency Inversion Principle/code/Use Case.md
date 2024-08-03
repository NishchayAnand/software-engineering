# Example: Dependency Inversion Principle

```
// Abstraction (Interface)
interface PaymentGateway {
    void processPayment(double amount);
}
```

```
// Concrete implementation of PaymentGateway for PayPal
class PayPalGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        // Code to process payment via PayPal
        System.out.println("Processing payment of $" + amount + " via PayPal");
    }
}
```

```
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
