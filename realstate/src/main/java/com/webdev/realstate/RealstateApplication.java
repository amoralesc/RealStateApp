package com.webdev.realstate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dependencies.xml")
public class RealstateApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealstateApplication.class, args);
    }

}
