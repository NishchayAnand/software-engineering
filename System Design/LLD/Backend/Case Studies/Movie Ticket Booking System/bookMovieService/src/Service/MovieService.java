package Service;

import DTO.*;

import java.time.LocalDate;
import java.util.List;

public interface MovieService {
    public List<Movie> getMovies(Location location);
    List<Show> getAvailableShows(Movie movie, LocalDate date);
    List<Seat> getAvailableSeats(Show show);
    Booking bookSeats(Customer customer, List<Seat> seats);
}