package Service;

import DAO.*;
import DTO.*;
import Entity.MovieEntity;
import Entity.ScreenEntity;
import Entity.ShowEntity;
import Entity.TheatreEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieServiceImpl implements MovieService {

    private final TheatreDAO theatreDAO;
    private final ShowDAO showDAO;
    private final MovieDAO movieDAO;
    private final ScreenDAO screenDAO;

    public MovieServiceImpl() {
        this.theatreDAO = new TheatreDAOImpl();
        this.showDAO = new ShowDAOImpl();
        this.movieDAO = new MovieDAOImpl();
        this.screenDAO = new ScreenDAOImpl();
    }

    @Override
    public List<Movie> getMovies(Location location) {

        // Step 1: Fetch list of theatres at the specified location(city, state, country)
        List<TheatreEntity> theatres = theatreDAO.getTheatresByLocation(location);

        // Step 2: Fetch list of shows playing in the nearby theatres fetched in step 1.
        List<List<ShowEntity>> allShows = new ArrayList<>();
        for(TheatreEntity theatre: theatres) {
            List<ScreenEntity> screens = screenDAO.getScreensByThreatreId(theatre.getTheatreId());
            for(ScreenEntity screen: screens) {
                List<ShowEntity> shows = showDAO.getShowsByScreenId(screen.getScreenId());
                allShows.add(shows);
            }
        }
        List<ShowEntity> showsList = allShows.stream().flatMap(List::stream).toList();

        // Step 3: Fetch list of movies corresponding to each show fetched in Step 2.
        List<List<Movie>> allMovies = new ArrayList<>();
        for(ShowEntity show: showsList) {
            List<MovieEntity> movieEntities = movieDAO.getMoviesById(show.getMovieId());
            // map MovieEntity objects (movieId, title, genre, releaseDate, duration) to Movie
            // objects (title, genre, releaseDate, duration);
            List<Movie> movies = new ArrayList<>();
            allMovies.add(movies);
        }

        return allMovies.stream().flatMap(List::stream).toList();

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
