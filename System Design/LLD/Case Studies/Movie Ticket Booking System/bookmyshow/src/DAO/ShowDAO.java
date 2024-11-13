package DAO;

import Model.Show;
import Model.Theatre;

import java.time.LocalDate;
import java.util.List;

public interface ShowDAO {
    List<Show> getShowByTheatreAndShowTimeBetween(Theatre theatre, LocalDate startDate,
                                                  LocalDate endDate);
}
