package com.bookmyshow.bookmovie.service;

import com.bookmyshow.bookmovie.dto.Location;
import com.bookmyshow.bookmovie.dto.MovieDTO;
import com.bookmyshow.bookmovie.mapper.MovieMapper;
import com.bookmyshow.bookmovie.model.Movie;
import com.bookmyshow.bookmovie.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private MovieMapper movieMapper;

    @InjectMocks
    private MovieService movieService;

    private List<Movie> movies;

    private List<MovieDTO> expectedMoviesDTO;

    @BeforeEach
    void setup() {

        // Output of the MovieRepository.getMoviesByLocation() method
        movies = List.of(new Movie(1L, "Inception", "Sci-Fi",
                LocalDate.of(2010, 7, 16), 148));

        // Output of the MovieService.getMoviesByLocation() method
        expectedMoviesDTO = List.of(new MovieDTO("Inception", "Sci-Fi",
                LocalDate.of(2010, 7, 16), 148));

    }

    @Test
    void shouldFindAllMoviesDTOBasedOnCustomerSelectedCityAndState() {

        // given
        Location location = new Location("New York", "NY");

        when(movieRepository.findMoviesByCityAndState("New York", "NY")).thenReturn(movies);
        when(movieMapper.toDTO(any(Movie.class))).thenAnswer(invocation -> {
            Movie movie = invocation.getArgument(0);
            return new MovieDTO(movie.getTitle(), movie.getGenre(), movie.getReleaseDate(), movie.getDuration());
        });

        // Act
        List<MovieDTO> result = movieService.getMoviesLocation(location);

        // Assert
        assertEquals(expectedMoviesDTO, result);
        //verify(movieRepository).findMoviesByLocation("New York", "NY");
        //verify(movieMapper, times(2)).toDTO(any(Movie.class));

    }
}