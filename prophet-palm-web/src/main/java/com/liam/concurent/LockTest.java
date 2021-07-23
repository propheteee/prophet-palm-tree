package com.liam.concurent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * Created by prophet on 2020/3/2 22:24
 */
public class LockTest {
    int i = 0;

    public void run() throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        if (reentrantLock.tryLock()) {
            if (reentrantLock.isLocked()) {

            }
            reentrantLock.wait();
            Thread.sleep(1000);
            i++;
            reentrantLock.unlock();
        } else {
            System.out.println("没获取到锁，gg斯密达");
        }
    }
}
