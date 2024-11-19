package DAO;

import DTO.Movie;
import Entity.MovieEntity;

import java.util.ArrayList;
import java.util.List;

public class MovieDAOImpl implements MovieDAO {
    @Override
    public List<MovieEntity> getMoviesById(int movieId) {
        String sql = String.format("select * from movie where movieId in (%s)", movieId);
        return new ArrayList<>();
    }
}
