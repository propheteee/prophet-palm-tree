package com.liam.springBoot.thirdDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDefineService(exclude = {LoggerService.class})
public class EnableDemoMain {

    public static void main(String[] args) {
        ConfigurableApplicationContext ca = SpringApplication.run(EnableDemoMain.class, args);

        System.out.println(ca.getBean(CacheService.class));
        System.out.println(ca.getBean(LoggerService.class));
    }


}
