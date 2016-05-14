package com.lgcampos.benchmark;

/**
 * @author Lucas Campos
 * @since 1.0.0
 */
public interface Observable {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();

}
