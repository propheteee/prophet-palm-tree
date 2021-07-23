package com.liam.design.designmode.factory.methodFactory;

import com.liam.design.designmode.factory.simpleFactory.Car;

/**
 *
 */
public interface MethodFactory {
    /**
     * 生成汽车，具体什么标准让实现类去定义
     *
     * @return
     */
    public Car getCar();
}
