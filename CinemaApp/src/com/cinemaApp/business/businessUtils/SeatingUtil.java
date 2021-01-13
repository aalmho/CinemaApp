package com.cinemaApp.business.businessUtils;

import com.cinemaApp.business.Seating;
import com.cinemaApp.models.CinemaRoom;

public class SeatingUtil {

    public static int calculateTotalNumberOfSeats(int rows, int cols) {
        return rows * cols;
    }

    public static boolean isTotalNumberOfSeatsAboveFifty(int rows, int cols) {
        return rows * cols > 50;
    }

    public static boolean isSeatInFrontHalf(CinemaRoom cinemaRoom, int reservedSeatRow) {
           return (cinemaRoom.getNumberOfRows() / 2) > reservedSeatRow;
    }

    public static int totalNumberOfReservedSeats(CinemaRoom cinemaRoom) {
        String[][] seats = cinemaRoom.getSeating();
        int numberOfReservedSeats = 0;

        for (int i = 0; i < cinemaRoom.getNumberOfRows(); i++) {
            for (int j = 0; j < cinemaRoom.getNumberOfColumns(); j++) {
                if (seats[i][j].equals(Seating.RESERVED)) {
                    numberOfReservedSeats += 1;
                }
            }
        }
        return numberOfReservedSeats;
    }

    public static int calculatePercentageOfSeatsReserved(CinemaRoom cinemaRoom) {
        float totalNumberOfSeats = calculateTotalNumberOfSeats(cinemaRoom.getNumberOfRows(), cinemaRoom.getNumberOfColumns());
        float totalNumberOfReservedSeats = totalNumberOfReservedSeats(cinemaRoom);
        float percentageOfSeatsReserved = (totalNumberOfReservedSeats / totalNumberOfSeats) * 100;
        return (int) percentageOfSeatsReserved;
    }
}
