package com.liam.design.designmode.template;

/**
 * Description:
 * Created by prophet on 2019/7/23 18:18
 */
public class BMWFactory extends FactoryTemplate {
    @Override
    public void ui() {
        System.out.println("白色的吧");
    }

    @Override
    public void design() {
        System.out.println("设计成大巴");
    }
}
