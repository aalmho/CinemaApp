package com.cinemaApp.tests;

import com.cinemaApp.business.Cinema;
import com.cinemaApp.business.Seating;
import com.cinemaApp.models.CinemaRoom;
import org.junit.Test;
import org.junit.Assert;

public class TestSeatReservation {

    @Test
    public void testSeatReservation() {
        int numberOfRows = 5;
        int numberOfCols = 5;
        int chosenRow = 2;
        int chosenCol = 2;

        CinemaRoom room = Cinema.createCinemaRoom(numberOfRows, numberOfCols);

        String[][] seats = room.getSeating();
        Assert.assertEquals("A", seats[chosenRow][chosenCol]);

        Seating.createSeatReservation(room, chosenRow, chosenCol);
        String[][] newSeats = room.getSeating();

        Assert.assertEquals("R", newSeats[chosenRow][chosenCol]);
    }
}
