package DAO;

import DTO.Movie;
import Entity.MovieEntity;

import java.util.List;

public interface MovieDAO {
    List<MovieEntity> getMoviesById(int movieId);
}
