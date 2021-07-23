package com.liam.design.designmode.proxy.jdk;


import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * Description:
 * Created by prophet on 2019/7/17 17:16
 */
public class Test {
    public static void main(String[] args) throws IOException {
       /*
        特点：
        1、执行者和被代理人
	    2、对于被代理人，有些事情要做但是自己不做，需要找代理
	    2、执行者需要被代理人的个人信息
        */

       /*
        原理：字节码重组
        1、获取被代理对象的的类加载器、接口信息、执行者（含有增强的方法）
        2、JDK代理重新生成一个类，继承Proxy（存放执行者的引用），同时实现被代理接口（获取接口方法）
        3、编译生成字节码文件
        4、使用类加载器加载class文件到jvm
        5、执行方法
        */
        Rick rick = new Rick();
        Person person = (Person) Proxy.newProxyInstance(rick.getClass().getClassLoader(), rick.getClass().getInterfaces(), new MatrimonialInvocationHandler(rick));
        System.out.println(person.seekingChildren());

        //获取代理对象的字节码内容
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{person.getClass()});
        FileOutputStream file = new FileOutputStream("$Proxy0.class");
        file.write(data);
        file.close();
        System.out.println("agent class:" + person.getClass());
        person.seekingPartner();


    }
}
