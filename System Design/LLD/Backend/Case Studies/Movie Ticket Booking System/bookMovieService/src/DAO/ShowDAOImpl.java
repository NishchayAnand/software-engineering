package DAO;

import DTO.Theatre;
import Entity.ShowEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShowDAOImpl implements ShowDAO {
    @Override
    public List<ShowEntity> getShowsByScreenId(int screenId) {
        String sql = String.format("SELECT * FROM show WHERE screenId = %d", screenId);
        // map resultSet to ShowEntity;
        return new ArrayList<>();
    }
}
