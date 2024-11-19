import DTO.*;
import Service.MovieService;
import Service.MovieServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Define a Customer object.
        Customer customer = new Customer("Nishchay Anand",
                "nishchay.anand@gmail.com", "9876543210");

        MovieService movieService = new MovieServiceImpl();

        // Use Case 1

        // Customer adds his/her preferred location.
        Location custLocation = new Location("New Delhi", "Delhi", "India");
        customer.setLocation(custLocation);

        // Fetch movies that have shows in the current week in the theatres near customer's location.
        List<Movie> movies = movieService.getMovies(customer.getLocation());
        if(movies.isEmpty()) return;

        // Use Case 2: Fetch the list of available shows for the selected movie on the preferred date.
        Movie selectedMovie = movies.getFirst();
        List<Show> shows = movieService.getAvailableShows(selectedMovie);
        if(!shows.isEmpty()) return;

        // Use Case 3: Fetch available seats for the selected show.
        Show show = shows.getFirst();
        List<Seat> availableSeats = movieService.getAvailableSeats(show);
        if(!availableSeats.isEmpty()) return;

        // Use Case 4: Book the selected seats.
        List<Seat> selectedSeats = new ArrayList<>();
        selectedSeats.add(availableSeats.getFirst());
        Booking booking = movieService.bookSeats(customer, selectedSeats);

    }
}
