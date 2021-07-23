package com.liam.design.designprinciple.replace;

import java.math.BigDecimal;

/**
 * @author ：Prophet
 * @description：
 * @date ：2021/7/6 3:28 下午
 */
public class JavaCourseImpl implements Course {

    private BigDecimal price;

    public JavaCourseImpl(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

}
