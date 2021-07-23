package com.liam.builder;

/**
 * Description:
 * Created by prophet on 2019/7/30 10:29
 */
public class A extends Exception {
}

class B extends A{

}

class C{
    public static void main(String[] args) {
        try {
            try {
                throw new B();
            } catch (A a) {
                System.out.println("catch a");
                throw a;
            }
        } catch (B b) {
            System.out.println("catch b");
        } catch (Exception e) {
            System.out.println("catch e");
        } finally {
            System.out.println("hellop c");
        }
    }
}

