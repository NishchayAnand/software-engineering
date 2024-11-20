package DAO;

import DTO.Show;
import DTO.Theatre;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShowDAO {

    private MovieDAO movieDAO;
    private ScreenDAO screenDAO;

    public ShowDAO(MovieDAO movieDAO, ScreenDAO screenDAO) {
        this.movieDAO = movieDAO;
        this.screenDAO = screenDAO;
    }

    public List<Show> getShowsByMovieAndDate(int movieId, LocalDate date) {
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
