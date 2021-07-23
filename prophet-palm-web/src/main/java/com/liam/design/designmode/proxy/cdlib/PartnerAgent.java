package com.liam.design.designmode.proxy.cdlib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Description:执行者
 * Created by prophet on 2019/7/18 17:08
 */
public class PartnerAgent implements MethodInterceptor {
    public Object getProxyInstance(Class classes) {
        Enhancer enhancer = new Enhancer();
        //需要继承的类
        enhancer.setSuperclass(classes);
        //回调执行者
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("find the sex partner");
        //这里的o是cglib new出来的被代理对象的子类，因为是继承，所以也包含了父类
        methodProxy.invokeSuper(o, args);
        System.out.println("go to the marriage hall");
        return null;
    }
}
