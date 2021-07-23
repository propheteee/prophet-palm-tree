package com.liam.design.designprinciple.replace;

import java.math.BigDecimal;

/**
 * @author ：Prophet
 * @description： 里氏替换原则：子类可以扩展父类的功能但不能改变父类原有的功能（兼容性好）。
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
     * 不重写，更改方法名，符合里氏替换原则
     *
     * @return
     */
    public BigDecimal getDiscountPrice() {
        return super.getPrice().multiply(BigDecimal.valueOf(0.6));
    }

//    /**
//     * 获取折扣价
//     * 重写，不符合里氏替换原则
//     *
//     * @return
//     */
//    @Override
//    public BigDecimal getPrice() {
//        return super.getPrice().multiply(BigDecimal.valueOf(0.6));
//    }
//
//    /**
//     * 获取折扣价
//     * 重载，方法入参要比父类更宽松，出参要比父类更严格或相等，符合里氏替换原则
//     *
//     * @param i
//     * @return
//     */
//    public BigDecimal getPrice(int i) {
//        return super.getPrice().multiply(BigDecimal.valueOf(0.6));
//    }


    public static void main(String[] args) {
        //在不修改JavaCourseImpl的基础上，对JavaCourseImpl的price进行打折（扩展），符合开闭原则
        JavaDiscountCourseImpl java = new JavaDiscountCourseImpl(BigDecimal.valueOf(10));
        System.out.println(java.getDiscountPrice());
    }


}
