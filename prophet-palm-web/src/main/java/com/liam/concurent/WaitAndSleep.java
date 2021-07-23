package com.liam.concurent;

/**
 * Description:
 * Created by prophet on 2020/2/26 09:48
 */
public class WaitAndSleep {

    final static Object person = new Object();

    public static class T1 extends Thread {
        public void run() {
            synchronized (person) {
                System.out.println(System.currentTimeMillis() + "T1 come");
                try {
                    System.out.println(System.currentTimeMillis() + "T1 wait");
                    //当前线程释放锁并进入wait等待队列
                    person.wait();
                } catch (InterruptedException r) {
                    r.getStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "T1 over");
            }
        }
    }

    public static class T2 extends Thread {
        public void run() {
            synchronized (person) {
                System.out.println(System.currentTimeMillis() + "T2 come");
                try {
                    //唤醒wait等待队列里的线程并进入同步队列
                    person.notify();
                    Thread.sleep(2000);
                } catch (InterruptedException r) {
                    r.getStackTrace();
                }
                System.out.println(System.currentTimeMillis() + "T2 over");
            }
        }
    }

    public static void main(String args[]) {
        try {
            Thread thread1 = new T1();
            Thread thread2 = new T2();
            thread1.start();
            thread2.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
