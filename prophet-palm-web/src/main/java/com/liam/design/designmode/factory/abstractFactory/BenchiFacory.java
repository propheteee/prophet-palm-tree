package com.liam.design.designmode.factory.abstractFactory;

import com.liam.design.designmode.factory.simpleFactory.BenchiCar;
import com.liam.design.designmode.factory.simpleFactory.BenchiMotor;
import com.liam.design.designmode.factory.simpleFactory.Car;
import com.liam.design.designmode.factory.simpleFactory.Motor;

/**
 * Description:
 * Created by prophet on 2019/7/19 09:27
 */
public class BenchiFacory extends AbstractFactory {
    @Override
    public Car getCar() {
        return new BenchiCar();
    }

    @Override
    protected Motor getMotor() {
        return new BenchiMotor();
    }
}
