package com.liam.design.designprinciple.open;

import java.math.BigDecimal;

/**
 * @author ：Prophet
 * @description： 开闭原则：开放扩展、关闭修改
 * @date ：2021/7/6 3:28 下午
 */
public class JavaDiscountCourseImpl extends JavaCourseImpl {

    public JavaDiscountCourseImpl(BigDecimal price) {
        super(price);
    }

    /**
     * 获取原价
     *
     * @return
     */
    public BigDecimal getOriginPrice() {
        return super.getPrice();
    }

    /**
     * 获取折扣价
     *
     * @return
     */
    @Override
    public BigDecimal getPrice() {
        return super.getPrice().multiply(BigDecimal.valueOf(0.6));
    }

    public static void main(String[] args) {
        //在不修改JavaCourseImpl的基础上，对JavaCourseImpl的price进行打折（扩展），符合开闭原则
        JavaDiscountCourseImpl java = new JavaDiscountCourseImpl(BigDecimal.valueOf(10));
        System.out.println(java.getPrice());
    }


}
