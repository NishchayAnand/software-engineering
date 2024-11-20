package Service;

import DTO.Customer;

public class PaymentService {

    public boolean processPayment(Customer customer, double amount) {
        System.out.println("Processing payment for customer " + customer.getName() + ": $" + amount);
        return true;

    }
}
