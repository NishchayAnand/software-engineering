package com.bookmyshow.bookmovie.service;

import com.bookmyshow.bookmovie.dto.Location;
import com.bookmyshow.bookmovie.dto.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    public List<Movie> getMovies(Location location) {
        return new ArrayList<>();
    }
}
