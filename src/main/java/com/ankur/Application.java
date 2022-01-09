package com.ankur;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("Mock Service Started !!");
        SpringApplication.run(Application.class, args);
    }
}
