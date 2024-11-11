package DAO;

import java.util.List;

public class Customer {
    private int customerId;
    private String name;
    private Location location;
    private String email;
    private String phone;
    private List<Booking> bookings; // All bookings done by this customer

    public Customer(int customerId, String name, Location location, String email, String phone, List<Booking> bookings) {
        this.customerId = customerId;
        this.name = name;
        this.location = location;
        this.email = email;
        this.phone = phone;
        this.bookings = bookings;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
