package com.bookmymovie.movingbookingservice.controller;

import com.bookmymovie.movingbookingservice.dto.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @GetMapping("/by-location")
    public List<Movie> getMovies() {
        Location location new Location(city, state);
        return movieService.getMovies(location);
    }


}
