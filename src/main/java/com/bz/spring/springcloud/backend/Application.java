package com.bz.spring.springcloud.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy(proxyTargetClass=true)
@ComponentScan("com.bz.spring.*")
@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		AopAutoConfiguration.class
} )
public class Application {

    public Application(){
        //For Spring
    	
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}