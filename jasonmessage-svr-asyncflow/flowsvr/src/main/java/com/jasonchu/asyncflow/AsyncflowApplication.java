package com.jasonchu.asyncflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Administrator
 */
@SpringBootApplication(scanBasePackages = {"com.jasonchu"})
@EnableScheduling
public class AsyncflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncflowApplication.class, args);
    }

}
