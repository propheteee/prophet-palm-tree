package com.liam.design.designmode.singleton;

/**
 * @author: Prophet
 * @description: 静态内部类
 * @date: 2021/7/9 4:09 下午
 */
public class StaticSingle {

    private static final StaticSingle INSTANCE = new StaticSingle();

    /**
     * 静态常量：只要Singleton类被装载了，那么INSTANCE就会被实例化
     *
     * @return
     */
    public static StaticSingle getInstance() {
        return INSTANCE;
    }




    private static class LazyHolder {
        private static final StaticSingle INSTANCE1 = new StaticSingle();
    }

    /**
     * 静态内部类：可以确保调用getInstance1的时候才会初始化。
     *
     * @return
     */
    public static StaticSingle getInstance1() {
        return LazyHolder.INSTANCE1;
    }
}
