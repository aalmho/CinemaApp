package com.cinemaApp.views;

import static com.cinemaApp.views.viewUtils.printUtil.print;

public class WelcomeView {

    public static void welcome() {
        print("Please select what You want to do");
        UserActionView.chooseWhatToDo();
    }

}
