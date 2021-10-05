/*
 * File: LoadVehicle.java
 * Created Date: 2021-09-25 00:46:41
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

package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadVehicle {
    ArrayList<String> vehicles;

    public LoadVehicle() {
        initVehicleList();
    }

    private void initVehicleList() {
        vehicles = new ArrayList<>();
    }

    public ArrayList<Vehicle> load() {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        try {
            vehicleList = tryLoad();
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található");
        }
        return vehicleList;
    }

    private ArrayList<Vehicle> tryLoad() throws FileNotFoundException {
        FileReader fileReader = new FileReader("data.txt");
        Scanner scanner = new Scanner(fileReader);
        ArrayList<Vehicle> vehicleList = fillListFromFile(scanner);
        return vehicleList;
    }

    private ArrayList<Vehicle> fillListFromFile(Scanner scanner) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Vehicle vehicle = initVehicle(line);
            vehicleList.add(vehicle);
        }
        scanner.close();
        return vehicleList;
    }

    private Vehicle initVehicle(String line) {
        String[] lineArray = line.split(":");
        Vehicle vehicle = new Vehicle();
        vehicle.ordinal = lineArray[0];
        vehicle.brand = lineArray[1];
        vehicle.year = lineArray[2];
        return vehicle;
    }
}
