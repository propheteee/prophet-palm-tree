package com.liam.design.designmode.factory.simpleFactory;

import org.springframework.util.StringUtils;

/**
 * Description:
 * Created by prophet on 2019/7/19 09:06
 */
public class Factory {
    public static Car getCar(String type) {
        //不符合开闭原则
        if ("bmw".equals(type)) {
            return new BmwCar();
        } else if ("benchi".equals(type)) {
            return new BenchiCar();
        } else {
            System.out.println("不符合要求");
            return null;
        }
    }

    public static Car getCar1(String className) throws Exception {
        if (!StringUtils.isEmpty(className)) {
            return (Car) Class.forName(className).newInstance();
        }
        return null;
    }

    public static Car getCar2(Class<? extends Car> className) throws Exception {
        if (!StringUtils.isEmpty(className)) {
            return className.newInstance();
        }
        return null;
    }
}
