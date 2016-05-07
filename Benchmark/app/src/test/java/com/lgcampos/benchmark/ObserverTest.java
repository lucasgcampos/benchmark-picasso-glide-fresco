package com.lgcampos.benchmark;

import com.lgcampos.benchmark.example.Brazil;
import com.lgcampos.benchmark.example.Italy;
import com.lgcampos.benchmark.example.SubjectExample;

import org.junit.Test;

/**
 * Created by lucas on 5/7/16.
 */
public class ObserverTest {

    @Test
    public void testExample() throws Exception {
        SubjectExample publisher = new SubjectExample();

        // Anyone will receive the notify
        publisher.changeTemperature(10);

        System.out.println();
        System.out.println("Brazil will be notify");

        // Brazil will be notify
        Brazil brazil = new Brazil();
        publisher.registerObserver(brazil);
        publisher.changeTemperature(20);

        System.out.println();
        System.out.println("Brazil and Italy will be notify");

        // Brazil and Italy will be notify
        Italy italy = new Italy();
        publisher.registerObserver(italy);
        publisher.changeTemperature(30);

        System.out.println();
        System.out.println("Only Italy will be notify because brazil was removed");

        // Only Italy will be notify because brazil was removed
        publisher.removeObserver(brazil);
        publisher.changeTemperature(40);
    }
}
