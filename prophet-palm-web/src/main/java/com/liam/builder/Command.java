package com.liam.builder;

import java.lang.annotation.*;

/**
 * Description:
 * Created by prophet on 2019/7/25 10:39
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})

public @interface Command {
    String name() default "";

    CommandEnum command() default CommandEnum.IS;
}
