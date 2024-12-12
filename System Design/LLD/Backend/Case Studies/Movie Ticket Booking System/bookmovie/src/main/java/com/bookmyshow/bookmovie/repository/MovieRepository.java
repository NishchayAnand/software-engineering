package com.bookmyshow.bookmovie.repository;

import com.bookmyshow.bookmovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m " +
            "JOIN .shows s " +
            "WHERE s.screen.theatre.city = :city AND " +
            "s.screen.theatre.state = :state")
    public List<Movie> findMoviesByLocation(String city, String state);

}
