package com.liam.design.designmode.factory.abstractFactory;

import com.liam.design.designmode.factory.simpleFactory.Car;
import com.liam.design.designmode.factory.simpleFactory.Motor;


public abstract class AbstractFactory {

    protected abstract Car getCar();

    protected abstract Motor getMotor();

}
