package com.liam.design.designprinciple.singletask;

/**
 * @author ：Prophet
 * @description：
 * @date ：2021/7/6 5:57 下午
 */
public class Course {
    public void study(Integer type) {
        if (type == 1) {
            System.out.println("english");
        } else {
            System.out.println("math");
        }
    }

    public static void main(String[] args) {
        //Course职责过多，耦合在一起
        Course course = new Course();
        course.study(1);
        course.study(2);
    }
}
