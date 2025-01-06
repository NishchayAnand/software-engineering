package DAO;

import DTO.Location;
import DTO.Screen;
import DTO.Theatre;

public class ScreenDAO {

    private static ScreenDAO screenDAO;

    private ScreenDAO() {}

    // Thread-Safe: Overhead due to synchronized access, especially in scenarios with frequent calls
    // to getInstance().
    public static synchronized ScreenDAO getInstance() {
        if(screenDAO == null) screenDAO = new ScreenDAO();
        return screenDAO;
    }

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
