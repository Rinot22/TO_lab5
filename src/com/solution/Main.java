package com.solution;

import com.solution.event.CreateEvent;
import com.solution.observer.Observer;
import com.solution.team.JRG;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        JRG jrg1 = new JRG(50.060026506499206,19.942913687967124,1);
        JRG jrg2 = new JRG(50.03381017495707, 19.937377226612714,2);
        JRG jrg3 = new JRG(50.084966689684386, 19.863450590629313,3);
        JRG jrg4 = new JRG(50.0378530292807, 20.005756855014358,4);
        JRG jrg5 = new JRG(50.09234339349529, 19.922380485906324,5);
        JRG jrg6 = new JRG(50.0164523302028, 20.017011360064917,6);
        JRG jrg7 = new JRG(50.09411730070909, 19.977544822836308,7);

        JRG SA = new JRG (50.07841255948872, 20.036627991006,8);
        JRG Skawina = new JRG(49.99067039026655, 19.736245522102028,9);
        JRG LSP = new JRG(50.08267540079839, 19.813889338168238,10);

        Observer observer = new Observer();
        observer.registerObserver(jrg1);
        observer.registerObserver(jrg2);
        observer.registerObserver(jrg3);
        observer.registerObserver(jrg4);
        observer.registerObserver(jrg5);
        observer.registerObserver(jrg6);
        observer.registerObserver(jrg7);

        observer.registerObserver(SA);
        observer.registerObserver(Skawina);
        observer.registerObserver(LSP);

        while (true) {
            try {
                TimeUnit.SECONDS.sleep(1);
                if (!observer.notifyObservers(new CreateEvent())) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
