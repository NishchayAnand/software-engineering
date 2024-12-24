package com.bookmyshow.bookmovie.controller;

import com.bookmyshow.bookmovie.dto.Location;
import com.bookmyshow.bookmovie.dto.MovieDTO;
import com.bookmyshow.bookmovie.exception.MovieServiceException;
import com.bookmyshow.bookmovie.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/by-location")
    public ResponseEntity<List<MovieDTO>> getMovies(@Valid @RequestBody Location location, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) return ResponseEntity.badRequest().body(null);

        try {
            List<MovieDTO> movies = movieService.getMoviesLocation(location);
            return ResponseEntity.ok(movies);
        } catch (MovieServiceException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
