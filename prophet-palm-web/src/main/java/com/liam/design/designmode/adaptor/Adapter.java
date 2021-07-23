package com.liam.design.designmode.adaptor;

/**
 * Description:适配器类
 * Created by prophet on 2019/12/22 21:45
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.adapteeRequest();
    }
}
