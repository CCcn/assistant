package com.cdtc.student.assistant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan(value = "com.cdtc.student.assistant.servlet")
public class AssistantApplication{


    public static void main(String[] args) {

        SpringApplication.run(AssistantApplication.class, args);
    }
}
