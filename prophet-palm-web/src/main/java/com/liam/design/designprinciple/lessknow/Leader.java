package com.liam.design.designprinciple.lessknow;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：Prophet
 * @description：
 * @date ：2021/7/6 6:23 下午
 */
public class Leader {
    public void getMemberNum(List<Member> members) {
        System.out.println("一共有" + members.size() + "个成员");
    }

    public void getMemberNum2() {
        //模拟leader一页一页翻成员名单
        List<Member> members = Arrays.asList(new Member(), new Member());
        System.out.println("一共有" + members.size() + "个成员");
    }
}
