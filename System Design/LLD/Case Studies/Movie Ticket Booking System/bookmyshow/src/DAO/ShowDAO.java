package DAO;

import Model.Theatre;

import java.time.LocalDate;
import java.util.List;

public interface ShowDAO {
    List<Integer> getMovieIdsByTheatreAndShowTimeBetween(Theatre theatre, LocalDate startDate,
                                                  LocalDate endDate);
}
