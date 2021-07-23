package com.liam.design.designmode.template;

/**
 * Description:
 * Created by prophet on 2019/7/23 18:17
 */
public class GeelyFactory extends FactoryTemplate {
    @Override
    public void ui() {
        System.out.println("给个红色的外壳");
    }

    @Override
    public void design() {
        System.out.println("设计成跑车");
    }
}
