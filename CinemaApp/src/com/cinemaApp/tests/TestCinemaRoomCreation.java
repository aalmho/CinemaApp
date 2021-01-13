package com.cinemaApp.tests;

import com.cinemaApp.business.Cinema;
import com.cinemaApp.business.Seating;
import com.cinemaApp.models.CinemaRoom;
import com.cinemaApp.business.businessUtils.PriceUtil;
import org.junit.Test;
import org.junit.Assert;

public class TestCinemaRoomCreation {

    private final int numberOfRows = 5;
    private final int numberOfCols = 5;

    @Test
    public void testCinemaRoomCreation() {

        CinemaRoom cinemaRoom = Cinema.createCinemaRoom(numberOfRows, numberOfCols);

        Assert.assertEquals(0, cinemaRoom.getCurrentIncome());
        Assert.assertEquals(0, cinemaRoom.getNumberOfPurchasedTickets());
        Assert.assertEquals(PriceUtil.calculateTotalPotentialIncome(numberOfRows, numberOfCols), cinemaRoom.getPotentialTotalIncome());
        Assert.assertEquals(0, cinemaRoom.getPercentageOfSeatsOccupied());
    }

    @Test
    public void testMetricsAfterReservation() {
        int chosenRow = 2;
        int chosenCol = 4;

        CinemaRoom cinemaRoom = Cinema.createCinemaRoom(numberOfRows, numberOfCols);
        Seating.createSeatReservation(cinemaRoom, chosenRow, chosenCol);

        Assert.assertEquals(10, cinemaRoom.getCurrentIncome());
        Assert.assertEquals(1, cinemaRoom.getNumberOfPurchasedTickets());
        Assert.assertEquals(PriceUtil.calculateTotalPotentialIncome(numberOfRows, numberOfCols), cinemaRoom.getPotentialTotalIncome());
        Assert.assertEquals(4, cinemaRoom.getPercentageOfSeatsOccupied());

    }
}
