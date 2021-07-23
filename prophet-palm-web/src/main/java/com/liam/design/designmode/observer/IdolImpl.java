package com.liam.design.designmode.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by prophet on 2020/3/7 18:19
 */
public class IdolImpl implements Idol {

    private List<Fun> funs = new ArrayList<>();

    @Override
    public void addFun(Fun fun) {
        funs.add(fun);
    }

    @Override
    public void removeFun(Fun fun) {
        funs.remove(fun);
    }

    @Override
    public void notifyA(String message) {
        for (Fun fun : funs) {
            fun.update(message);
        }
    }
}
