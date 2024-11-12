import DAO.*;
import Service.MovieService;
import Service.MovieServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Can be attained from session details
        Location location = new Location("Model Town", "New Delhi",
                "Delhi", "India", "110045");

        // Can be attained from session details
        Customer customer = new Customer(1, "Nishchay Anand",
                location, "nishchay.anand@gmail.com", "9876543210", new ArrayList<>());

        MovieService movieService = new MovieServiceImpl();

        // Use Case 1: Fetch the list of movies currently running in the theatres at the preferred
        // location.
        List<Movie> movies = movieService.getMovies(customer.getLocation());
        if(movies.isEmpty()) return;

        // Use Case 2: Fetch the list of available shows for the selected movie on the preferred date.
        Movie selectedMovie = movies.getFirst();
        List<Show> shows = movieService.getAvailableShows(selectedMovie, LocalDate.now());
        if(!shows.isEmpty()) return;

        // Use Case 3:
        Show show = shows.getFirst();
        List<Seat> availableSeats = movieService.getAvailableSeats(show);
        if(!availableSeats.isEmpty()) return;

        // Use Case 4: Book the selected seats.
        List<Seat> selectedSeats = new ArrayList<>();
        selectedSeats.add(availableSeats.getFirst());
        Booking booking = movieService.bookSeats(customer, selectedSeats);

    }
}
