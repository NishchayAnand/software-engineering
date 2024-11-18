package DAO;

import Model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements MovieDAO {
    @Override
    public List<Movie> getMoviesById(List<Integer> movieIds) {
        String sql = String.format("select * from movie where movieId in (%s)",
                String.join(",", movieIds.stream().map(String::valueOf).toArray(String[]::new)));
        // map RelationalEntity(movieId, title, genre, releaseDate, duration) to Movie(movieId,
        // title, genre, releaseDate, duration).
        return new ArrayList<>();
    }
}
