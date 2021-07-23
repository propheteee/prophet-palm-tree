package com.liam.design.designmode.singleton;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Prophet
 * @description：
 * @date ：2021/7/9 4:15 下午
 */
public enum EnumSingle {
    INSTANCE(1, new ArrayList<>());
    @Getter
    @Setter
    private Integer code;
    @Setter
    @Getter
    private List<String> names;

    <T> EnumSingle(int i, List<T> asList) {

    }

    public Integer whateverMethod() {
        return INSTANCE.code;
    }
}
