package com.rti.bugtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan(basePackageClasses = BugTrackerController.class)
//@PropertySource("classpath:application.properties")

public class Application  {


    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
