package Service;

import DTO.Booking;
import DTO.Customer;

public class NotificationService {

    private NotificationService() {}

    // Bill Pugh: Thread-safe without synchronization (leveraging the Java class loader mechanism
    // for thread safety).
    private static class NotificationServiceHelper {
        private static final NotificationService notificationService = new NotificationService();
    }

    public static NotificationService getInstance() {
        return NotificationServiceHelper.notificationService;
    }

    public void notifyPaymentFailure(Customer customer) {
        String message = "Payment Failed";
        // sendEmail(customer.getEmail(), message);
    }

    public void sendBookingConfirmation(Customer customer, Booking booking) {
        String message = "Booking Confirmed";
        // sendTicketViaEmail(customer.getEmail(), booking);
    }
}
