package com.liam.design.designmode.strategty;

/**
 * @author: Prophet
 * @description:
 * @date: 2021/7/19 6:28 下午
 */
public class Test {
    public static void main(String[] args) {
        new Context(new StrategyA()).executeStrategy(2, 1);
        new Context(new StrategyB()).executeStrategy(2, 1);
    }
}
