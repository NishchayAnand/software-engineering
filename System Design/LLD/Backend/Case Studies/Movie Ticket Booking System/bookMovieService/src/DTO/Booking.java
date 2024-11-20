package DTO;

import java.util.List;

public class Booking {
    private int bookingId;
    private Customer customer;
    private Show show;
    private List<Seat> bookedSeats;
    private double totalAmount;
    private BookingStatus status;

    public Booking(int bookingId, Customer customer, Show show, List<Seat> bookedSeats,
                   double totalAmount, BookingStatus status) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BookingStatus getBookingStatus() {
        return status;
    }

    public void setBookingStatus(BookingStatus status) {
        this.status = status;
    }
}
