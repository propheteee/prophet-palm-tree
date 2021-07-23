package com.liam.design.designmode.decorate;

/**
 * @author ：Prophet
 * @description：
 * @date ：2021/7/16 5:44 下午
 */
public class BasePancake extends AbstractPancake {
    @Override
    String getMsg() {
        return "煎饼";
    }

    @Override
    Integer getPrice() {
        return 5;
    }
}
