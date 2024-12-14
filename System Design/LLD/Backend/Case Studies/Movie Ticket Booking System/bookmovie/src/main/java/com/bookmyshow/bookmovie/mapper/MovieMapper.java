package com.bookmyshow.bookmovie.mapper;

import com.bookmyshow.bookmovie.dto.MovieDTO;
import com.bookmyshow.bookmovie.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {

    public MovieDTO toDTO(Movie movie) {
        return new MovieDTO(movie.getTitle(),
                movie.getGenre(),
                movie.getReleaseDate(),
                movie.getDuration()
        );
    }

}
