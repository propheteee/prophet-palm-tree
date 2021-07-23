package com.liam.design.designmode.component;

/**
 * Description:叶子部件：在组合中表示子节点对象
 * Created by prophet on 2020/7/18 16:55
 */
public class DiningPart implements School {

    private String name;

    @Override
    public void addPart(School company) {

    }

    public DiningPart(String name
    ) {
        this.name = name;
    }

    @Override
    public void removePart(School company) {

    }

    @Override
    public void displayPart() {

    }

    @Override
    public void action() {
        System.out.println("我是" + name);
    }
}
