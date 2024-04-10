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

// Client code
public class Main {
    public static void main(String[] args) {
        // Instantiate the concrete implementation (PayPalGateway)
        PaymentGateway paypalGateway = new PayPalGateway();

        // Instantiate PaymentProcessor and inject PayPalGateway
        PaymentProcessor paymentProcessor = new PaymentProcessor(paypalGateway);

        // Process payment
        paymentProcessor.processPayment(100.0);
    }
}
