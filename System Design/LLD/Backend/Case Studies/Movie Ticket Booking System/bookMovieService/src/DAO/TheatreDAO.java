package DAO;

import DTO.Location;
import DTO.Theatre;
import Entity.TheatreEntity;

import java.util.List;

public interface TheatreDAO {
    List<TheatreEntity> getTheatresByLocation(Location location);
}
