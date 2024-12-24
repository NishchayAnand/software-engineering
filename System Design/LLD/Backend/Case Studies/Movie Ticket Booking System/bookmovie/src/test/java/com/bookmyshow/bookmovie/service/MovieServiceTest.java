package com.bookmyshow.bookmovie.service;

import com.bookmyshow.bookmovie.dto.Location;
import com.bookmyshow.bookmovie.dto.MovieDTO;
import com.bookmyshow.bookmovie.exception.MovieServiceException;
import com.bookmyshow.bookmovie.mapper.MovieMapper;
import com.bookmyshow.bookmovie.model.Movie;
import com.bookmyshow.bookmovie.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class MovieServiceTest {

    //@Mock
    @MockitoBean
    private MovieRepository movieRepository;

    //@Mock
    @MockitoBean
    private MovieMapper movieMapper;

    //@InjectMocks
    @Autowired
    private MovieService movieService;

    @Test
    void shouldFindAllMoviesBasedOnCustomerSelectedCityAndState() {

        // Arrange
        Location location = new Location("New York", "NY");

        List<Movie> movies = List.of(new Movie(1L, "Inception", "Sci-Fi",
                LocalDate.of(2010, 7, 16), 148));

        List<MovieDTO> expectedMoviesDTO = List.of(new MovieDTO("Inception", "Sci-Fi",
                LocalDate.of(2010, 7, 16), 148));

        when(movieRepository.findMoviesByCityAndState("New York", "NY")).thenReturn(movies);

        when(movieMapper.toDTO(any(Movie.class))).thenAnswer(invocation -> {
            Movie movie = invocation.getArgument(0);
            return new MovieDTO(movie.getTitle(), movie.getGenre(), movie.getReleaseDate(), movie.getDuration());
        });

        // Act
        List<MovieDTO> result = movieService.getMoviesLocation(location);

        // Assert
        assertEquals(expectedMoviesDTO, result);
        verify(movieRepository).findMoviesByCityAndState("New York", "NY");
        verify(movieMapper, times(1)).toDTO(any(Movie.class));

    }

    @Test
    void shouldReturnEmptyListWhenNoMoviesFound() {

        // Arrange
        Location location = new Location("Unknown City", "Unknown State");
        when(movieRepository.findMoviesByCityAndState(anyString(), anyString())).thenReturn(Collections.emptyList());

        // Act
        List<MovieDTO> result = movieService.getMoviesLocation(location);

        // Assert
        assertTrue(result.isEmpty());
        verify(movieRepository).findMoviesByCityAndState("Unknown City", "Unknown State");

    }

    @Test
    void shouldThrowExceptionForInvalidLocation() {

        // act and assert
        assertThrows(IllegalArgumentException.class,
                () -> movieService.getMoviesLocation(null));

    }

    @Test
    void shouldHandleRepositoryExceptionGracefully() {

        // Arrange
        Location location = new Location("New York", "NY");
        when(movieRepository.findMoviesByCityAndState(anyString(), anyString()))
                .thenThrow(new RuntimeException("Database Error"));

        // Act and assert
        RuntimeException ex = assertThrows(MovieServiceException.class,
                () -> movieService.getMoviesLocation(location));

    }

}