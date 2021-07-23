package com.liam.design.designmode.decorate;

/**
 * @author ：Prophet
 * @description：
 * 装饰者模式：
 * 1、在不改变原有对象的基础上，动态的给一个对象扩展功能，即插即用
 * 2、通过不同装饰类以及这些装饰类的排列组合可以实现不同效果
 * @date ：2021/7/16 5:28 下午
 */
public class Test {
    public static void main(String[] args) {
        AbstractPancake pancake = new BasePancake();
        pancake = new EggDecorate(pancake);
        pancake = new EggDecorate(pancake);
        pancake = new HamDecorate(pancake);
    }
}
