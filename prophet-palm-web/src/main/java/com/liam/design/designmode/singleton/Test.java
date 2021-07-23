package com.liam.design.designmode.singleton;

import java.util.Arrays;

/**
 * Description:
 * Created by prophet on 2019/7/19 14:05
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(DCLSingle.getInstance());
        System.out.println(StaticSingle.getInstance());
        EnumSingle instance = EnumSingle.INSTANCE;
        instance.setCode(1);
        instance.setNames(Arrays.asList("zhangsan","lisi"));
    }
}
