package com.solution.event.events;

public class FireAlarm implements Activity {
    @Override
    public boolean doActivity() {
        System.out.println("It's fire alarm.");
        return true;
    }
}
