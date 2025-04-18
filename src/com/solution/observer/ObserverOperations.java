package com.solution.observer;

import com.solution.event.CreateEvent;

public interface ObserverOperations {
    void registerObserver(IObserver observer);
    void removeObserver(IObserver observer);
    boolean notifyObservers(CreateEvent event);
    void notifyObserver(CreateEvent event, IObserver observer);
}
