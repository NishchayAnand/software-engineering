package DAO;

import java.util.List;

public class Screen {
    private int screenId;
    private String screenName;
    private Theatre theatre;
    private List<Seat> seats; // All seats for this screen
    private List<Show> shows; // All shows scheduled on this screen

    public Screen(int screenId, Theatre theatre, List<Seat> seats, List<Show> shows) {
        this.screenId = screenId;
        this.theatre = theatre;
        this.seats = seats;
        this.shows = shows;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
