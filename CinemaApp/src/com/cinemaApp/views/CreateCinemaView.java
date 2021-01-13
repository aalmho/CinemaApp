package com.cinemaApp.views;

import com.cinemaApp.business.Cinema;
import com.cinemaApp.models.CinemaRoom;
import com.cinemaApp.views.viewUtils.UserInputUtil;

import static com.cinemaApp.views.viewUtils.printUtil.print;

public class CreateCinemaView {
    public static void createCinema() {
        int numberOfRows = UserInputUtil.requestRowsToCreate();
        int numberOfColumns = UserInputUtil.requestColsToCreate();

        CinemaRoom cinemaRoom = Cinema.createCinemaRoom(numberOfRows, numberOfColumns);

        print("Cinema room number " + cinemaRoom.getCinemaRoomId() + " was created");
        UserActionView.chooseWhatToDo();
    }
}
