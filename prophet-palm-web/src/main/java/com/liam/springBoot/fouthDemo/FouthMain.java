package com.liam.springBoot.fouthDemo;

import com.liam.springBoot.thirdDemo.EnableDemoMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class FouthMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext ca= SpringApplication.run(EnableDemoMain.class,args);

        //System.out.println(ca.getBean(GupaoCore.class).study());
    }
}
