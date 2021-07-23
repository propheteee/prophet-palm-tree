package com.liam.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by prophet on 2019/7/25 10:57
 */
public abstract class QueryBuiler {
    private final List<QueryBuiler> queryBuilers = new ArrayList<>();
    public  QueryBuiler must(QueryBuiler queryBuiler){
        queryBuilers.add(queryBuiler);
        return this;
    }

}
