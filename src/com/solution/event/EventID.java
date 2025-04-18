package com.solution.event;

public class EventID {
    private static int eventID = 0;

    public EventID() {
        eventID++;
    }

    public int getID() {
        return eventID;
    }
}
