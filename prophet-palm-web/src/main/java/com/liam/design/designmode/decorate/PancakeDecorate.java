package com.liam.design.designmode.decorate;

/**
 * @author ：Prophet
 * @description： 扩展套餐的装饰类
 * @date ：2021/7/16 5:37 下午
 */
public class PancakeDecorate extends AbstractPancake {

    private AbstractPancake abstractPancake;

    public PancakeDecorate(AbstractPancake abstractPancake) {
        this.abstractPancake = abstractPancake;
    }

    @Override
    String getMsg() {
        return abstractPancake.getMsg();
    }

    @Override
    Integer getPrice() {
        return abstractPancake.getPrice();
    }
}
