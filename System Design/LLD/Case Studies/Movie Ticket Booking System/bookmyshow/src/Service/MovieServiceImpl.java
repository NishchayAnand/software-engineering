package Service;

import DAO.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieServiceImpl implements MovieService {

    @Override
    public List<Movie> getMovies(Location location) {
        return new ArrayList<>();
    }

    @Override
    public List<Show> getAvailableShows(Movie movie, LocalDate date) {
        return new ArrayList<>();
    }

    @Override
    public List<Seat> getAvailableSeats(Show show) {
        return new ArrayList<>();
    }

    @Override
    public Booking bookSeats(Customer customer, List<Seat> seats) {
        return null;
    }

}
