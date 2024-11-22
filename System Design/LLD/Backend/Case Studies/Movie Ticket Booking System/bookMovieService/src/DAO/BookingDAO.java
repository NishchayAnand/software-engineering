package DAO;

import DTO.Booking;

public class BookingDAO {

    private static volatile BookingDAO bookingDAO;

    private BookingDAO() {}

    public static BookingDAO getInstance() {
        if(bookingDAO == null) {
            synchronized (BookingDAO.class) {
                if(bookingDAO == null) bookingDAO = new BookingDAO();
            }
        }
        return bookingDAO;
    }

    public void addBooking(Booking booking) {
        String sql = "INSERT INTO booking (bookingId, customerId, showId, amount, status) VALUES (?,?,?,?,?)";
    }
}
