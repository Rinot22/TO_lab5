package com.solution.observer;

import com.solution.event.CreateEvent;
import com.solution.strategy.strategies.FireAlarmStrategy;
import com.solution.strategy.strategies.LocalThreatsStrategy;
import com.solution.team.JRG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Observer implements ObserverOperations {
    private List<IObserver> observerList;

    public Observer() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        int ID = observerList.indexOf(observer);
        if (ID > -1) {
            observerList.remove(observer)
;        }
    }

    @Override
    public boolean notifyObservers(CreateEvent event) {
        Map<JRG, Double> distance = new HashMap<>();

        for (IObserver observer : observerList) {
            distance.put((JRG) observer, getDistance(observer, event));
        }

        int carsRequired = doOperation(event);

        for (JRG jrg : distance.keySet()) {
            if (jrg.getFreeCarsCounter() >= carsRequired) {
                jrg.updateEvent(event, carsRequired);
                carsRequired = 0;
                break;
            } else {
                carsRequired -= jrg.getFreeCarsCounter();
                jrg.updateEvent(event, carsRequired);
            }
        }

        return carsRequired == 0;
    }

    @Override
    public void notifyObserver(CreateEvent event, IObserver observer) {

    }

    public double getDistance(IObserver observer, CreateEvent event) {
        JRG jrg = (JRG) observer;

        return Math.sqrt(Math.pow((jrg.getCoordsX() - event.getCoordsX()),2) + Math.pow((jrg.getCoordsY() - event.getCoordsY()),2));
    }

    public int doOperation(CreateEvent event) {
        if (event.doActivity()) {
            return new FireAlarmStrategy().working();
        } else {
            return new LocalThreatsStrategy().working();
        }
    }
}
