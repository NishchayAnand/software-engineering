package DAO;

import Entity.ScreenEntity;

import java.util.List;

public interface ScreenDAO {
    List<ScreenEntity> getScreensByThreatreId(int theatreId);
}
