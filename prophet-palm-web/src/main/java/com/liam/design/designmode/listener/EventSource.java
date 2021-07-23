package com.liam.design.designmode.listener;

/**
 * @author: Prophet
 * @description: 鼠标事件源
 * @date: 2021/7/19 3:45 下午
 */
public class EventSource implements IEvent {
    /**
     * 绑定鼠标监听器
     */
    private IEventListener mEventListener;
    boolean clickMouse;
    boolean moveMouse;

    @Override
    public void setEventListener(IEventListener arg) {
        mEventListener = arg;
    }

    /**
     * 移动鼠标
     */
    public void mouseEventHappened() {
        moveMouse = true;
        mEventListener.doEvent(this);
    }

    /**
     * 点击鼠标
     */
    public void buttonEventHappened() {
        clickMouse = true;
        mEventListener.doEvent(this);
    }

    @Override
    public boolean clickMouse() {
        return clickMouse;
    }

    @Override
    public boolean moveMouse() {
        return moveMouse;
    }
}
