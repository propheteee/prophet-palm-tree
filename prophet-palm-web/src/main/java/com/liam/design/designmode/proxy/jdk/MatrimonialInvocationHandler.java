package com.liam.design.designmode.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * agent
 * @author prophet
 * @date 2019/7/17  17:09
 */
public class MatrimonialInvocationHandler implements InvocationHandler {

    private Person person;

    public MatrimonialInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("the matrimonial agent begin find 。。。。");
        method.invoke(this.person, args);
        System.out.println("prepare for the marriage");
        return null;
    }
}
