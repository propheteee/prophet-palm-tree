package com.liam.design.designprinciple.dependcy;

/**
 * @author ：Prophet
 * @description： 依赖倒置原则：依赖抽象接口开发，而不是依赖具体实现开发
 * @date ：2021/7/6 4:09 下午
 */
public class Tom2 {

    private Course course;

    public void study(Course course) {
        course.study();
    }

    public static void main(String[] args) {
        //在Tom2中将依赖注入后，基于接口开发
        Tom2 tom2 = new Tom2();
        tom2.study(new EnglishCourse());
        tom2.study(new MathCourse());
        tom2.study(new AICourse());
    }

}
