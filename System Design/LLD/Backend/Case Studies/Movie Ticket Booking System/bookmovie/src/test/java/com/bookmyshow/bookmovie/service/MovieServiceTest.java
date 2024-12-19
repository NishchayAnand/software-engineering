package com.bookmyshow.bookmovie.service;

import org.junit.jupiter.api.Test;

class MovieServiceTest {

    @Test
    void shouldFindAllMoviesDTOBasedOnCustomerCityAndState() {

        // Arrange
        Location location = new Location("New York", "NY");
        List<Movie> movies = List.of(
                new Movie(1L, "Inception", "Sci-Fi", LocalDate.of(2010, 7, 16), 148),
                new Movie(2L, "The Dark Knight", "Action", LocalDate.of(2008, 7, 18), 152)
        );
        List<MovieDTO> expectedMovieDTOs = List.of(
                new MovieDTO(1L, "Inception", "Sci-Fi", LocalDate.of(2010, 7, 16), 148),
                new MovieDTO(2L, "The Dark Knight", "Action", LocalDate.of(2008, 7, 18), 152)
        );

        when(movieRepository.findMoviesByLocation("New York", "NY")).thenReturn(movies);
        when(movieMapper.toDTO(any(Movie.class))).thenAnswer(invocation -> {
            Movie movie = invocation.getArgument(0);
            return new MovieDTO(movie.getId(), movie.getTitle(), movie.getGenre(), movie.getReleaseDate(), movie.getDuration());
        });

        // Act
        List<MovieDTO> result = movieService.getMoviesByLocation(location);

        // Assert
        assertEquals(expectedMovieDTOs, result);
        verify(movieRepository).findMoviesByLocation("New York", "NY");
        verify(movieMapper, times(2)).toDTO(any(Movie.class));

    }
}