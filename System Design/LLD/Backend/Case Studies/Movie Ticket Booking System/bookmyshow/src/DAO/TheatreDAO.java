package DAO;

import Model.Location;
import Model.Theatre;

import java.util.List;

public interface TheatreDAO {
    List<Theatre> getTheatresByLocation(Location location);
}
