package DAO;

import java.util.List;

public class Theatre {
    private int theatreId;
    private Address address;
    private List<Screen> screens; // All screens for this Theatre

    public Theatre(int theatreId, Address address, List<Screen> screens) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
}
