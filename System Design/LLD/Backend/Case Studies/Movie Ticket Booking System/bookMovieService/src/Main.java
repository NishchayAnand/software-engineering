import DAO.MovieDAO;
import DAO.ScreenDAO;
import DAO.ShowDAO;
import DAO.TheatreDAO;
import DTO.*;
import Service.MovieService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        MovieDAO movieDAO = new MovieDAO();
        ScreenDAO screenDAO = new ScreenDAO();
        ShowDAO showDAO = new ShowDAO(movieDAO, screenDAO);

        MovieService movieService = new MovieService(movieDAO, showDAO);

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

        // Use Case 4: Book the selected seats.
        List<Seat> selectedSeats = new ArrayList<>();
        selectedSeats.add(availableSeats.getFirst());
        Booking booking = movieService.bookSeats(customer, selectedSeats);

    }
}
