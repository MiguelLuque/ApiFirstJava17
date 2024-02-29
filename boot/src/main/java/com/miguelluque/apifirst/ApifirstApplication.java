package com.miguelluque.apifirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class ApifirstApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApifirstApplication.class, args);
    }

}