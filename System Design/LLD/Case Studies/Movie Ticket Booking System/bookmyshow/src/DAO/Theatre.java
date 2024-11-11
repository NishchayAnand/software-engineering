package DAO;

import java.util.List;

public class Theatre {
    private int theatreId;
    private String address;
    private List<Screen> screens; // All screens for this Theatre

    public Theatre(int theatreId, String address, List<Screen> screens) {
        this.theatreId = theatreId;
        this.address = address;
        this.screens = screens;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
