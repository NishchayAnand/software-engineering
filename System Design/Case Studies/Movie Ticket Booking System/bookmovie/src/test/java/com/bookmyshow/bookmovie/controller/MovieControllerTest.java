package com.bookmyshow.bookmovie.controller;

import com.bookmyshow.bookmovie.dto.Location;
import com.bookmyshow.bookmovie.dto.MovieDTO;
import com.bookmyshow.bookmovie.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MovieController.class)
class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private MovieService movieService;

    // Integration Test
    @Test
    void shouldFindAllMoviesBasedOnCustomerSelectedLocation() throws Exception {

        // Arrange
        List<MovieDTO> moviesDTO = List.of(new MovieDTO("Inception", "Sci-Fi",
                LocalDate.of(2010, 7, 16), 148));
        when(movieService.getMoviesLocation(any(Location.class))).thenReturn(moviesDTO);

        // Act: Sends a POST request to the api/movies/by-location endpoint.
        mockMvc.perform(post("/api/movies/by-location")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"city\":\"New York\", \"state\":\"NY\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].title").value("Inception"));

    }

    // Integration Test
    @Test
    void shouldReturnEmptyListForLocationWithNoMovies() throws Exception {

        // Arrange
        Location location = new Location("Unknown", "Unknown");
        List<MovieDTO> expectedMoviesDTO = List.of();
        when(movieService.getMoviesLocation(location)).thenReturn(expectedMoviesDTO);

        // Act
        mockMvc.perform(post("/api/movies/by-location")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"city\":\"Unknown\", \"state\":\"Unknown\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

    }

    // Unit Test
    @Test
    void shouldReturnBadRequestForInvalidInput() throws Exception {

        // Act
        mockMvc.perform(post("/api/movies/by-location")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"city\":\"New York\"}")) // missing state
                .andExpect(status().isBadRequest());

    }

    // Unit Test
    @Test
    void shouldReturnInternalServerErrorForDatabaseIssue() throws Exception {

        // Arrange
        Location location = new Location("New York", "NY");
        when(movieService.getMoviesLocation(location)).thenThrow(new RuntimeException("Database connection issue"));

        // Act
        mockMvc.perform(post("/api/movies/by-location")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("{\"city\":\"New York\", \"state\": \"NY\"}"))
                .andExpect(status().isInternalServerError());

        verify(movieService, times(1)).getMoviesLocation(location);

    }

}