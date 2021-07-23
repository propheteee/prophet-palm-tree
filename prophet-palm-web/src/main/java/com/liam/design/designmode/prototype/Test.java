package com.liam.design.designmode.prototype;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 * Created by prophet on 2019/7/19 17:54
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        car.setName("GEELY");
        List<String> compositions = Arrays.asList("tyre", "steering wheel");
        car.setCompositions(compositions);
        try {
            Car copy = (Car) car.clone();
            System.out.println(copy==car);
            //Car copy = (Car) car.deepClone1();
            Car copy2 = (Car) car.deepClone2();
            System.out.println(copy2.getName());
            System.out.println(copy2.getCompositions()==compositions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
