package com.cinemaApp.business.businessUtils;

import com.cinemaApp.data.PriceData;
import com.cinemaApp.models.CinemaRoom;

public class PriceUtil {

    public static int calculateTicketPrice(CinemaRoom cinemaRoom, int reservedSeat) {
        if (SeatingUtil.isTotalNumberOfSeatsAboveFifty(cinemaRoom.getNumberOfRows(), cinemaRoom.getNumberOfColumns())
            && SeatingUtil.isSeatInFrontHalf(cinemaRoom, reservedSeat)) {
            return PriceData.PRICE_FOR_FRONT_HALF_IF_CAPACITY_IS_ABOVE_FIFTY;
        } else {
            return PriceData.REGULAR_PRICE;
        }
    }

    public static int calculateTotalPotentialIncome(int rows, int cols) {
        int totalNumberOfSeats = SeatingUtil.calculateTotalNumberOfSeats(rows, cols);
        int totalIncome;
        if (!SeatingUtil.isTotalNumberOfSeatsAboveFifty(rows, cols)) {
            return PriceData.REGULAR_PRICE * totalNumberOfSeats;
        } else {
            if (rows % 2 == 0) {
                int halfOfRows = cols / 2;
                int numberOfSeatsFromHalfRows = halfOfRows * cols;
                totalIncome = ((numberOfSeatsFromHalfRows * PriceData.PRICE_FOR_FRONT_HALF_IF_CAPACITY_IS_ABOVE_FIFTY) + (numberOfSeatsFromHalfRows * 10));
            } else {
                float halfOfRows = ((float) rows) / 2;
                int frontHalfRows = (int) (halfOfRows - 0.5F);
                int backHalfRows = (int) (halfOfRows + 0.5F);
                int numberOfFrontSeats = frontHalfRows * cols;
                int numberOfBackSeats = backHalfRows * cols;
                totalIncome = ((numberOfFrontSeats * PriceData.PRICE_FOR_FRONT_HALF_IF_CAPACITY_IS_ABOVE_FIFTY) + (numberOfBackSeats * 10));
            }
            return totalIncome;
        }
    }
}
