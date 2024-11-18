package DAO;

import DTO.Theatre;
import Entity.ShowEntity;

import java.time.LocalDate;
import java.util.List;

public interface ShowDAO {
    List<ShowEntity> getShowsByScreenIdAndShowTimeBetween(int screenId, LocalDate startDate,
                                                          LocalDate endDate);
}
