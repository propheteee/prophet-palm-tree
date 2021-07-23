package com.liam.design.designmode.template;

/**
 * Description: 模版模式
 * Created by prophet on 2019/7/23 18:23
 */
public class Test {
    public static void main(String[] args) {
        //一句话归纳：流程标准化，原料自己加
        /*
        特点：
        1、执行流程固定，中间步骤有细微差别（运行时才确定）
        2、可以批量生产
         */
        new GeelyFactory().productCar();
    }
}
