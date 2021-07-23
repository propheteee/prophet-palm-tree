package com.liam.design.designmode.factory.methodFactory;

import com.liam.design.designmode.factory.simpleFactory.BenchiCar;
import com.liam.design.designmode.factory.simpleFactory.Car;

/**
 * @author: Prophet
 * @description:
 * @date: 2021/7/7 10:52 上午
 */
public class BenchiFacory implements MethodFactory {
    @Override
    public Car getCar() {
        System.out.println("生成奔驰标配的汽车");
        return new BenchiCar();
    }
}
