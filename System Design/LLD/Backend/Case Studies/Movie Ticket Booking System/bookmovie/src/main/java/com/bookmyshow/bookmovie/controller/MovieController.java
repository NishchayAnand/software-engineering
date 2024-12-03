package com.bookmyshow.bookmovie.controller;

import com.bookmyshow.bookmovie.dto.Location;
import com.bookmyshow.bookmovie.dto.Movie;
import com.bookmyshow.bookmovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;



    @PostMapping("/by-location")
    public List<Movie> getMovies(@RequestBody Location location) {
        return movieService.getMovies(location);
    }


}
