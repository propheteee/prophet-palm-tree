package com.liam.design.designmode.proxy.staticproxy;

/**
 * @author ：Prophet
 * @description：
 * @date ：2021/7/19 1:49 下午
 */
public class Father {
    private Son son;

    public void findPartner() {
        System.out.println("find agent");
        son.findPartner();
        System.out.println("marrying");
    }
}
