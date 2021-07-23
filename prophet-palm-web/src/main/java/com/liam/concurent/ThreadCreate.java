package com.liam.concurent;

import java.util.concurrent.*;

/**
 * Description:
 * Created by prophet on 2020/3/2 12:43
 */
public class ThreadCreate {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        //创建一个固定数目的线程池
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        //创建一个单线程化的Excutor
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        //创建一个可缓存的线程池，调用execute方法将重用以前创建的线程，如果没有可用线程则创建一个新的线程并添加到池中。终止并移除那些已经存在60s未被使用的线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建一个定时及周期性执行任务的线程池。
        ExecutorService executorService3 = Executors.newScheduledThreadPool(1);

        /*
         1、FixedThreadPool和SingleThreadPool 默认使用LinkedBlockingQueue 是一个以链表实现的有界阻塞队列，不设置的话是无界的最大长度为Integer.MAX_VALUE，可能导致内存溢出。
            ArrayBlockingQueue是必须要设置大小
         2、CachedThreadPool和shceduledThreadPool允许创建的线程数量是Integer.MAX_VALUE 同样会出现内存溢出。
         */
        Executor executor = new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2));
        for(int i=0;i<9;i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("111");
                }
            });
        }

    }

    static class CreateByThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }

        public static void main(String[] args) {
            CreateByThread threadCreateTest = new CreateByThread();
            threadCreateTest.start();
        }
    }

    static class CreateByRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }

        public static void main(String[] args) {
            Thread thread = new Thread(new CreateByRunnable());
            thread.start();
        }
    }

    static class CreateByCallable implements Callable<String> {

        @Override
        public String call() {
            return Thread.currentThread().getName();
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            FutureTask<String> futureTask = new FutureTask<>(new CreateByCallable());
            Thread thread = new Thread(futureTask);
            thread.start();
            System.out.println(futureTask.get());
        }
    }

    static class CreateByExecutor {
        public static void main(String[] args) {
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }

    }

    static class CreateByExcutorFuture {
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            Future<String> future1 = executorService.submit(() -> {
                return Thread.currentThread().getName();
            });
            System.out.println(future1.get());
            executorService.shutdown();

        }
    }

    //futureTask 一个可以取消的异步运算，它有启动和取消运算、查询运算是否完成和取回运算结果等方法
    static class CreateByExcutorFuture2 {
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            ExecutorService executorService = Executors.newFixedThreadPool(5);
            FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "futureTask say HelloWorld!!!";
                }
            });
            executorService.execute(futureTask);
            futureTask.cancel(true);
            boolean done = futureTask.isDone();
            if (done) {
                System.out.println(futureTask.get());
            } else {

            }
            executorService.shutdown();

        }
    }
}
