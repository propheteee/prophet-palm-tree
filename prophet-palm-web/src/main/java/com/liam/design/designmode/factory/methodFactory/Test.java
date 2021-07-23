package com.liam.design.designmode.factory.methodFactory;

/**
 * @author: Prophet
 * @description: 工厂方法模式：定义一个创建对象的接口，让实现这个接口的类来决定实例化哪个类。
 * @date: 2021/7/7 10:46 上午
 */
public class Test {
    public static void main(String[] args) {
        MethodFactory benchiFacory = new BenchiFacory();
        benchiFacory.getCar();

        MethodFactory bmwFactory = new BmwFactory();
        bmwFactory.getCar();
    }
}
