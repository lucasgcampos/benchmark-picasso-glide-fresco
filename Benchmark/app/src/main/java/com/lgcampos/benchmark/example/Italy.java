package com.lgcampos.benchmark.example;

/**
 * Created by lucas on 5/7/16.
 */
public class Italy implements Observer {
    @Override
    public void update(int someInt) {
        //TODO: configure the specific behavior for Italy with someInt
        System.out.println(String.format("Italy receive this data -> %d", someInt));
    }
}
