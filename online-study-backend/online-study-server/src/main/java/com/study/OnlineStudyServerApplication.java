package com.study;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class OnlineStudyServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineStudyServerApplication.class, args);
        log.info("server started");
    }

}
