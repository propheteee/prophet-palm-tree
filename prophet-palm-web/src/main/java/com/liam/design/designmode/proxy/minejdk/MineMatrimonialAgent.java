package com.liam.design.designmode.proxy.minejdk;

import com.liam.design.designmode.proxy.jdk.Person;

import java.lang.reflect.Method;

/**
 * Description:
 * Created by prophet on 2019/7/18 15:07
 */
public class MineMatrimonialAgent implements MineInvoicationHandler {
    private Person person;

    //something about the proxy object
    public Object getInstance(Person person) {
        this.person = person;
        Class aClass = person.getClass();
        System.out.println("the proxy class:" + person.getClass());
        return MineProxy.newInstance(new MineClassLoader(), aClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("welcome,begin marriage");
        method.invoke(this.person, args);
        System.out.println("welcome,end marriage");
        return null;
    }
}
