package com.liam.design.designmode.listener;

/**
 * @author: Prophet
 * @description: 监听器
 * @date: 2021/7/19 3:51 下午
 */
public class IEventListenerImpl implements IEventListener {

    @Override
    public void doEvent(IEvent arg) {
        if (arg.clickMouse()) {
            System.out.println("你点击了鼠标");
        } else if (arg.moveMouse()) {
            System.out.println("你移动了鼠标");
        }
    }
}
