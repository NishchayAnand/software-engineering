package Entity;

public class ScreenEntity {
    private int screenId;
    private String screenName;
    private int theatreId;

    public ScreenEntity(int screenId, String screenName, int theatreId) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.theatreId = theatreId;
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

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }
}
