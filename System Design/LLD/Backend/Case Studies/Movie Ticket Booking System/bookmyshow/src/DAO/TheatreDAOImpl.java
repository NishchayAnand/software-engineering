package DAO;

import Model.Location;
import Model.Theatre;

import java.util.ArrayList;
import java.util.List;

public class TheatreDAOImpl implements TheatreDAO {
    @Override
    public List<Theatre> getTheatresByLocation(Location location) {
        String sql = String.format("select * from theatre where city = %s and " +
                "state = %s and country = %s", location.getCity(), location.getState(),
                location.getCountry());
        // map each ResultSet(theatreId, street, city, state, country, postalCode) to
        // Theatre(theatreId, Location).
        return new ArrayList<>();
    }
}
