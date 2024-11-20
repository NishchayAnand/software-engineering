package DAO;

import DTO.Location;
import DTO.Screen;
import DTO.Theatre;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ScreenDAO {

    public Screen getScreenById(int screenId) {
        String sql = "SELECT * FROM screen WHERE screenId = ?";
        /*
        int screenId = resultSet.getInt("screenId");
        String screenName = resultSet.getString("screenName");
        int theatreId = resultSet.getInt("theatreId");

        Theatre theatre = theatreDAO.getTheatreById(theatreId);

        return new Screen(screenId, screenName, theatre);
        */
        Location location = new Location("Mumbai", "Maharashtra");
        Theatre theatre = new Theatre(1, location);
        return new Screen(1, "A", theatre);
    }
}
