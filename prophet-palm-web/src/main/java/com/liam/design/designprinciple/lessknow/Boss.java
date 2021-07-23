package com.liam.design.designprinciple.lessknow;


import java.util.Arrays;
import java.util.List;

/**
 * @author ：Prophet
 * @description： 迪米特原则：又叫最少知道原则，一个类对其所依赖的类知道得越少越好。
 * @date ：2021/7/6 6:23 下午
 */
public class Boss {
    /**
     * boss知道了太多leader要做的工作细节，不符合迪米特原则
     *
     * @param leader
     */
    public void getMember(Leader leader) {
        //模拟boss一页一页翻成员名单
        List<Member> members = Arrays.asList(new Member(), new Member());
        leader.getMemberNum(members);
    }

    /**
     * boss无需知道leader要做的工作细节，符合迪米特原则
     *
     * @param leader
     */
    public void getMember2(Leader leader) {
        leader.getMemberNum2();
    }

    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.getMember(new Leader());
        boss.getMember2(new Leader());
    }
}
