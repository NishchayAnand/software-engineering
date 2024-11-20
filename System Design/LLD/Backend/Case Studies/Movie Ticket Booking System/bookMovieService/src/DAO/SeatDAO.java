package DAO;

import DTO.Seat;

import java.util.ArrayList;
import java.util.List;

public class SeatDAO {

    public List<Seat> getSeatsByShowId(int showId) {
        String sql = "SELECT * FROM seat WHERE showId = ?";
        /*
        List<Seat> seats = new ArrayList<>();
        while(resultSet.next()) {
            int seatId = resultSet.getInt("seatId");
            String seatNumber = resultSet.getString("seatNumber");
            String seatType = resultSet.getString("seatType");
            boolean isBooked = resultSet.getInt("isBooked");

            Seat seat = new Seat(seatId, seatNumber, seatType, isBooked);
            seats.add(seat);
        }
        return seats;
        */
        return new ArrayList<>();
    }

    public void updateSeatBookingStatus(int seatId, boolean isBooked) {
        String sql = "UPDATE seat SET isBooked = ? WHERE seatId = ?";
    }
}
