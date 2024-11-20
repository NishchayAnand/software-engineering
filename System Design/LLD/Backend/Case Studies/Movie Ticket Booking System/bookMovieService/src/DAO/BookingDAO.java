package DAO;

import DTO.Booking;

public class BookingDAO {

    public void addBooking(Booking booking) {
        String sql = "INSERT INTO booking (bookingId, customerId, showId, amount, status) VALUES (?,?,?,?,?)";
    }
}
