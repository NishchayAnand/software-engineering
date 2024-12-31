package com.bookmyshow.bookmovie.repository;

import com.bookmyshow.bookmovie.dto.Location;
import com.bookmyshow.bookmovie.model.Movie;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void shouldFindAllMoviesBasedOnCustomerSelectedCityAndState() {

        // given
        Location customerLocation = new Location("New York", "NY");

        // when
        List<Movie> movies = movieRepository.findMoviesByCityAndState(customerLocation.getCity(),
                customerLocation.getState());

        // then
        assertEquals(1, movies.size()); // Test Case 1
        assertEquals("Inception", movies.getFirst().getTitle()); // Test Case 2

    }

}