package com.liam.design.designmode.component;

/**
 * Description:组合部件
 * Created by prophet on 2020/7/18 16:53
 */
public interface School {
    void addPart(School company);
    void removePart(School company);
    void displayPart();
    //不同部门的职责
    void action();
}
