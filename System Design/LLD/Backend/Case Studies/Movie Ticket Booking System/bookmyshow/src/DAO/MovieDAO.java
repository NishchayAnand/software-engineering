package DAO;

import Model.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> getMoviesById(List<Integer> movieIds);
}
