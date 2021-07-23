package com.liam.design.designmode.factory.simpleFactory;

/**
 * @author: Prophet
 * @description: 简单工厂：定义一个创建对象的类
 * @date: 2021/7/7 10:49 上午
 */
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(Factory.getCar("bmw").getName());
        System.out.println(Factory.getCar2(BmwCar.class));
    }
}
