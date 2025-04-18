package com.solution.event.events;

public class LocalThreats implements Activity {
    @Override
    public boolean doActivity() {
        System.out.println("It's local threat.");
        return false;
    }
}
