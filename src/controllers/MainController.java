/*
 * File: MainController.java
 * Created Date: 2021-09-24 22:21:42
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

package controllers;

import java.util.ArrayList;
import models.LoadVehicle;
import models.Vehicle;
import views.MainWindow;

public class MainController {

    MainWindow mainWindow;
    LoadVehicle loadVehicle;

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        fillVehicleList();
        initAddButton();
        initDelButton();
        initSaveButton();
    }

    private void initAddButton() {
        this.mainWindow.addButton.addActionListener(event -> {
            System.out.println("Hozzáadás...");
            String ordinal = this.mainWindow.ordinalField.getText();
            String brand = this.mainWindow.brandField.getText();
            String year = this.mainWindow.yearField.getText();
            setFields();
            this.mainWindow.vehicleModel.addRow(new Object[] { ordinal, brand, year });
        });
    }

    private void setFields() {
        this.mainWindow.ordinalField.setText("");
        this.mainWindow.brandField.setText("");
        this.mainWindow.yearField.setText("");
    }

    private void initDelButton() {
        this.mainWindow.delButton.addActionListener(event -> {
            System.out.println("Törlés...");
        });
    }

    private void initSaveButton() {
        this.mainWindow.saveButton.addActionListener(event -> {
            System.out.println("Mentés...");
        });
    }

    private void fillVehicleList() {
        this.loadVehicle = new LoadVehicle();
        ArrayList<Vehicle> vehicleList = this.loadVehicle.load();
        for (Vehicle vehicle : vehicleList) {
            this.mainWindow.vehicleModel.addRow(new Object[] { vehicle.ordinal, vehicle.brand, vehicle.year });
        }
    }

}