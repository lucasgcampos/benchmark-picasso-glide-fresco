package com.lgcampos.benchmark.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 5/7/16.
 */
public class SubjectExample implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int someInt = 0;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(someInt);
        }
    }

    public void changeTemperature(int value) {
        this.someInt = value;
        notifyObservers();
    }
}
