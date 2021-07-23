package com.liam.design.designmode.listener;

/**
 * Description:监听器模式：给某个事件绑定一个监听器，当事件触发时监听器同步执行相应逻辑
 * Created by prophet on 2019/8/5 19:08
 */
public class Test {
    public static void main(String[] args) {
        EventSource m1 = new EventSource();
        IEventListener mEventListener = new IEventListenerImpl();
        m1.setEventListener(mEventListener);
        m1.mouseEventHappened();
        m1.buttonEventHappened();
    }
}
