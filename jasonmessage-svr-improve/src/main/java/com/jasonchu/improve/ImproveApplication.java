package com.jasonchu.improve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.jasonchu"})
@EnableScheduling
public class ImproveApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImproveApplication.class, args);
    }

}
