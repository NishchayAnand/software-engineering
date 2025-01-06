package DTO;

import java.time.LocalDate;
import java.util.List;

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

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
