package com.liam.concurent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description:火箭发射
 * Created by prophet on 2019/8/2 16:11
 */
public class CountDownLatchDemo {
    private static final CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                try {
                    //模拟检查任务
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "chack 1 complete");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //计数器减一:通知CountDownLatch有一个线程已经准备完毕
                    countDownLatch.countDown();
                }
            });
        }
        //要求主线程等待所有10个检查任务全部准备好才一起并行执行
        countDownLatch.await();
        System.out.println("开火");
    }

    static class joinTest {
        public static void main(String[] args) {
            Thread t1 = new Thread(new Work(null));
            Thread t2 = new Thread(new Work(t1));
            Thread t3 = new Thread(new Work(t2));
            t1.start();
            t2.start();
            t3.start();

        }

        static class Work implements Runnable {
            private Thread beforeThread;

            public Work(Thread beforeThread) {
                this.beforeThread = beforeThread;
            }

            public void run() {
                if (beforeThread != null) {
                    try {
                        beforeThread.join();
                        System.out.println("thread start:" + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("thread start:" + Thread.currentThread().getName());
                }
            }
        }
    }

    static class countDownLatchTest {

        // T1、T2、T3三个线程顺序执行
        public static void main(String[] args) {
            CountDownLatch c0 = new CountDownLatch(0); //计数器为0
            CountDownLatch c1 = new CountDownLatch(1); //计数器为1
            CountDownLatch c2 = new CountDownLatch(1); //计数器为1

            Thread t1 = new Thread(new Work(c0, c1));
            //c0为0，t1可以执行。t1的计数器减1

            Thread t2 = new Thread(new Work(c1, c2));
            //t1的计数器为0时，t2才能执行。t2的计数器c2减1

            Thread t3 = new Thread(new Work(c2, c2));
            //t2的计数器c2为0时，t3才能执行

            t1.start();
            t2.start();
            t3.start();

        }

        //定义Work线程类，需要传入开始和结束的CountDownLatch参数
        static class Work implements Runnable {
            CountDownLatch c1;
            CountDownLatch c2;

            Work(CountDownLatch c1, CountDownLatch c2) {
                super();
                this.c1 = c1;
                this.c2 = c2;
            }

            public void run() {
                try {
                    c1.await();//前一线程为0才可以执行
                    System.out.println("thread start:" + Thread.currentThread().getName());
                    c2.countDown();//本线程计数器减少
                } catch (InterruptedException e) {
                }

            }
        }
    }
}