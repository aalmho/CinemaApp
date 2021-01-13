package com.cinemaApp.views;

import com.cinemaApp.business.Cinema;
import com.cinemaApp.views.viewUtils.UserInputUtil;
import com.cinemaApp.models.CinemaRoom;

import static com.cinemaApp.views.viewUtils.printUtil.print;

public class MetricView {

    private static final String CURRENT_INCOME = "Current income: ";
    private static final String NUMBER_OF_PURCHASED_TICKETS = "Number of purchased tickets: ";
    private static final String PERCENTAGE_OF_SEATS_OCCUPIED = "Percentage of seats occupied: ";
    private static final String TOTAL_POTENTIAL_INCOME = "Total potential income: ";
    private static final String PERCENTAGE = "%";

    public static void showMetrics() {
        Cinema.checkIfCinemaRoomsExist();
        CinemaRoom cinemaRoom = UserInputUtil.requestCinemaRoom();

        int currentIncome = cinemaRoom.getCurrentIncome();
        int numberOfPurchasedTickets = cinemaRoom.getNumberOfPurchasedTickets();
        int percentageOfSeatsOccupied = cinemaRoom.getPercentageOfSeatsOccupied();
        int totalPotentialIncome = cinemaRoom.getPotentialTotalIncome();

        print(CURRENT_INCOME + currentIncome);
        print(NUMBER_OF_PURCHASED_TICKETS + numberOfPurchasedTickets);
        print(PERCENTAGE_OF_SEATS_OCCUPIED + percentageOfSeatsOccupied + PERCENTAGE);
        print(TOTAL_POTENTIAL_INCOME + totalPotentialIncome);
        UserActionView.chooseWhatToDo();
    }
}
