package Service;

import DAO.*;
import DTO.*;
import Entity.ScreenEntity;
import Entity.ShowEntity;
import Entity.TheatreEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    private LocalDate getNextSunday(LocalDate currDate) {
        // Add implementation here.
        return null;
    }

    @Override
    public List<Movie> getMovies(Location location) {

        // Step 1: Fetch list of theatres at the specified location(city, state, country)
        List<TheatreEntity> theatres = theatreDAO.getTheatresByLocation(location);

        // Step 2: Fetch list of shows playing in the current week in the nearby theatres
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = getNextSunday(startDate);
        List<List<ShowEntity>> allShows = new ArrayList<>();
        for(TheatreEntity theatre: theatres) {
            List<ScreenEntity> screens = screenDAO.getScreensByThreatreId(theatre.getTheatreId());
            for(ScreenEntity screen: screens) {
                List<ShowEntity> shows = showDAO.getShowsByScreenIdAndShowTimeBetween(screen.getScreenId(),
                        startDate, endDate);
                allShows.add(shows);
            }

        }
        List<ShowEntity> shows = allShows   .stream().flatMap(List::stream).toList();

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
