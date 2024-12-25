package com.bookmyshow.bookmovie.service;

import com.bookmyshow.bookmovie.dto.Location;
import com.bookmyshow.bookmovie.dto.MovieDTO;
import com.bookmyshow.bookmovie.exception.MovieFetchException;
import com.bookmyshow.bookmovie.mapper.MovieMapper;
import com.bookmyshow.bookmovie.model.Movie;
import com.bookmyshow.bookmovie.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

    @Autowired
    public MovieService(MovieRepository movieRepository, MovieMapper movieMapper) {
        this.movieRepository = movieRepository;
        this.movieMapper = movieMapper;
    }

    public List<MovieDTO> getMoviesLocation(Location location) {

        /*
        NOTE: Handled in MovieController class
        if(location == null || location.getCity() == null || location.getState() == null) {
            throw new IllegalArgumentException("Invalid Location");
        }
        */

        try {

            logger.info("Fetching movies for location: {}, {}", location.getCity(), location.getState());
            List<Movie> movies = movieRepository.findMoviesByCityAndState(location.getCity(), location.getState());

            logger.info("Found {} movies", movies.size());
            return movies.stream()
                    .map(movieMapper::toDTO)
                    .collect(Collectors.toList());

        } catch (DataAccessException ex) {

            logger.error("Error fetching movies by location: ", ex);
            throw new MovieFetchException("Unable to fetch movies from the database", ex);

        }

    }
}
