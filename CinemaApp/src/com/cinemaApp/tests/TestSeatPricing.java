package com.cinemaApp.tests;

import com.cinemaApp.business.Cinema;
import com.cinemaApp.business.Seating;
import com.cinemaApp.models.CinemaRoom;
import org.junit.Test;
import org.junit.Assert;

public class TestSeatPricing {

    @Test
    public void testSeatPriceWhenCinemaIsAboveFiftySeats() {
        int numberOfRows = 10;
        int numberOfCols = 10;
        int chosenRow = 2;
        int chosenCol = 4;

        CinemaRoom cinemaRoom = Cinema.createCinemaRoom(numberOfRows, numberOfCols);
        Seating.createSeatReservation(cinemaRoom, chosenRow, chosenCol);

        Assert.assertEquals(12, cinemaRoom.getCurrentIncome());
    }

    @Test
    public void testSeatPriceWhenCinemaIsBelowFiftySeats() {
        int numberOfRows = 5;
        int numberOfCols = 5;
        int chosenRow = 2;
        int chosenCol = 4;

        CinemaRoom cinemaRoom = Cinema.createCinemaRoom(numberOfRows, numberOfCols);
        Seating.createSeatReservation(cinemaRoom, chosenRow, chosenCol);

        Assert.assertEquals(10, cinemaRoom.getCurrentIncome());
    }
}
