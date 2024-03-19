package com.example.test_2;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class Test2Application {

    public static void main(String[] args) {
        log.config("start");SpringApplication.run(Test2Application.class, args);
    }

}
