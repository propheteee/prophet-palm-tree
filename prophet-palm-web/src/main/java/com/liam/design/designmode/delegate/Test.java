package com.liam.design.designmode.delegate;

/**
 * Description:委派模式
 * Created by prophet on 2019/7/19 16:00
 */
public class Test {
    public static void main(String[] args) {
        //一句话归纳：干活是你的（普通员工），功劳是我的（项目经历）
        /*
        特点：
        1、两个参与角色，一个委托人，一个被委托人
        2、委托人和被委托人实现同一个接口
        3、委托人有被委托人的引用
        4、委托人不关心过程（普通员工的工作过程），只关心结果
         */
        Dispatcher dispatcher = new Dispatcher(new MemberA());
        dispatcher.work();
    }
}
