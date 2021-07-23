package com.liam.design.designmode.factory.abstractFactory;

import com.liam.design.designmode.factory.simpleFactory.BmwCar;
import com.liam.design.designmode.factory.simpleFactory.BmwMotor;
import com.liam.design.designmode.factory.simpleFactory.Car;
import com.liam.design.designmode.factory.simpleFactory.Motor;

/**
 * Created by prophet on 2019/7/19 09:31
 */
public class BmwFactory extends AbstractFactory {

    @Override
    public Car getCar() {
        return new BmwCar();
    }

    @Override
    protected Motor getMotor() {
        return new BmwMotor();
    }
}
