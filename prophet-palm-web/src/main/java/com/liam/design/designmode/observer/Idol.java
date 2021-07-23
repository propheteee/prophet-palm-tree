package com.liam.design.designmode.observer;

/**
 * Description:
 * Created by prophet on 2020/3/7 18:18
 */
public interface Idol {
    public void addFun(Fun fun);

    public void removeFun(Fun fun);

    public void notifyA(String message);
}
