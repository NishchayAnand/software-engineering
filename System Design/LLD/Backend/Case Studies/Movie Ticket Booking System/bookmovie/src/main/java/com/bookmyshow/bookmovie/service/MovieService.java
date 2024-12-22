package com.bookmyshow.bookmovie.service;

import com.bookmyshow.bookmovie.dto.Location;
import com.bookmyshow.bookmovie.dto.MovieDTO;
import com.bookmyshow.bookmovie.exception.MovieServiceException;
import com.bookmyshow.bookmovie.mapper.MovieMapper;
import com.bookmyshow.bookmovie.model.Movie;
import com.bookmyshow.bookmovie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    @Autowired
    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<MovieDTO> getMoviesLocation(Location location) {

        if(location == null || location.getCity() == null || location.getState() == null) {
            throw new IllegalArgumentException("Invalid Location");
        }

        try {

            List<Movie> movies = movieRepository.findMoviesByCityAndState(location.getCity(), location.getState());
            return movies.stream()
                    .map(movieMapper::toDTO)
                    .collect(Collectors.toList());

        } catch (Exception ex) {

            // Log the exception
            throw new MovieServiceException("Unable to fetch movies from the database", ex);

        }

    }
}
