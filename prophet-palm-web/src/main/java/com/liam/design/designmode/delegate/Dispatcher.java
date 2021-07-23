package com.liam.design.designmode.delegate;

/**
 * Description:
 * Created by prophet on 2019/7/19 14:58
 */
public class Dispatcher implements IExecutor {
    private IExecutor iExecutor;
    //项目经理，工作是分配任务
    @Override
    public void work() {
        iExecutor.work();
    }

    public Dispatcher(IExecutor iExecutor) {
        this.iExecutor = iExecutor;
    }

}
