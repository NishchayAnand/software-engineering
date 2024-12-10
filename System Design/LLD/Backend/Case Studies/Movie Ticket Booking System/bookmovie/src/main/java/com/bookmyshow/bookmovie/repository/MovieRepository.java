package com.bookmyshow.bookmovie.repository;

import com.bookmyshow.bookmovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    public List<Movie> findMoviesByLocation(String city, String state);

}
