package com.bz.spring.springcloud.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.bz.spring.*")
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class Application {

    public Application(){
        //For Spring
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}