/*
 * File: App.java
 * Created Date: 2021-09-24 22:13:27
 * Author: Madarász Dávid
 * Original Author: Sallai Andras
 * Github: https://github.com/afriyy
 * -----
 * Last Modified: 2021-10-05
 * Modified By: Madarász Dávid
 * -----
 * Copyright (c) 2021 Madarász Dávid
 * 
 * GNU GPL v2
 */

import controllers.MainController;
import views.MainWindow;

public class App {
    public static void main(String[] args) throws Exception {
        MainWindow mainWindow = new MainWindow();
        new MainController(mainWindow);
        mainWindow.setVisible(true);
    }
}
