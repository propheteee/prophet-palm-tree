package com.liam.design.designmode.listener;

/**
 * @author: Prophet
 * @description: 鼠标监听器
 * @date: 2021/7/19 3:46 下午
 */
public interface IEventListener {
    /**
     * 处理事件
     * @param arg
     */
    void doEvent(IEvent arg);
}
