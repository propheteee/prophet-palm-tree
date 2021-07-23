package com.liam.design.designmode.observer;

/**
 * Description:
 * Created by prophet on 2020/3/7 18:21
 */
public class FunB implements Fun {
    @Override
    public void update(String message) {
        System.out.println("我收到爱豆的消息啦:" + message);
    }
}
