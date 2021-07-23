package com.liam.builder;

/**
 * Description:
 * Created by prophet on 2019/7/30 10:34
 */
public class First {
    static {
        System.out.println("静态代码块 first");
    }

    {
        System.out.println("构造代码块 first");
    }

    First() {
        System.out.println("构造方法 first");
    }
}
