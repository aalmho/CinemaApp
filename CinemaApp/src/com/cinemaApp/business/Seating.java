package com.cinemaApp.business;

import com.cinemaApp.models.CinemaRoom;
import com.cinemaApp.business.businessUtils.PriceUtil;
import com.cinemaApp.business.businessUtils.SeatingUtil;
import com.cinemaApp.views.BuyTicketView;

import static com.cinemaApp.views.viewUtils.printUtil.print;
import static com.cinemaApp.views.viewUtils.printUtil.printWithoutLineBreak;

public class Seating {

    public static final String AVAILABLE = "A";
    public static final String RESERVED = "R";

    public static void createSeatReservation(CinemaRoom cinemaRoom, int chosenRow, int chosenCol) {
        String[][] seating = cinemaRoom.getSeating();
        try {
        if (!seating[chosenRow][chosenCol].equals(RESERVED)) {
            seating[chosenRow][chosenCol] = RESERVED;

            cinemaRoom.setNumberOfPurchasedTickets(cinemaRoom.getNumberOfPurchasedTickets() + 1);
            cinemaRoom.setPercentageOfSeatsOccupied(SeatingUtil.calculatePercentageOfSeatsReserved(cinemaRoom));
            cinemaRoom.setCurrentIncome(cinemaRoom.getCurrentIncome() + PriceUtil.calculateTicketPrice(cinemaRoom, chosenRow));

            print("The seat has been reserved");
        } else {
            print("This seat is already reserved, please pick another seat");
            BuyTicketView.buyTicket(cinemaRoom);
        }
        } catch(IndexOutOfBoundsException e) {
            print("That seat doesn't exists, please pick another seat");
            BuyTicketView.buyTicket(cinemaRoom);
        }
    }

    public static String[][] createSeating(int numberOfRows, int numberOfColumns) {
        String[][] seating = new String[numberOfRows][numberOfColumns];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                seating[i][j] = AVAILABLE;
            }
        }
        return seating;
    }

    public static void showSeating(CinemaRoom cinemaRoom) {
        String blank = " ";
        String[][] seating = cinemaRoom.getSeating();

        for (int i = 0; i < cinemaRoom.getNumberOfRows(); i++) {
            for (int j = 0; j < cinemaRoom.getNumberOfColumns(); j++) {
                printWithoutLineBreak(seating[i][j] + blank);
            }
            print(blank);
        }
    }
}
