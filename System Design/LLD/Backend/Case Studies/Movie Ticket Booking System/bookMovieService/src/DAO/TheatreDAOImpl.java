package DAO;

import DTO.Location;
import Entity.TheatreEntity;

import java.util.ArrayList;
import java.util.List;

public class TheatreDAOImpl implements TheatreDAO {
    @Override
    public List<TheatreEntity> getTheatresByLocation(Location location) {
        String sql = String.format("select * from theatre where city = %s and " +
                "state = %s and country = %s", location.getCity(), location.getState(),
                location.getCountry());

        return new ArrayList<>();
    }
}
