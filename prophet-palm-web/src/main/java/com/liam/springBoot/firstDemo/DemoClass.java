package com.liam.springBoot.firstDemo;

//希望这个类被spring 托管

import org.springframework.stereotype.Service;

/**
 * <bean name="" class="com.gupaoedu.springboot.springbootfirst.fristDemo.Democlass"/>  基于xml配置的spring
 * javaconfig  基于java配置的spring
 * autoconfiguration  (简化我们bean的注入逻辑）
 */
@Service
public class DemoClass {

    public void say(){
        System.out.println("Say: Hello Mic");
    }
}


