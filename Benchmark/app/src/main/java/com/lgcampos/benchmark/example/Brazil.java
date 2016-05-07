package com.lgcampos.benchmark.example;

/**
 * Created by lucas on 5/7/16.
 */
public class Brazil implements Observer {
    @Override
    public void update(int someInt) {
        //TODO: configure the specific behavior for Brazil with someInt
        System.out.println(String.format("Brazil receive this data -> %d", someInt));
    }
}
