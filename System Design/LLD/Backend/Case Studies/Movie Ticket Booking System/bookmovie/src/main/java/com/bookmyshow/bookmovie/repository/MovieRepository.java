package com.bookmyshow.bookmovie.repository;

import com.bookmyshow.bookmovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT DISTINCT m FROM Movie m " +
            "JOIN m.shows s " +
            "JOIN s.screen sc " +
            "WHERE sc.theatre.location.city = :city AND " +
            "sc.theatre.location.state = :state")
    List<Movie> findMoviesByLocation(@Param("city") String city, @Param("state") String state);

}
