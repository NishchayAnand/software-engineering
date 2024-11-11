package DAO;

import java.util.List;

public class Booking {
    private int bookingId;
    private Customer customer; // The customer who made the booking
    private Show show; // The show for which tickets are booked
    private List<Seat> bookedSeats; // List of seats booked
    private double totalAmount; // Total amount for the booking
    private PaymentStatus paymentStatus; // Status of the payment
    private BookingStatus bookingStatus; // Status of the booking

    public Booking(int bookingId, Customer customer, Show show, List<Seat> bookedSeats, double totalAmount, PaymentStatus paymentStatus, BookingStatus bookingStatus) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.show = show;
        this.bookedSeats = bookedSeats;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.bookingStatus = bookingStatus;
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

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
