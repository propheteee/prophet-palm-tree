package com.liam.design.designmode.decorate;

/**
 * @author ：Prophet
 * @description：
 * @date ：2021/7/16 5:37 下午
 */
public class EggDecorate extends PancakeDecorate {

    public EggDecorate(AbstractPancake abstractPancake) {
        super(abstractPancake);
    }

    @Override
    String getMsg() {
        return super.getMsg()+"+1个鸡蛋";
    }

    @Override
    Integer getPrice() {
        return super.getPrice()+1;
    }
}
