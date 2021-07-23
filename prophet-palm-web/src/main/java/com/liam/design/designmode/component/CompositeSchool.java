package com.liam.design.designmode.component;

import java.util.List;

/**
 * Description:合成部件：表示自己还有子节点。
 * Created by prophet on 2020/7/18 16:55
 */
public class CompositeSchool implements School {

    private List<School> paters;
    private String name;

    public CompositeSchool(String name) {
        this.name = name;
    }

    @Override
    public void addPart(School company) {
        paters.add(company);
    }

    @Override
    public void removePart(School company) {
        paters.remove(company);
    }

    @Override
    public void displayPart() {
        for (School pater : paters) {
            pater.displayPart();
        }
    }

    @Override
    public void action() {
        for (School pater : paters) {
            pater.action();
        }
    }
}
