package Model;

import java.util.List;

public class Theatre {
    private int theatreId;
    private Location location;
    private List<Screen> screens; // All screens for this Theatre

    public Theatre(int theatreId, Location location) {
        this.theatreId = theatreId;
        this.location = location;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public Location getLocation() {
        return location;
    }

    public void setAddress(Location location) {
        this.location = location;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
