package com.liam.design.designprinciple.interfaceIsolation;

/**
 * @author ：Prophet
 * @description： 接口隔离原则：尽量保证接口的纯洁性，客户端不应该依赖不需要的接口。
 * @date ：2021/7/6 6:13 下午
 */
public class Bird1 implements FlyAnimal, EatAnimal {//Bird1只需要实现eat和fly

    @Override
    public void fly() {

    }

    @Override
    public void eat() {

    }

}
