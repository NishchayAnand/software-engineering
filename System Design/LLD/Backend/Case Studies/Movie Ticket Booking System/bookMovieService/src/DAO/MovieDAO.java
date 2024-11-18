package DAO;

import DTO.Movie;

import java.util.List;

public interface MovieDAO {
    List<Movie> getMoviesById(List<Integer> movieIds);
}
