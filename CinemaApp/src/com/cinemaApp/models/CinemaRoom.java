package com.cinemaApp.models;

public class CinemaRoom {

    private int cinemaRoomId;
    private int numberOfRows;
    private int numberOfColumns;
    private int numberOfPurchasedTickets;
    private int percentageOfSeatsOccupied;
    private int potentialTotalIncome;
    private int currentIncome;
    private String[][] seating;

    public CinemaRoom(int cinemaRoomId, int numberOfRows, int numberOfColumns, String[][] seating) {
        setCinemaRoomId(cinemaRoomId);
        setNumberOfRows(numberOfRows);
        setNumberOfColumns(numberOfColumns);
        setSeating(seating);
        setCurrentIncome(0);
        setPercentageOfSeatsOccupied(0);
        setNumberOfPurchasedTickets(0);
    }

    public void setCinemaRoomId(int cinemaRoomId) { this.cinemaRoomId = cinemaRoomId; }

    public int getCinemaRoomId() { return cinemaRoomId; }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setPercentageOfSeatsOccupied(int percentageOfSeatsOccupied) {
        this.percentageOfSeatsOccupied = percentageOfSeatsOccupied;
    }

    public int getPercentageOfSeatsOccupied() {
        return percentageOfSeatsOccupied;
    }

    public void setCurrentIncome(int currentIncome) {this.currentIncome = currentIncome; }

    public int getCurrentIncome() { return currentIncome; }

    public void setPotentialTotalIncome(int potentialTotalIncome) {
        this.potentialTotalIncome = potentialTotalIncome;
    }

    public int getPotentialTotalIncome() {
        return potentialTotalIncome;
    }

    public void setSeating(String[][] seating) {
        this.seating = seating;
    }

    public String[][] getSeating() {
        return seating;
    }
}
