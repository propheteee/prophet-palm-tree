package com.liam.concurent.requestProcessorDemo;

/**
 * Description: 创建多个任务处理线程，基于阻塞队列执行请求  完成print-save-destroy
 * Created by prophet on 2020/7/31 11:14
 */
public class Demo {

    PrintProcessor printProcessor;

    protected Demo() {
        DestroyProcessor destroyProcessor = new DestroyProcessor();
        destroyProcessor.start();

        SaveProcessor saveProcessor = new SaveProcessor(destroyProcessor);
        saveProcessor.start();

        printProcessor = new PrintProcessor(saveProcessor);
        printProcessor.start();
    }

    private void doTest(Request request) {
        printProcessor.processRequest(request);
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName("rick");
        new Demo().doTest(request);
    }
}
