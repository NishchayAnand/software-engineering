package Entity;

import java.time.LocalDate;

public class ShowEntity {
    private int showId;
    private int movieId;
    private int screenId;
    private LocalDate showTime;

    public ShowEntity(int showId, int movieId, int screenId, LocalDate showTime) {
        this.showId = showId;
        this.movieId = movieId;
        this.screenId = screenId;
        this.showTime = showTime;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public LocalDate getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDate showTime) {
        this.showTime = showTime;
    }
}
