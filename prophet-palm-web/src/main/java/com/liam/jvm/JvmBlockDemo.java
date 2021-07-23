package com.liam.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by prophet on 2019/12/17 23:46
 */
public class JvmBlockDemo {
    private static List<int[]> bigObj = new ArrayList<>();
    private static List<char[]> bigCharObj = new ArrayList<>();

    public static int[] generate1M() {
        return new int[1024 * 256 * 2];//一个int是32位
    }

    public static char[] generate1MChar() {
        return new char[1024 * 2014];
    }
}
