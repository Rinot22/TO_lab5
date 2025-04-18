package com.solution.cars;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Cars {
    private Random rd = new Random();
    private int ID;
    private boolean working;

    public Cars() {
        CarsID carsID = new CarsID();
        this.ID = carsID.getCarID();
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public boolean isWorking() {
        return working;
    }


    public void emergencyCall(boolean falseAlarm) {
        this.setWorking(true);

        try {
            TimeUnit.SECONDS.sleep(rd.nextInt(4));

            if (!falseAlarm) {
                TimeUnit.SECONDS.sleep(rd.nextInt(20) + 5);
            }

            TimeUnit.SECONDS.sleep(rd.nextInt(4));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setWorking(false);
    }
}
