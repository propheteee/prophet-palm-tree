package com.liam.design.designmode.strategty;

/**
 * Description:
 * Created by prophet on 2019/7/23 14:07
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int a, int b) {
        strategy.doOperate(a, b);
    }
}
