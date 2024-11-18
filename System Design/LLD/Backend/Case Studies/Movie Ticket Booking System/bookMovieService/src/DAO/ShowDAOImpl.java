package DAO;

import DTO.Theatre;
import Entity.ShowEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShowDAOImpl implements ShowDAO {
    @Override
    public List<ShowEntity> getShowsByScreenIdAndShowTimeBetween(int screenId, LocalDate startDate,
                                                                 LocalDate endDate) {
        String sql = String.format("SELECT * FROM show WHERE screenId = %d AND " +
                "showTime BETWEEN %s AND %s)", screenId, startDate.toString(),
                endDate.toString());
        // map resultSet to ShowEntity;
        return new ArrayList<>();
    }
}
