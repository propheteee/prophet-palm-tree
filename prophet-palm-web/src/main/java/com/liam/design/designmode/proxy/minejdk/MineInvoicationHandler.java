package com.liam.design.designmode.proxy.minejdk;

import java.lang.reflect.Method;

/**
 * Description:
 * Created by prophet on 2019/7/18 15:03
 */
public interface MineInvoicationHandler {

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
