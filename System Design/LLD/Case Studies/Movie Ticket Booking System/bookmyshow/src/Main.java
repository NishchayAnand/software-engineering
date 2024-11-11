import DAO.Customer;
import DAO.Location;
import DAO.Movie;
import Service.MovieService;
import Service.MovieServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Location location = new Location("Model Town", "New Delhi",
                "Delhi", "India", "110045");

        Customer customer = new Customer(1, "Nishchay Anand",
                location, "nishchay.anand@gmail.com", "9876543210", new ArrayList<>());

        MovieService movieService = new MovieServiceImpl();

        // Use Case 1: Fetch the list of movies currently running in the theatres at the preferred
        // location.
        List<Movie> movies = movieService.getMovies(customer.getLocation());

    }
}
