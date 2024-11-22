package DAO;

import DTO.Show;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShowDAO {

    private static volatile ShowDAO showDAO;

    private final MovieDAO movieDAO;
    private final ScreenDAO screenDAO;

    private ShowDAO() {
        this.movieDAO = MovieDAO.getInstance();
        this.screenDAO = ScreenDAO.getInstance();
    }

    // Double-Checked Locking: Synchronization is performed only when the instance is null, reducing
    // performance overhead.
    public static ShowDAO getInstance() {
        if(showDAO == null) {
            synchronized (ShowDAO.class) {
                if(showDAO==null) showDAO = new ShowDAO();
            }
        }
        return showDAO;
    }

    public List<Show> getShowsByMovieIdAndDate(int movieId, LocalDate date) {
        String sql = "SELECT * FROM show WHERE movieId = ? and showTime = ?";
        /*
        List<Show> shows = new ArrayList<>();
        while(resultSet.next()) {
            int showId = resultSet.getInt("showId");
            int movieId = resultSet.getInt("movieId");
            int screenId = resultSet.getInt("screenId");
            LocalDateTime showTime = resultSet.getTimestamp("showType").toLocalDateTime();

            Movie movie = movieDAO.getMovieById(movieId);
            Screen screen = screenDAO.getScreenById(screenId);

            Show show = new Show(showId, movie, screen.getTheatre(), screen, showTime);
        }
        return shows;
        */
        return new ArrayList<>();
    }
}
