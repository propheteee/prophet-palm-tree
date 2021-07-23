package com.liam.design.designmode.delegate;

/**
 * Description:
 * Created by prophet on 2019/7/19 14:55
 */
public class MemberA implements IExecutor {
    @Override
    public void work() {
        System.out.println("A begin working");
    }
}
