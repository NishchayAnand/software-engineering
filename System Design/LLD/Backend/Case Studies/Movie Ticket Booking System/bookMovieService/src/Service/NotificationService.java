package Service;

import DTO.Booking;
import DTO.Customer;

public class NotificationService {

    public void notifyPaymentFailure(Customer customer) {
        String message = "Payment Failed";
        // sendEmail(customer.getEmail(), message);
    }

    public void sendBookingConfirmation(Customer customer, Booking booking) {
        String message = "Booking Confirmed";
        // sendTicketViaEmail(customer.getEmail(), booking);
    }
}
