package DTO;

public class Seat {
    private int seatId;
    private String seatNumber;
    private SeatType seatType;
    private boolean isBooked;

    // NOTE: Do not include Show directly in the Seat class. Instead, use a Booking entity to manage
    // the relationship between Seats and Shows.

    public Seat(int seatId, String seatNumber, SeatType seatType, boolean isBooked) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isBooked = isBooked;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
