package Service;

import DAO.*;
import DTO.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private final MovieDAO movieDAO;
    private final ShowDAO showDAO;

    public MovieService(MovieDAO movieDAO, ShowDAO showDAO) {
        this.movieDAO = movieDAO;
        this.showDAO = showDAO;
    }

    public List<Movie> getMovies(Location location) {
        return movieDAO.getMoviesByLocation(location.getCity(), location.getState());
    }

    public List<Show> getShows(Movie movie, LocalDate date) {
        return showDAO.getShowsByMovieAndDate(movie.getMovieId(), date);
    }

    public List<Seat> getAvailableSeats(Show show) {
        return new ArrayList<>();
    }

    public Booking bookSeats(Customer customer, List<Seat> seats) {
        return null;
    }

}
