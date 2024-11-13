package Service;

import DAO.ShowDAO;
import DAO.ShowDAOImpl;
import DAO.TheatreDAO;
import DAO.TheatreDAOImpl;
import Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieServiceImpl implements MovieService {

    private final TheatreDAO theatreDAO;
    private final ShowDAO showDAO;

    public MovieServiceImpl() {
        this.theatreDAO = new TheatreDAOImpl();
        this.showDAO = new ShowDAOImpl();
    }

    private LocalDate getNextSunday(LocalDate currDate) {
        // Add implementation here.
        return null;
    }

    @Override
    public List<Movie> getMovies(Location location) {

        // Step 1. Fetch list of theatres where theatreLocation.City = location.City and
        // theatreLocation.State = location.State and theatreLocation.Country = location.Country
        List<Theatre> theatres = theatreDAO.getTheatreByLocation(location);

        // Step 2. Fetch list of shows playing in the current week in the theatres fetched in Step 1.
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = getNextSunday(startDate);
        List<Show> allShows = new ArrayList<>();
        for(Theatre theatre: theatres) {
            List<Show> theatreShows = showDAO.getShowByTheatreAndShowTimeBetween(theatre,
                    startDate, endDate);
        }

        // Step 3: Extract list of movies corresponding to each show fetched in Step 2.

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
