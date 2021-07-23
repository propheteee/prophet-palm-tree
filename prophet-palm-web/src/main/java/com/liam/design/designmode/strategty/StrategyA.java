package com.liam.design.designmode.strategty;

/**
 * Description:
 * Created by prophet on 2019/7/23 14:06
 */
public class StrategyA implements Strategy {
    @Override
    public void doOperate(int a, int b) {
        System.out.println(a+b);
    }
}
