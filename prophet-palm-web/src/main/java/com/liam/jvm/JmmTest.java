package com.liam.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by prophet on 2020/4/26 16:10
 */
public class JmmTest {
    private static List<Long> list1 = new ArrayList<>();
    private final List<Long> list2 = new ArrayList<>();
    private List<Long> list3 = new ArrayList<>();
    private String a = "1221";


    public void test() {
        //String b = "111";
        String b = new String("111");
        b = null;
        String c = b;
    }


    public void test2() {
        String b = "111";
        b = null;
        String c = b;
    }

    public static void main(String[] args) {
        String a = "111";
        String b = "111";
        System.out.println(a == b);

        JmmTest jmmTest = new JmmTest();
        jmmTest.test();
        JmmTest.list1 = null;
    }

}
