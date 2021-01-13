package com.cinemaApp.business;

import com.cinemaApp.models.CinemaRoom;
import com.cinemaApp.business.businessUtils.PriceUtil;
import com.cinemaApp.views.UserActionView;

import static com.cinemaApp.data.CinemaData.listOfCinemaRooms;
import static com.cinemaApp.views.viewUtils.printUtil.print;

public class Cinema {

    public static CinemaRoom createCinemaRoom(int numberOfRows, int numberOfColumns) {
        String[][] seating = Seating.createSeating(numberOfRows, numberOfColumns);

        CinemaRoom cinemaRoom = new CinemaRoom(listOfCinemaRooms.size() + 1, numberOfRows, numberOfColumns, seating);

        cinemaRoom.setPotentialTotalIncome(PriceUtil.calculateTotalPotentialIncome(numberOfRows, numberOfColumns));
        listOfCinemaRooms.add(cinemaRoom);

        return cinemaRoom;
    }

    public static void checkIfCinemaRoomsExist() {
        if (listOfCinemaRooms.isEmpty()) {
            print("No cinema rooms are created yet");
            UserActionView.chooseWhatToDo();
        }
    }

}

