package com.bookmyshow.bookmovie.controller;

import com.bookmyshow.bookmovie.dto.ErrorResponse;
import com.bookmyshow.bookmovie.dto.Location;
import com.bookmyshow.bookmovie.dto.MovieDTO;
import com.bookmyshow.bookmovie.exception.MovieFetchException;
import com.bookmyshow.bookmovie.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /* NOTE: Best practice is to handle exceptions centrally.
    @PostMapping("/by-location")
    public ResponseEntity<Map<String, Object>> getMovies(@RequestBody @Valid Location location,
                                                                 BindingResult bindingResult) {

        // Handle MethodArgumentNotValidException
        if(bindingResult.hasErrors()) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", "City and State are required.");
            return ResponseEntity.badRequest().body(response); // static factory method
        }

        try {
            List<MovieDTO> movies = movieService.getMoviesLocation(location);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Movies fetched successfully");
            response.put("movies", movies);
            return ResponseEntity.ok(response); // static factory method
        } catch (MovieFetchException ex) {
            Map<String, Object> response = new HashMap<>();
            response.put("message", ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }
    */

    @PostMapping("/by-location")
    public List<MovieDTO> getMovies(@RequestBody @Valid Location location) {
        return movieService.getMoviesLocation(location);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestException(MethodArgumentNotValidException ex) {
        ErrorResponse errorResponse = new ErrorResponse("City and State are required", ex.getMessage());
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(MovieFetchException.class)
    public ResponseEntity<ErrorResponse> handleMovieFetchException(MovieFetchException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Database error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}
