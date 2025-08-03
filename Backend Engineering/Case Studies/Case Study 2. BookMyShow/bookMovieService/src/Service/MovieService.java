package Service;

import DAO.*;
import DTO.*;

import java.time.LocalDate;
import java.util.List;

public class MovieService {

    private final MovieDAO movieDAO;
    private final ShowDAO showDAO;
    private final SeatDAO seatDAO;
    private final BookingDAO bookingDAO;
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    // Eager Initialization: Single instance is created at the time of class loading (created even if
    // it’s not used, which may lead to resource wastage).
    private static final MovieService movieService = new MovieService();

    // Private constructor to prevent instantiation
    private MovieService() {
        this.movieDAO = MovieDAO.getInstance();
        this.showDAO = ShowDAO.getInstance();
        this.seatDAO = SeatDAO.getInstance();
        this.bookingDAO = BookingDAO.getInstance();
        this.paymentService = PaymentService.getInstance();
        this.notificationService = NotificationService.getInstance();
    }

    // Public method to provide access to the instance
    public static MovieService getInstance() {
        return movieService;
    }

    public List<Movie> getMovies(Location location) {
        return movieDAO.getMoviesByLocation(location.getCity(), location.getState());
    }

    public List<Show> getShows(Movie movie, LocalDate date) {
        return showDAO.getShowsByMovieIdAndDate(movie.getMovieId(), date);
    }

    public List<Seat> getAvailableSeats(Show show) {
        List<Seat> allSeats = seatDAO.getSeatsByShowId(show.getShowId());
        return allSeats.stream().filter(seat->!seat.isBooked()).toList();
    }

    public Booking bookSeats(Customer customer, Show show, List<Seat> seats) {

        // Begin a transaction
        try {

            // Check if selected seats are still available
            List<Seat> availableSeats = getAvailableSeats(show);
            for (Seat selectedSeat : seats) {
                boolean isAvailable = availableSeats
                        .stream()
                        .anyMatch(availableSeat -> availableSeat.getSeatId() == selectedSeat.getSeatId());
                if(!isAvailable) {
                    notificationService.notifySeatUnavailable(customer, selectedSeat);
                    throw new RuntimeException("One or more seats are already booked.");
                }
            }

            // Mark seats as booked
            for(Seat seat: seats) {
                boolean updateSuccess = seatDAO.updateSeatBookingStatus(seat.getSeatId(), true);
                if(!updateSuccess) {
                    throw new RuntimeException("Failed to book: " + seat.getSeatNumber());
                }
            }

            // Calculate total price
            double totalAmount = seats.stream()
                    .mapToDouble(seat->seat.getSeatType().getPrice())
                    .sum();

            // Process payment
            boolean paymentSuccess = paymentService.processPayment(customer, totalAmount);
            if(!paymentSuccess) {
                notificationService.notifyPaymentFailure(customer);
                throw new RuntimeException("Payment Failed.");
            }

            // Add booking to the database
            Booking booking = new Booking(1, customer, show, seats, totalAmount, BookingStatus.CONFIRMED);
            bookingDAO.addBooking(booking);

            // Send booking confirmation to the customer
            notificationService.sendBookingConfirmation(customer, booking);

            // commit the transaction
            return booking;
        } catch (Exception e) {
            // rollback transaction
            throw new RuntimeException("Booking Failed: " + e.getMessage());
        }

    }

}
