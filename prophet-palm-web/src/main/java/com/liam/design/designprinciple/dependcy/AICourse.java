package com.liam.design.designprinciple.dependcy;

/**
 * @author ：Prophet
 * @description：
 * @date ：2021/7/6 4:11 下午
 */
public class AICourse implements Course {
    @Override
    public void study() {
        System.out.println("study AI");
    }
}
