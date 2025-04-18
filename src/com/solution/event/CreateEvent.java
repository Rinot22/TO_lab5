package com.solution.event;

import com.solution.constant.Constants;
import com.solution.event.events.Activity;
import com.solution.event.events.FireAlarm;
import com.solution.event.events.LocalThreats;

import java.util.Random;

public class CreateEvent implements Activity {
    private int ID;
    private Activity activity;
    private double coordsX;
    private double coordsY;
    private final Random rd = new Random();

    public CreateEvent() {
        EventID eventID = new EventID();

        this.ID = eventID.getID();


        if (rd.nextInt(10) < 3) {
            this.activity = new FireAlarm();
        } else {
            this.activity = new LocalThreats();
        }


        this.coordsX = (rd.nextDouble() * (Constants.MAX_X_COORDS - Constants.MIN_X_COORDS)) + Constants.MIN_X_COORDS;
        this.coordsY = (rd.nextDouble() * (Constants.MAX_Y_COORDS - Constants.MIN_Y_COORDS)) + Constants.MIN_Y_COORDS;
    }

    public double getCoordsX() {
        return coordsX;
    }

    public double getCoordsY() {
        return coordsY;
    }

    @Override
    public boolean doActivity() {
        return this.activity.doActivity();
    }
}
