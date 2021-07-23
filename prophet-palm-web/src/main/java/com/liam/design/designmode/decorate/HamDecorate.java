package com.liam.design.designmode.decorate;

/**
 * @author ：Prophet
 * @description： 扩展套餐的抽象装饰类
 * @date ：2021/7/16 5:37 下午
 */
public class HamDecorate extends PancakeDecorate {

    public HamDecorate(AbstractPancake abstractPancake) {
        super(abstractPancake);
    }

    @Override
    String getMsg() {
        return super.getMsg()+"+1个火腿";
    }

    @Override
    Integer getPrice() {
        return super.getPrice()+2;
    }
}
