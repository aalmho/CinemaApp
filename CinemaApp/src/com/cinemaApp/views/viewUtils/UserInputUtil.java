package com.cinemaApp.views.viewUtils;

import com.cinemaApp.models.CinemaRoom;

import java.util.*;

import static com.cinemaApp.data.CinemaData.listOfCinemaRooms;
import static com.cinemaApp.views.viewUtils.printUtil.print;

public class UserInputUtil {

    public static CinemaRoom requestCinemaRoom() {
        print("Choose a cinema room between the following numbers: " + Arrays.toString(getCinemaRoomIds().toArray()));
        int chosenCinemaRoom = 0;

        try {
            chosenCinemaRoom = new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            print("Please specify a number");
            requestCinemaRoom();
        }

        if (isValidRoom(chosenCinemaRoom)) {
            return listOfCinemaRooms.get(chosenCinemaRoom - 1);
        }
        return requestCinemaRoom();
    }

    public static int requestSeatRow(CinemaRoom cinemaRoom) {
        print("Pick a seat row between 0 and " + (cinemaRoom.getNumberOfRows() -1));
        return new Scanner(System.in).nextInt();
    }

    public static int requestSeatCol(CinemaRoom cinemaRoom) {
        print("Pick a seat column between 0 and " + (cinemaRoom.getNumberOfColumns() -1));
        return new Scanner(System.in).nextInt();
    }

    public static int requestRowsToCreate() {
        print("Choose how many rows");
        return new Scanner(System.in).nextInt() ;
    }

    public static int requestColsToCreate() {
        print("Choose how many columns");
        return new Scanner(System.in).nextInt();
    }

    private static List<Integer> getCinemaRoomIds() {
        List<Integer> cinemaRoomIds = new ArrayList<>();

        for(CinemaRoom cinemaRoom : listOfCinemaRooms) {
            cinemaRoomIds.add(cinemaRoom.getCinemaRoomId());
        }
        return cinemaRoomIds;
    }

    private static boolean isValidRoom(int chosenCinemaRoom) {
        try {
            listOfCinemaRooms.get(chosenCinemaRoom - 1);
        } catch (IndexOutOfBoundsException e) {
            print("Cinema room number " + chosenCinemaRoom + " doesn't exists");
            return false;
        }
        return true;
    }
}
