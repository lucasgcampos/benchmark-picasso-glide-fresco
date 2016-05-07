package com.lgcampos.benchmark.example;

/**
 * Created by lucas on 5/7/16.
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
