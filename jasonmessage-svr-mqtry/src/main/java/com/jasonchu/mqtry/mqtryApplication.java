package com.jasonchu.mqtry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.jasonchu"})
@EnableScheduling
public class mqtryApplication {

    public static void main(String[] args) {
        SpringApplication.run(mqtryApplication.class, args);
    }

}
