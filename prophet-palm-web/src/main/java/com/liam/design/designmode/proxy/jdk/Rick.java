package com.liam.design.designmode.proxy.jdk;

/**
 * @author prophet
 * @date 2019/7/17  17:08
 */
public class Rick implements Person {
    @Override
    public Integer seekingPartner() {
        System.out.println("Look for a good looking partner");
        return 1;
    }

    @Override
    public Integer seekingChildren() {
        System.out.println("Look for my lost children");
        return null;
    }
}
