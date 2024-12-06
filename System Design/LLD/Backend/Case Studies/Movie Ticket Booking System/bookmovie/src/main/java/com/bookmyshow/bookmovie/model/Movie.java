package com.bookmyshow.bookmovie.model;

import java.time.LocalDate;

public class Movie {
    private int movieId;
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private int duration;

    public Movie(int movieId, String title, String genre, LocalDate releaseDate, int duration) {
        this.movieId = movieId;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.duration = duration;
    }

}
