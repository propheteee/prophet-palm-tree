package com.liam.design.designmode.singleton;

/**
 * @author: Prophet
 * @description: 双检锁/双重校验锁（DCL，即 double-checked locking）
 * @date: 2021/7/9 4:14 下午
 */
public class DCLSingle {

    /**
     * volatile可以保证DCLSingle的可见性：
     */
    private volatile static DCLSingle DCLSingle = null;

    private DCLSingle() {
    }

    /**
     * 线程不安（不能同时保证原子性）
     * 1、DCLSingle入栈
     * 2、判断null
     * 3、创建对象
     * 使用volatile可以保证可见性和有序性：
     * t1-1 -> t2-1 -> t1-2 -> t1-3 -> t2-2（由于t2对t1的对象创建可见，所以不会生成两个对象）
     * 使用volatile无法保证原子性：
     * t1-1 -> t2-1 -> t1-2 -> t2-2 -> t1-3 -> t2-3（生成两个对象）
     * t1-1 -> t1-2 -> t2-1 -> t2-2 -> t1-3 -> t2-3（生成两个对象）
     *
     * @return
     */
    public static DCLSingle getInstance() {
        if (DCLSingle == null) {
            DCLSingle = new DCLSingle();
            return DCLSingle;
        }
        return DCLSingle;
    }

    /**
     * 1、线程安全
     * 2、阻塞问题：第一个线程getInstance1获得锁后而且创建对象成功，但是锁还未释放，后续并发过来的线程都会被阻塞，浪费cpu资源
     *
     * @return
     */
    public static synchronized DCLSingle getInstance1() {
        if (DCLSingle == null) {
            DCLSingle = new DCLSingle();
            return DCLSingle;
        }
        return DCLSingle;
    }

    /**
     * 1、线程安全
     * 2、解决阻塞问题：第一个线程getInstance1获得锁后而且创建对象成功，但是锁还未释放，后续并发过来的线程可以先判断下对象是否创建，已创建直接返回
     * 3、使用volatile修饰的原因：
     * 两个线程同时去获取锁，第一个线程获得锁后创建对象成功，锁释放，后续第二个线程获得锁后，由于栈中引用还是空，所以又会创建一次对象。
     * 使用volatile可以保证第一个线程创建对象对第二个线程可见，不会再重复创建对象
     *
     * @return
     */
    public static DCLSingle getInstance3() {
        if (DCLSingle == null) {
            synchronized (DCLSingle.class) {
                if (DCLSingle == null) {
                    DCLSingle = new DCLSingle();
                    return DCLSingle;
                }
            }
        }
        return DCLSingle;
    }


}
