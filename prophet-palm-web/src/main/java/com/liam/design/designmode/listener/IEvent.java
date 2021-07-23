package com.liam.design.designmode.listener;

/**
 * @author: Prophet
 * @description: 事件（被监听的对象）
 * @date: 2021/7/19 3:49 下午
 */
public interface IEvent {

    /**
     * 绑定监听器
     * @param arg
     */
    void setEventListener(IEventListener arg);

    /**
     * 是否点击鼠标
     * @return
     */
    boolean clickMouse();

    /**
     * 是否移动鼠标
     * @return
     */
    boolean moveMouse();
}


