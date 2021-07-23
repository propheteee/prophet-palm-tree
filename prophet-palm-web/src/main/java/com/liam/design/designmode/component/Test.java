package com.liam.design.designmode.component;

/**
 * Description:
 * 1、将对象组合成树形结构以表示“部分-整体”的层次结构，
 * 2、用户对单个对象和合成对象的使用具有一致性
 * Created by prophet on 2020/7/18 17:06
 */
public class Test {
    public static void main(String[] args) {
        //总校
        CompositeSchool rootSchool = new CompositeSchool("总校");
        rootSchool.addPart(new DiningPart("总校食堂"));
        rootSchool.addPart(new LibraryPart("总校图书馆"));
        CompositeSchool compositeSchool = new CompositeSchool("分校");
        compositeSchool.addPart(new DiningPart("分校食堂"));
        compositeSchool.addPart(new LibraryPart("分校图书馆"));
        rootSchool.addPart(compositeSchool);

        //用户可以忽略合成对象与单个对象的不同，用户将统一地使用组合结构中的所有对象。
        rootSchool.displayPart();
        rootSchool.action();
    }
}
