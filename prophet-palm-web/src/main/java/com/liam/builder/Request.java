package com.liam.builder;

import java.io.Serializable;

/**
 * Description:
 * Created by prophet on 2019/7/25 10:35
 */
public class Request implements Serializable {
    private static final long serialVersionUID = -8847721123607942165L;

    @Command(name = "id", command = CommandEnum.IS)
    private Long id;
    @Command(name = "name", command = CommandEnum.SIMILAR)
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
