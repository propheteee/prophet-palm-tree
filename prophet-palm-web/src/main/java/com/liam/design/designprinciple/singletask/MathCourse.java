package com.liam.design.designprinciple.singletask;

/**
 * @author ：Prophet
 * @description： 单一职责原则：一个类、接口、方法只做一件事。
 * @date ：2021/7/6 5:57 下午
 */
public class MathCourse {
    public void study() {
        System.out.println("math");
    }

    public static void main(String[] args) {
        //解耦Course类的英语课学习和数学课学习
        new EnglishCourse().study();
        new MathCourse().study();
    }
}
