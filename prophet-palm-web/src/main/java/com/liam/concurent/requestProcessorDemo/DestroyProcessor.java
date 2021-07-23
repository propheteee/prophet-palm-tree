package com.liam.concurent.requestProcessorDemo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description:结束任务处理器
 * Created by prophet on 2020/7/31 11:07
 */
public class DestroyProcessor extends Thread implements RequestProcessor {

    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    @Override
    public void run() {
        while (true) {
            try {
                Request request = requests.take();
                System.out.println("destory  request info:" + request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processRequest(Request request) {
        requests.add(request);
    }
}
