package com.liam.concurent.requestProcessorDemo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Description:保存任务处理器
 * Created by prophet on 2020/7/31 11:07
 */
public class SaveProcessor extends Thread implements RequestProcessor {
    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private final RequestProcessor nextProcessor;

    public SaveProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Request request = requests.take();
                System.out.println("save  request info:" + request);
                nextProcessor.processRequest(request);
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
