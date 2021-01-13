package com.cinemaApp.views;

import static com.cinemaApp.views.viewUtils.printUtil.print;

import java.util.Scanner;

public class UserActionView {

    private static final String A = "A";
    private static final String B = "B";
    private static final String C = "C";
    private static final String D = "D";
    private static final String E = "E";

    public static void chooseWhatToDo() {
        String userAction = chooseAction();

        switch (userAction.toUpperCase()) {
            case A:
                CreateCinemaView.createCinema();
                break;
            case B:
                CinemaRoomSeatingView.showCinemaRoomSeating();
                break;
            case C:
                BuyTicketView.buyTicket();
                break;
            case D:
                MetricView.showMetrics();
                break;
            case E:
                System.exit(0);
            default:
                print("Please choose between the listed options");
                chooseWhatToDo();
        }
    }

    private static String chooseAction() {
        print("[A] Create cinema room");
        print("[B] Show seating");
        print("[C] Buy ticket");
        print("[D] Show cinema metrics");
        print("[E] Exit");
        return new Scanner(System.in).nextLine();
    }
}
