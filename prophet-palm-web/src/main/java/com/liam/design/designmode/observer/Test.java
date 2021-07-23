package com.liam.design.designmode.observer;

/**
 * Description:观察者模式
 * Created by prophet on 2020/3/7 18:24
 */
public class Test {
    public static void main(String[] args) {

        IdolImpl idol = new IdolImpl();
        idol.addFun(new FunA());
        idol.addFun(new FunB());
        idol.notifyA("大家好，我是蔡徐坤");
    }
}
