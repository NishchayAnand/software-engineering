package com.bookmyshow.bookmovie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="movie_id")
    private Long movieId;

    private String title;
    private String genre;

    @Column(name="release_date")
    private LocalDate releaseDate;

    private int duration; // in minutes

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> shows;

}
