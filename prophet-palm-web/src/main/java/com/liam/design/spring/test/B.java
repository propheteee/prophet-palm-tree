package com.liam.design.spring.test;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * @author ：Prophet
 * @description：
 * @date ：2021/7/23 9:54 下午
 */
@Service
@Lazy
public class B {
    @Setter
    @Getter
    private A a;
}
