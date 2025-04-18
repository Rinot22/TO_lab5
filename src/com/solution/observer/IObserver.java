package com.solution.observer;

import com.solution.event.CreateEvent;

public interface IObserver {
    void updateEvent(CreateEvent event, int numberOfCars);
}
