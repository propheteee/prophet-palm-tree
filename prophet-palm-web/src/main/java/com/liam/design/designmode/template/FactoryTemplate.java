package com.liam.design.designmode.template;

/**
 * Description:
 * Created by prophet on 2019/7/23 18:11
 */
public abstract class FactoryTemplate {
    public void productCar() {
        System.out.println("先准备材料，轮子啊，发动机啊。。。");
        ui();
        design();
        System.out.println("最后准备出厂卖");
    }

    public abstract void ui();
    public abstract void design();
}
