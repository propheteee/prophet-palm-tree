package com.liam.design.designprinciple.interfaceIsolation;

/**
 * @author ：Prophet
 * @description：
 * @date ：2021/7/6 6:13 下午
 */
public class Bird implements Animal {

    @Override
    public void fly() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void swim() {
        //无用的实现
    }
}
