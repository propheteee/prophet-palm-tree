package com.liam.design.designmode.factory.methodFactory;

import com.liam.design.designmode.factory.simpleFactory.BmwCar;
import com.liam.design.designmode.factory.simpleFactory.Car;

/**
 * @author: Prophet
 * @description:
 * @date: 2021/7/7 10:50 上午
 */
public class BmwFactory implements MethodFactory {
    @Override
    public Car getCar() {
        System.out.println("生成宝马标配的汽车");
        return new BmwCar();
    }
}
