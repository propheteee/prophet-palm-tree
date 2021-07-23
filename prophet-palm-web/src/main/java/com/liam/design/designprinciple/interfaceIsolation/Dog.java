package com.liam.design.designprinciple.interfaceIsolation;

/**
 * @author ：Prophet
 * @description：
 * @date ：2021/7/6 6:14 下午
 */
public class Dog implements Animal {
    @Override
    public void fly() {
        //无用的实现
    }


    @Override
    public void eat() {

    }

    @Override
    public void swim() {

    }
}
