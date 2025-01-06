package DAO;

import DTO.Movie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO {

    private static MovieDAO movieDAO;

    private MovieDAO() {}

    // Lazy Initialization: Not thread-safe. Multiple threads can create multiple instances if
    // accessed simultaneously.
    public static MovieDAO getInstance() {
        if(movieDAO == null) movieDAO = new MovieDAO();
        return movieDAO;
    }

    public Movie getMovieById(int movieId) {
        String sql = "SELECT * FROM movie WHERE movieId = ?";
        return new Movie(movieId, "Da Vinci Code", "Thriller", LocalDate.now(), 120);
    }

    public List<Movie> getMoviesByLocation(String city, String state) {
        String sql = "SELECT DISTINCT m.movieId, m.title, m.genre, m.releaseDate, m.duration" +
                     "FROM movie m " +
                     "JOIN show s ON m.movieId = s.movieId " +
                     "JOIN theatre t ON s.theatreId = t.theatreId " +
                     "WHERE t.city = ? and t.state = ?";
        return new ArrayList<>();
    }
}
