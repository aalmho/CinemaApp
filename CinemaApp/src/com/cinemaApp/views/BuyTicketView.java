package com.cinemaApp.views;

import com.cinemaApp.business.Cinema;
import com.cinemaApp.business.Seating;
import com.cinemaApp.models.CinemaRoom;
import com.cinemaApp.views.viewUtils.UserInputUtil;

public class BuyTicketView {

    public static void buyTicket() {
        Cinema.checkIfCinemaRoomsExist();
        CinemaRoom cinemaRoom = UserInputUtil.requestCinemaRoom();

        int seatRow = UserInputUtil.requestSeatRow(cinemaRoom);
        int seatCol = UserInputUtil.requestSeatCol(cinemaRoom);

        Seating.createSeatReservation(cinemaRoom, seatRow, seatCol);
        UserActionView.chooseWhatToDo();
    }

    public static void buyTicket(CinemaRoom cinemaRoom) {
        int seatRow = UserInputUtil.requestSeatRow(cinemaRoom);
        int seatCol = UserInputUtil.requestSeatCol(cinemaRoom);

        Seating.createSeatReservation(cinemaRoom, seatRow, seatCol);
        UserActionView.chooseWhatToDo();
    }
}
