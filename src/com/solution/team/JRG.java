package com.solution.team;

import com.solution.cars.Cars;
import com.solution.event.CreateEvent;
import com.solution.observer.IObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JRG implements IObserver {
    private int ID;
    private double coordsX;
    private double coordsY;
    private List<Cars> carsList;
    private int freeCarsCounter = 0;

    public JRG(double coordsX, double coordsY, int ID) {
        this.ID = ID;
        this.coordsX = coordsX;
        this.coordsY = coordsY;
        this.carsList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            carsList.add(new Cars());
        }
    }

    public double getCoordsX() {
        return coordsX;
    }

    public double getCoordsY() {
        return coordsY;
    }

    public int countFreeCars() {
        for (Cars cars : carsList) {
            if (!cars.isWorking()) {
                freeCarsCounter++;
            }
        }

        return freeCarsCounter;
    }

    public int getFreeCarsCounter() {
        return freeCarsCounter;
    }



    @Override
    public void updateEvent(CreateEvent event, int numberOfCars) {
        boolean falseAlarm = new Random().nextDouble(1) < 0.05;

        for (Cars car : carsList) {
            if (numberOfCars == 0) break;

            if (!car.isWorking()) {
                car.setWorking(true);
                numberOfCars--;
                new Thread( () -> car.emergencyCall(falseAlarm)).start();
            }
        }
    }
}
