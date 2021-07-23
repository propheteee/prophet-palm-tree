package com.liam.design.designmode.factory.abstractFactory;

/**
 * @author: Prophet
 * @description: 抽象工厂：定义一个创建一系列相关或者相互依赖的对象的接口，且无需指定他们具体的类
 * @date: 2021/7/7 10:48 上午
 */
public class Test {
    public static void main(String[] args) {
        BenchiFacory benchiFacory = new BenchiFacory();
        benchiFacory.getCar();
        benchiFacory.getMotor();
    }
}
