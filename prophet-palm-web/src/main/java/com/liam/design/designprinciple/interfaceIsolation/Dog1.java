package com.liam.design.designprinciple.interfaceIsolation;

/**
 * @author ：Prophet
 * @description： 接口隔离原则：尽量保证接口的纯洁性，客户端不应该依赖不需要的接口。
 * @date ：2021/7/6 6:14 下午
 */
public class Dog1 implements EatAnimal, SwimAnimal {//Dog1只需要实现eat和swim

    @Override
    public void eat() {

    }

    @Override
    public void swim() {

    }
}
