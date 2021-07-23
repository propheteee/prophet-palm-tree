package com.liam.builder;

/**
 * Description:
 * Created by prophet on 2019/7/30 10:36
 */
public class Second extends First {
    static{
        System.out.println("静态代码块 second");
    }
    {
        System.out.println("构造代码块 second");
    }

    Second() {
        super();
        System.out.println("构造方法 second");
    }

    public static void main(String[] args) {
        Second second = new Second();
    }
}
