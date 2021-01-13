package com.cinemaApp.views;

import com.cinemaApp.business.Cinema;
import com.cinemaApp.business.Seating;
import com.cinemaApp.models.CinemaRoom;
import com.cinemaApp.views.viewUtils.UserInputUtil;

public class CinemaRoomSeatingView {

    public static void showCinemaRoomSeating() {
        Cinema.checkIfCinemaRoomsExist();
        CinemaRoom cinemaRoom = UserInputUtil.requestCinemaRoom();
        Seating.showSeating(cinemaRoom);
        UserActionView.chooseWhatToDo();
    }
}
