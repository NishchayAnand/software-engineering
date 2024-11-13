package Service;

import DAO.*;
import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieServiceImpl implements MovieService {

    private final TheatreDAO theatreDAO;
    private final ShowDAO showDAO;
    private final MovieDAO movieDAO;

    public MovieServiceImpl() {
        this.theatreDAO = new TheatreDAOImpl();
        this.showDAO = new ShowDAOImpl();
        this.movieDAO = new MovieDAOImpl();
    }

    private LocalDate getNextSunday(LocalDate currDate) {
        // Add implementation here.
        return null;
    }

    @Override
    public List<Movie> getMovies(Location location) {

        // Step 1: Fetch list of theatres where theatreLocation.City = location.City and
        // theatreLocation.State = location.State and theatreLocation.Country = location.Country
        List<Theatre> theatres = theatreDAO.getTheatresByLocation(location);

        // Step 2: Fetch movieIds from the list of shows playing in the current week in the theatres
        // fetched in Step 1.
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = getNextSunday(startDate);
        List<List<Integer>> allMovieIds = new ArrayList<>();
        for(Theatre theatre: theatres) {
            List<Integer> movieIds = showDAO.getMovieIdsByTheatreAndShowTimeBetween(theatre,
                    startDate, endDate);
            allMovieIds.add(movieIds);
        }

        List<Integer> movieIds = allMovieIds.stream().flatMap(List::stream).toList();

        // Step 3: Fetch list of movies corresponding to each movieId fetched in Step 2.
        return movieDAO.getMoviesById(movieIds);

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
