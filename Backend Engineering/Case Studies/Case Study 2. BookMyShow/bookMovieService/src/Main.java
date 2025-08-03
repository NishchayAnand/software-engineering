
import DTO.*;
import Service.MovieService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MovieService movieService = MovieService.getInstance();

        // Define a Customer object.
        Customer customer = new Customer("Nishchay Anand",
                "nishchay.anand@gmail.com", "9876543210");

        // Use Case 1

        // Customer adds his/her preferred location.
        Location location = new Location("Mumbai", "Maharashtra");
        customer.setLocation(location);

        // Fetch movies that have shows in the current week in the theatres near customer's location.
        List<Movie> movies = movieService.getMovies(customer.getLocation());
        if(movies.isEmpty()) return;

        // Use Case 2

        // Customer selects a movie and a preferred date.
        Movie movie = movies.getFirst();
        LocalDate date = LocalDate.now();

        // Fetch the list of available shows for the selected movie on the preferred date.
        List<Show> shows = movieService.getShows(movie, date);
        if(!shows.isEmpty()) return;

        // Use Case 3

        // Customer selects a show.
        Show show = shows.getFirst();

        // Fetch available seats for the selected show.
        List<Seat> availableSeats = movieService.getAvailableSeats(show);
        if(!availableSeats.isEmpty()) return;

        // Use Case 4

        // Customer selects preferred seats.
        List<Seat> seats = new ArrayList<>();
        seats.add(availableSeats.getFirst());

        // Book the selected seats for the customer.
        Booking booking = movieService.bookSeats(customer, show, seats);
        if(booking != null) customer.addBooking(booking);

    }

}
