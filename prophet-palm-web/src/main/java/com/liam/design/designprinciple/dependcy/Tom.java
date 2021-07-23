package com.liam.design.designprinciple.dependcy;

/**
 * @author ：Prophet
 * @description：
 * @date ：2021/7/6 4:06 下午
 */
public class Tom {

    public void studyEnglish() {
        System.out.println("study english");
    }

    public void studyMath() {
        System.out.println("study math");
    }

    public static void main(String[] args) {
        //Tom就是基于实现开发
        Tom tom = new Tom();
        tom.studyEnglish();
        tom.studyMath();
    }
}
