package Model;

import java.time.LocalDateTime;

public class Show {
    private int showId;
    private Movie movie; // Movie being shown
    private Screen screen; // Screen where the show will take place
    private LocalDateTime showTime; // Date and time of the show

    public Show(int showId, Movie movie, Screen screen, LocalDateTime showTime) {
        this.showId = showId;
        this.movie = movie;
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
