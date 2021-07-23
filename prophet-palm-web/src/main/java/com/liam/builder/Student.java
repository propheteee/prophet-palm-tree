package com.liam.builder;

import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * Created by prophet on 2019/8/12 10:28
 */
@Data
public class Student {
    private int id;
    private Integer age;
    private String name;

    public Student(int age) {
        this.age = age;
    }

    //@Override
    //public int compareTo(Student o) {
    //
    //
    //    /*
    //    负整数	当前对象的值 < 比较对象的值 ， 位置排在前
    //    零	    当前对象的值 = 比较对象的值 ， 位置不变
    //    正整数	当前对象的值 > 比较对象的值 ， 位置排在后
    //     */
    //    //return this.age - o.age;//升序
    //    return o.age - this.age; //降序
    //}


    public static void main(String[] args) {
        Student student = new Student(1);
        Student student1 = new Student(2);
        List<Student> students = Arrays.asList(student, student1);
//        Collections.sort(students);
        students.sort((o1, o2) -> o1.getAge().compareTo(o2.getAge()));
        students.sort((o1, o2) -> o2.getAge() - o1.getAge());
    }


}
