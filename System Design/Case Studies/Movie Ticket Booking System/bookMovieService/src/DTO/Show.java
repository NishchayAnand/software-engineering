package DTO;

import java.time.LocalDateTime;

public class Show {
    private int showId;
    private Movie movie;
    private Theatre theatre;
    private Screen screen;
    private LocalDateTime showTime;

    public Show(int showId, Movie movie, Theatre theatre, Screen screen, LocalDateTime showTime) {
        this.showId = showId;
        this.movie = movie;
        this.theatre = theatre;
        this.screen = screen;
        this.showTime = showTime;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }
}
