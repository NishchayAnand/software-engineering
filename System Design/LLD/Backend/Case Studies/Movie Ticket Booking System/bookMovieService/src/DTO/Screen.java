package DTO;

import java.util.List;

public class Screen {
    private int screenId;
    private String screenName;
    private Theatre theatre;

    public Screen(int screenId, String screenName, Theatre theatre) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.theatre = theatre;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
