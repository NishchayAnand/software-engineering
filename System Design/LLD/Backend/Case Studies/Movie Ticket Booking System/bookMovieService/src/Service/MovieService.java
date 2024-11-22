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

        // Calculate total price
        double totalAmount = seats.stream()
                .mapToDouble(seat->seat.getSeatType().getPrice())
                .sum();

        // Process payment
        boolean paymentSuccess = paymentService.processPayment(customer, totalAmount);
        if(!paymentSuccess) {
            notificationService.notifyPaymentFailure(customer);
            return null;
        }

        // Update seats as booked in the database
        for(Seat seat: seats) {
            seat.setBooked(true);
            seatDAO.updateSeatBookingStatus(seat.getSeatId(), true);
        }

        // Add a booking record to the database
        Booking booking = new Booking(1, customer, show, seats, totalAmount,
                BookingStatus.CONFIRMED);
        bookingDAO.addBooking(booking);

        // Send booking confirmation to the customer
        notificationService.sendBookingConfirmation(customer, booking);

        return booking;
    }

}
