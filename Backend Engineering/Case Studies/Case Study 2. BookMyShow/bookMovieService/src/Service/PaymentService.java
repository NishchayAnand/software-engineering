package Service;

import DTO.Customer;

public class PaymentService {

    private PaymentService() {}

    private static class PaymentServiceHelper {
        private static final PaymentService paymentService = new PaymentService();
    }

    public static PaymentService getInstance() {
        return PaymentServiceHelper.paymentService;
    }

    public boolean processPayment(Customer customer, double amount) {
        System.out.println("Processing payment for customer " + customer.getName() + ": $" + amount);
        return true;

    }
}
