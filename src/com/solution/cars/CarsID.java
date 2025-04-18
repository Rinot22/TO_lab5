package com.solution.cars;

public class CarsID {
    private static int carID = 0;

    public CarsID() {
        carID++;
    }

    public int getCarID() {
        return carID;
    }
}
